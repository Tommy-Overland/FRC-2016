package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.ArmMotors;
import org.usfirst.frc.team2976.robot.subsystems.LeftEncoderPIDSource;
import org.usfirst.frc.team2976.robot.subsystems.PIDMain;
import org.usfirst.frc.team2976.robot.subsystems.RightEncoderPIDSource;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *@author NeilHazra
 */
public class ArmDynamicSetpointPID extends Command {
	final int ARM_SPEED_REDUCER = 4;
	int ArmMinEncoderValue = 0;
	int ArmMaxEncoderValue = 565;
	
	final int sampleTime = 100;
	
	/** Proportional gain */
	final double kp = 0.005;	
	/**Integral Gain */
	final double ki = 0;	
	
	/**Derivative Gain*/
	final double kd = 0.0;
	
	double min = -0.33;///ARM_SPEED_REDUCER; //Divide by how much slower you want the max speed
	double max = 0.33;///ARM_SPEED_REDUCER;
	
	final int centerValue = 0; //Place Holding Variable
	public static ArmMotors armMotors = new ArmMotors();	
	public static LeftEncoderPIDSource leftEncoderPIDSource = new LeftEncoderPIDSource();
	public static RightEncoderPIDSource rightEncoderPIDSource = new RightEncoderPIDSource();
	//public static ArmLimitSwitches armSwitch = new ArmLimitSwitches();
	public PIDMain leftArmDynamicPID = new PIDMain(leftEncoderPIDSource, centerValue, sampleTime, kp, ki, kd);
	public PIDMain rightArmDynamicPID = new PIDMain(rightEncoderPIDSource, centerValue, sampleTime, kp, ki, kd);
	
	File f;
	BufferedWriter bw;
	FileWriter fw;
	
    public ArmDynamicSetpointPID() {
    	requires(armMotors);
    	//requires(armSwitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {		
		leftEncoderPIDSource.reset();
		rightEncoderPIDSource.reset();
		
    	leftArmDynamicPID.isEnabled(true);
    	rightArmDynamicPID.isEnabled(true);
    	
    	leftArmDynamicPID.setOutputLimits(min, max);
    	rightArmDynamicPID.setOutputLimits(min, max);
    	
    	//ArmMotors.leftArm.reverseOutput(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Sets the Encoder Targets Properly
    	//if(armSwitch.low_switch.get())	{
    		//ArmMaxEncoderValue = (int) ((leftArmDynamicPID.getInput()+rightArmDynamicPID.getInput())/2);
    	//}
    	//if(armSwitch.high_switch.get())	{
    		//ArmMinEncoderValue = (int) ((leftArmDynamicPID.getInput()+rightArmDynamicPID.getInput())/2);
    	//}
    	//Disables PID and breaks when Joystick is between certain Threshold
    	double x = OI.otherStick.getRawAxis(OI.Axis.LY.getAxisNumber());
    	if(Math.abs(x) <= 0.2)
    	{
    		leftArmDynamicPID.isEnabled(false);
    		rightArmDynamicPID.isEnabled(false);
    		ArmMotors.leftArm.enableBrakeMode(true);
    		ArmMotors.rightArm.enableBrakeMode(true);
    	}	else	{ //Not disabled if Joystick is OK
    		leftArmDynamicPID.isEnabled(true);
    		rightArmDynamicPID.isEnabled(true);
    		ArmMotors.leftArm.enableBrakeMode(false);
    		ArmMotors.rightArm.enableBrakeMode(false);	
    	}
    
    	//Set the Mapped Setpoints
    	leftArmDynamicPID.setSetpoint(PIDMain.map(x, -1, 1, ArmMinEncoderValue, ArmMaxEncoderValue));  //Maps the setpoint to the same range as the input
    	rightArmDynamicPID.setSetpoint(PIDMain.map(x, -1, 1, ArmMinEncoderValue, ArmMaxEncoderValue));  //Maps the setpoint to the same range as the input
    	//Run the motors
    	ArmMotors.leftArm.set(leftArmDynamicPID.getOutput());
    	ArmMotors.rightArm.set(-rightArmDynamicPID.getOutput());   
 
    	//***	***********Debug Info*******************//
    	//SmartDashboard.putNumber("Mapped Setpoint", PIDMain.map(OI.driveStick.getRawAxis(OI.Axis.LY.getAxisNumber()), -1, 1, ArmMinEncoderValue, ArmMaxEncoderValue));
    	SmartDashboard.putNumber("RightInput", rightArmDynamicPID.getInput());
    	//SmartDashboard.putNumber("RightOutput", rightArmDynamicPID.getOutput());
    	//SmartDashboard.putNumber("RightError", rightArmDynamicPID.getError());
    	//SmartDashboard.putNumber("LeftInput", leftArmDynamicPID.getInput());
    	//SmartDashboard.putNumber("LeftOutput", leftArmDynamicPID.getOutput());
    	//SmartDashboard.putNumber("LeftError", leftArmDynamicPID.getError());
    	//SmartDashboard.putNumber("Max", max);
    	//SmartDashboard.putNumber("Min", min);
    	//**************Debug Info******************//
    	/*try	{
    		f = new File("E://")
    	} catch(IOException e)  {
    		
    	}
    	*/
    	
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {

    }
    protected void interrupted() {
    	leftArmDynamicPID.isEnabled(false);
    	rightArmDynamicPID.isEnabled(false);
    	this.end();
    }
}
