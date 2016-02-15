package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.Robot;
import org.usfirst.frc.team2976.robot.subsystems.ArmMotors;
import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRaisePortcullis extends Command {
	private final int DEGREES_PER_COUNT = 0;
	private final int ARM_LENGTH = 0;
	public double degrees = 0;
	public double radians = 0;
	public int forwardMovement = 0;

	public Object[] Tasks_to_restart = new Object[3];

	DriveTrain driveTrain = new DriveTrain();

	public AutoRaisePortcullis() {
		if (Robot.TankBOT.isRunning()) {
			Robot.TankBOT.cancel();
			Tasks_to_restart[0] = Robot.TankBOT;
		}
		if (Robot.ArcadeBOT.isRunning()) {
			Robot.ArcadeBOT.cancel();
			Tasks_to_restart[1] = Robot.ArcadeBOT;
		}
		if (Robot.armPID.isRunning()) {
			Robot.armPID.cancel();
			Tasks_to_restart[2] = Robot.armPID;
		}
		requires(driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		radians = degrees * 180 / Math.PI;
		forwardMovement = (int) (ARM_LENGTH - Math.sin(radians) * ARM_LENGTH);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		if (Tasks_to_restart[0] != null) {
			((Command) Tasks_to_restart[0]).start();
		}
		if (Tasks_to_restart[1] != null) {
			((Command) Tasks_to_restart[1]).start();
		}
		if (Tasks_to_restart[2] != null) {
			((Command) Tasks_to_restart[2]).start();
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
