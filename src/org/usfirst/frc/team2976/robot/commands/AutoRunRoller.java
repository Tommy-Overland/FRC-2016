package org.usfirst.frc.team2976.robot.commands;
import org.usfirst.frc.team2976.robot.subsystems.Roller;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRunRoller extends Command {
	Roller roller = new Roller();
	private double time;
	
	public AutoRunRoller(double time) {
		this.time = time;
		requires(roller);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Roller.rollerStop();
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Roller.rollerIn();
		Timer.delay(time);
		Roller.rollerStop();
		this.end();
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