package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.Roller;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRunRoller extends Command {
	Roller roller = new Roller();

	public AutoRunRoller() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(roller);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		roller.roller.set(0);
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (OI.driveStick.getRawButton(5)) {
			roller.roller.set(1);
		} else if (OI.driveStick.getRawButton(6)) {
			roller.roller.set(-1);
		} else {
	    	roller.roller.set(0);
		}
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
		end();
	}
}
