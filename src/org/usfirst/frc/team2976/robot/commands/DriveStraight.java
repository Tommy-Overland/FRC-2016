package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;
import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2976.robot.subsystems.GyroPIDSource;
import org.usfirst.frc.team2976.robot.subsystems.PIDMain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author NeilHazra
 */
public class DriveStraight extends Command {
	DriveTrain driveTrain = new DriveTrain();
	Command ForcedInterrupted;
	public GyroPIDSource gyropidsource = new GyroPIDSource(); // Implements
																// PIDSource
	/** Proportional gain */
	double kp = 0.05;
	/** Integral Gain */
	double ki = 0.001;
	/** Derivative Gain */
	double kd = 0.004;

	int robot_angle_setpoint = 0;

	final int sampleTime = 100;

	public PIDMain RobotAnglePID = new PIDMain(gyropidsource, robot_angle_setpoint, sampleTime, kp, ki, kd);
	// PID controller for Motor 1

	public DriveStraight() {
		requires(driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.ArcadeBOT.isRunning()) {
			Robot.ArcadeBOT.cancel(); // Interrupt the regular DriveFuntion
			ForcedInterrupted = Robot.ArcadeBOT;
		}
		if (Robot.TankBOT.isRunning()) {
			Robot.TankBOT.cancel(); // Interrupt the regular DriveFuntion
			ForcedInterrupted = Robot.TankBOT;
		}
		if (Robot.DriveBot.isRunning()) {
			Robot.DriveBot.cancel(); // Interrupt the regular DriveFuntion
			ForcedInterrupted = Robot.DriveBot;
		}
		RobotAnglePID.isEnabled(true); // Start the PID
		gyropidsource.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {		
		
		//DriveTrain.leftFrontMotor.set(-OI.driveStick.getY() - RobotAnglePID.getOutput()); //Correct the rightMotor
		//DriveTrain.rightFrontMotor.set(OI.driveStick.getY()); //+ RobotAnglePID.getOutput()); //Correct the leftMotor	
		//DriveTrain.leftBackMotor.set(-OI.driveStick.getY() - RobotAnglePID.getOutput()); //Correct the rightMotor
		//DriveTrain.rightBackMotor.set(OI.driveStick.getY() /*+ RobotAnglePID.getOutput()*/); //Correct the leftMotor
		
		
		//Test 
			if(RobotAnglePID.getOutput()<0)	{
			DriveTrain.leftFrontMotor.set(OI.driveStick.getY() + Math.abs(RobotAnglePID.getOutput())); //Correct the rightMotor
			DriveTrain.rightFrontMotor.set(-OI.driveStick.getY());
			DriveTrain.leftBackMotor.set(OI.driveStick.getY() + Math.abs(RobotAnglePID.getOutput())); //Correct the rightMotor
			DriveTrain.rightBackMotor.set(-OI.driveStick.getY());
			}	else if(RobotAnglePID.getOutput()>0)	{
			DriveTrain.leftFrontMotor.set(OI.driveStick.getY()); 
			DriveTrain.rightFrontMotor.set(-OI.driveStick.getY() + -Math.abs(RobotAnglePID.getOutput())); //Correct the leftMotor	
			DriveTrain.leftBackMotor.set(OI.driveStick.getY()); 
			DriveTrain.rightBackMotor.set(-OI.driveStick.getY() - Math.abs(RobotAnglePID.getOutput())); //Correct the leftMotor
			}	else {	
			DriveTrain.leftFrontMotor.set(OI.driveStick.getY()); 
			DriveTrain.rightFrontMotor.set(-OI.driveStick.getY()); //Correct the leftMotor	
			DriveTrain.leftBackMotor.set(OI.driveStick.getY()); 
			DriveTrain.rightBackMotor.set(-OI.driveStick.getY()); //Correct the leftMotor	
			}
		
		//Test End
		
		//Debug Info*******************************************Debug Info
		SmartDashboard.putNumber("DriveStraight: LeftMotorFinal", OI.driveStick.getY() + RobotAnglePID.getOutput());
		SmartDashboard.putNumber("DriveStraight: RightMotorFinal", OI.driveStick.getY());
		
		SmartDashboard.putNumber("DriveStraight: PidOutput",RobotAnglePID.getOutput());
		SmartDashboard.putNumber("DriveStraight: PidError",RobotAnglePID.getError());
		//Debug Info********************************************Debug Info
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		RobotAnglePID.isEnabled(false);// Terminate the PID loop
		ForcedInterrupted.start(); // restart the regular drive function
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end(); // Called when button is released
	}
}
