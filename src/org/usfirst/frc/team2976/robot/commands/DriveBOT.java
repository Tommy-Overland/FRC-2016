
package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.command.Command;

//import org.usfirst.frc.team2976.robot.Robot;

/**
 *
 */
public class DriveBOT extends Command {
	public static DriveTrain drivetrain = new DriveTrain();
    
	public DriveBOT() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//drivetrain.m_drive.arcadeDrive(OI.LeftJoyStick);
    	DriveTrain.m_drive.arcadeDrive(OI.driveStick.getLY(), OI.driveStick.getRX(),true);
    	//Reverse to compensate for mixed axis
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
    }
}
