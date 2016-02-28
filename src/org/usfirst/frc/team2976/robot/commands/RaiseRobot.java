package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.RaiseRobotMotor;
/**
 *@author NeilHazra
 */
public class RaiseRobot extends Command {
	RaiseRobotMotor raiseRobotMotor = new RaiseRobotMotor();
	
    public RaiseRobot() {
    	requires(raiseRobotMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	raiseRobotMotor.liftingMotorA.set(0);
    	raiseRobotMotor.liftingMotorB.set(0);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(OI.otherStick.getRawButton(OI.Button.RBumper.getBtnNumber()))	{
        	raiseRobotMotor.liftingMotorA.set(-1);
        	raiseRobotMotor.liftingMotorB.set(-1);
    	} else if(OI.otherStick.getRawButton(OI.Button.LBumper.getBtnNumber()))	{
        	raiseRobotMotor.liftingMotorA.set(1);
        	raiseRobotMotor.liftingMotorB.set(1);
    	}	else	{
    		raiseRobotMotor.liftingMotorA.set(0);
        	raiseRobotMotor.liftingMotorB.set(0);
        	raiseRobotMotor.liftingMotorA.enableBrakeMode(true);
        	raiseRobotMotor.liftingMotorB.enableBrakeMode(true);
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
