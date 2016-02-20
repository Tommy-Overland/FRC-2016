package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;
import org.usfirst.frc.team2976.robot.subsystems.Roller;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunRoller extends Command {
	Joystick m_joy;

	public RunRoller(Joystick joy) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		m_joy=joy;
		requires(Robot.roller);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
    	if (m_joy.getRawButton(5)){
    		Robot.roller.in();
    	} else if (m_joy.getRawButton(6)){
    		Robot.roller.out();
    	} else {
    		Robot.roller.stop();
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
