package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2976.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankBot extends Command {
	DriveTrain driveTrain = new DriveTrain();
	private final int fineControlButton=2;//I hope this is "B", most convenient button w/o disturbing most other functions
	public TankBot() {
		requires(driveTrain);
	}
	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//ALRIGHT, WHY DO YOU CREATE driveTrain VARIABLE WHEN YOU ONLY STATICALLY REFERENCE IT
		/*
		DriveTrain.leftBackMotor.set(-OI.driveStick.getRawAxis(OI.Axis.LY.getAxisNumber()));
		DriveTrain.leftFrontMotor.set(-OI.driveStick.getRawAxis(OI.Axis.LY.getAxisNumber()));
		DriveTrain.rightBackMotor.set(OI.driveStick.getRawAxis(OI.Axis.RY.getAxisNumber()));
		DriveTrain.rightFrontMotor.set(OI.driveStick.getRawAxis(OI.Axis.RY.getAxisNumber()));*/
		driveTrain.goodTank(OI.driveStick, driveTrain.fineControlPress(OI.driveStick, fineControlButton));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		// DriveTrain.m_drive.free();
		// Free the PWM ports so we can use them in other projects
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
	}
}
