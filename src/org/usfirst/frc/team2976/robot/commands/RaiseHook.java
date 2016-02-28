package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.HookMotor;
/**
 *@author NeilHazra
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
    	if(OI.otherStick.getRawButton(OI.Button.A.getBtnNumber()))	{
    		hookMotor.raiseArm.set(1);
    	} else if(OI.otherStick.getRawButton(OI.Button.B.getBtnNumber()))	{
    		hookMotor.raiseArm.set(-1);
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
