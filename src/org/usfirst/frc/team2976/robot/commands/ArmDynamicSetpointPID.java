package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.ArmMotors;
import org.usfirst.frc.team2976.robot.subsystems.LeftEncoderPIDSource;
import org.usfirst.frc.team2976.robot.subsystems.PIDMain;
import org.usfirst.frc.team2976.robot.subsystems.RightEncoderPIDSource;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmDynamicSetpointPID extends Command {
	final int ARM_SPEED_REDUCER = 4;
	final int ArmMinEncoderValue = 0;
	final int ArmMaxEncoderValue = 100;
	final int sampleTime = 100;
	
	/** Proportional gain */
	final double kp = 0.01;	
	/**Integral Gain */
	final double ki = 0;	
	/**Derivative Gain*/
	final double kd = 0;
	
	final int centerValue = 0; //Place Holding Variable
	public static ArmMotors armMotors = new ArmMotors();	
	public static LeftEncoderPIDSource leftEncoderPIDSource = new LeftEncoderPIDSource();
	public static RightEncoderPIDSource rightEncoderPIDSource = new RightEncoderPIDSource();
	
	public PIDMain leftArmDynamicPID = new PIDMain(leftEncoderPIDSource, centerValue, sampleTime, kp, ki, kd);
	public PIDMain rightArmDynamicPID = new PIDMain(rightEncoderPIDSource, centerValue, sampleTime, kp, ki, kd);
	
    public ArmDynamicSetpointPID() {
    	requires(armMotors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double min = -1/ARM_SPEED_REDUCER; //Divide by how much slower you want the max speed
		double max = 1/ARM_SPEED_REDUCER;
		
		leftEncoderPIDSource.reset();
		rightEncoderPIDSource.reset();
		
    	leftArmDynamicPID.isEnabled(true);
    	rightArmDynamicPID.isEnabled(true);
    	leftArmDynamicPID.setOutputLimits(min, max);
    	rightArmDynamicPID.setOutputLimits(min, max);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftArmDynamicPID.setSetpoint(PIDMain.map(OI.driveStick.getRawAxis(OI.Axis.LY.getAxisNumber()), -1, 1, ArmMinEncoderValue, ArmMaxEncoderValue));  //Maps the setpoint to the same range as the input
    	rightArmDynamicPID.setSetpoint(PIDMain.map(OI.driveStick.getRawAxis(OI.Axis.LY.getAxisNumber()), -1, 1, ArmMinEncoderValue, ArmMaxEncoderValue));  //Maps the setpoint to the same range as the input
   	
    	//ArmMotors.leftArm.set(leftArmDynamicPID.getOutput());
    	//ArmMotors.rightArm.set(rightArmDynamicPID.getOutput());   
  
    	//**************Debug Info*******************//
    	SmartDashboard.putNumber("Mapped Setpoint", PIDMain.map(OI.driveStick.getRawAxis(OI.Axis.LY.getAxisNumber()), -1, 1, ArmMinEncoderValue, ArmMaxEncoderValue));
    	SmartDashboard.putNumber("RightInput", rightArmDynamicPID.getInput());
    	SmartDashboard.putNumber("RightOutput", rightArmDynamicPID.getOutput());
    	SmartDashboard.putNumber("LeftInput", leftArmDynamicPID.getInput());
    	SmartDashboard.putNumber("LeftOutput", leftArmDynamicPID.getOutput());
    	SmartDashboard.putNumber("LeftError", leftArmDynamicPID.getError());
    	
    	
    	//**************Debug Info******************//
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
