package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoChivralDeFrise extends Command {

    public AutoChivralDeFrise() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//set position of arm at top
    	ArmDynamicSetpointPID arm = new ArmDynamicSetpointPID();
    	arm.start();
    	//wait till arm is finished
    	arm.end();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//move foward a few inches
    	//TODO set value
    	AutoDriveStraight drive = new AutoDriveStraight(0,0);
    	//lower arm to lower chivral de frise
    	//TODO set arm value
    	ArmDynamicSetpointPID arm = new ArmDynamicSetpointPID();
    	arm.start();
    	//wait till arm is finished
    	arm.end();
    	//Move Forward to cross chivral de fise 
    	//TODO set distance 
    	drive = new AutoDriveStraight(0,0);
    	drive.start();
    	arm=new ArmDynamicSetpointPID();
    	arm.start();
    	arm.end();
    	//drive forward
    	//raise arm
    	
    	
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
