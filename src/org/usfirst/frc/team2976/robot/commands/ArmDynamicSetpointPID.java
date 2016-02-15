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
	final int sampleTime = 50; /**delay before successive PID calculations  */
	final int centerValue = 250; //Potentiometer value when wheels are centered
	/** Proportional gain */
	double kp = -0.01;	
	/**Integral Gain */
	double ki = -0.00;	
	/**Derivative Gain*/
	double kd = -0.005;
	
		int ArmMinEncoderValue = 0;
		int ArmMaxEncoderValue = 100;
	
	public static ArmMotors armMotors = new ArmMotors();	
	public static LeftEncoderPIDSource leftEncoderPIDSource = new LeftEncoderPIDSource();
	public static RightEncoderPIDSource rightEncoderPIDSource = new RightEncoderPIDSource();
	
	public PIDMain leftArmDynamicPID = new PIDMain(leftEncoderPIDSource, centerValue, sampleTime, kp, ki, kd);
	public PIDMain rightArmDynamicPID = new PIDMain(rightEncoderPIDSource, centerValue, sampleTime, -kp, ki, kd);
	
    public ArmDynamicSetpointPID() {
    	requires(armMotors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double min = -1/1.5; //Divide by how much slower you want the max speed
		double max = 1/1.5;
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
     	
    	SmartDashboard.putNumber("Mapped Setpoint", PIDMain.map(OI.driveStick.getRawAxis(OI.Axis.LY.getAxisNumber()), -1, 1, ArmMinEncoderValue, ArmMaxEncoderValue));
    	SmartDashboard.putNumber("RightInput", rightArmDynamicPID.getInput());
    	SmartDashboard.putNumber("RightOutput", rightArmDynamicPID.getOutput());
    	
    	SmartDashboard.putNumber("LeftInput", leftArmDynamicPID.getInput());
    	SmartDashboard.putNumber("LeftOutput", leftArmDynamicPID.getOutput());
    	SmartDashboard.putNumber("LeftError", leftArmDynamicPID.getError());
    	
    	//leftArmDynamicPID.setSetpoint(rightArmDynamicPID.getInput());
    	
    	ArmMotors.leftArm.set(leftArmDynamicPID.getOutput());
    	ArmMotors.rightArm.set(rightArmDynamicPID.getOutput());
    	//SmartDashboard.put
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
 
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	leftArmDynamicPID.isEnabled(false);
    	rightArmDynamicPID.isEnabled(false);
    }
}
