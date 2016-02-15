package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.subsystems.myCompressor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class startCompressor extends Command {
	myCompressor compressor = new myCompressor();
    
	public startCompressor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//compressor.c_compress.clearAllPCMStickyFaults();
    	compressor.c_compress.setClosedLoopControl(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//compressor.c_compress.setClosedLoopControl(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	compressor.c_compress.setClosedLoopControl(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
