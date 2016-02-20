package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.HookMotor;
/**
 *
 */
public class RaiseHook extends Command {
	HookMotor hookMotor = new HookMotor();
	
    public RaiseHook() {
    	requires(hookMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	hookMotor.raiseArm.set(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(OI.driveStick.getRawButton(OI.Button.X.getBtnNumber()))	{
    		hookMotor.raiseArm.set(0.3);
    	} else if(OI.driveStick.getRawButton(OI.Button.Y.getBtnNumber()))	{
    		hookMotor.raiseArm.set(-0.3);
    	}	else	{
    		hookMotor.raiseArm.set(0);
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
    }
}
