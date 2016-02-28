package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.Robot;
import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2976.robot.subsystems.LeftDriveEncoderPIDSource;
import org.usfirst.frc.team2976.robot.subsystems.PIDMain;
import org.usfirst.frc.team2976.robot.subsystems.RightDriveEncoderPIDSource;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *@author NeilHazra
 */
public class AutoRaisePortcullis extends Command {
	public final int TICKS_PER_ROTATION = 00; 
	public final int INCHES_PER_ROTATION = 00;
	final double kp = 0.0;	
	final double ki = 0.0;	
	final double kd = 0.0;
	final int sampleTime = 100; 
	
	
	final int centerValue = 0; //dummyVariable
	
	public LeftDriveEncoderPIDSource leftDriveEncoderPIDSource = new LeftDriveEncoderPIDSource();
	public RightDriveEncoderPIDSource rightDriveEncoderPIDSource = new RightDriveEncoderPIDSource();
	public PIDMain leftDriveSyncPID = new PIDMain(leftDriveEncoderPIDSource, centerValue, sampleTime, kp, ki, kd);
	public PIDMain rightDriveSyncPID = new PIDMain(rightDriveEncoderPIDSource, centerValue, sampleTime, kp, ki, kd);
	public int armLength = 0;
	
	private double angleADeg = 0;
	private double angleARad = 0;
	private double angleBDeg = 0;
	private double angleBRad = 0;
	
	private int forwardDistance = 0;
	
	Command ForcedStarted;
	Command ForcedInterrupted;
	DriveTrain driveTrain = new DriveTrain();
	
	public AutoRaisePortcullis() {
		if (Robot.DriveBot.isRunning()) {
			Robot.DriveBot.cancel(); // Interrupt the regular DriveFuntion
			ForcedInterrupted = Robot.DriveBot;
		}
		if(!Robot.armPID.isRunning())	{
			Robot.armPID.start();
			ForcedStarted = Robot.armPID;
		}
		
		requires(driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	 	double min = -1/1.5; //Divide by how much slower you want the max speed
		double max = 1/1.5;
		
		leftDriveEncoderPIDSource.reset();
		rightDriveEncoderPIDSource.reset();
		
		leftDriveSyncPID.isEnabled(true);
    	rightDriveSyncPID.isEnabled(true);
    	
    	leftDriveSyncPID.setOutputLimits(min, max);
    	rightDriveSyncPID.setOutputLimits(min, max);
    	Timer.delay(.1);
    	angleADeg = Robot.armPID.leftArmDynamicPID.getInput()/TICKS_PER_ROTATION;
		angleARad = angleADeg*Math.PI/360;
		
	}
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		angleBDeg = Robot.armPID.leftArmDynamicPID.getInput() / TICKS_PER_ROTATION;

		angleBRad = angleBDeg * Math.PI / 360;

		forwardDistance = (int) (armLength * (Math.cos(angleBRad) - Math.cos(angleARad)));

		leftDriveSyncPID.setSetpoint((forwardDistance / INCHES_PER_ROTATION) * TICKS_PER_ROTATION);
		rightDriveSyncPID.setSetpoint((forwardDistance / INCHES_PER_ROTATION) * TICKS_PER_ROTATION);

		DriveTrain.leftBackMotor.set(leftDriveSyncPID.getOutput());
		DriveTrain.leftFrontMotor.set(leftDriveSyncPID.getOutput());
		DriveTrain.rightBackMotor.set(rightDriveSyncPID.getOutput());
		DriveTrain.rightFrontMotor.set(rightDriveSyncPID.getOutput());
	}
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
	// Called once after isFinished returns true
	protected void end() {
		if(ForcedStarted != null){
		 ForcedStarted.cancel();
		}
		if(ForcedInterrupted != null)	{
			ForcedInterrupted.start();
		}
	}
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		leftDriveSyncPID.isEnabled(false);
		rightDriveSyncPID.isEnabled(false);
	}
}
