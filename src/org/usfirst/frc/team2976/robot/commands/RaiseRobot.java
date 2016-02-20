package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.RaiseRobotMotor;
/**
 *
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
    	if(OI.driveStick.getRawButton(OI.Button.A.getBtnNumber()))	{
        	raiseRobotMotor.liftingMotorA.set(0.3);
        	raiseRobotMotor.liftingMotorB.set(0.3);
    	} else if(OI.driveStick.getRawButton(OI.Button.B.getBtnNumber()))	{
        	raiseRobotMotor.liftingMotorA.set(-0.3);
        	raiseRobotMotor.liftingMotorB.set(-0.3);
    	}	else	{
    		raiseRobotMotor.liftingMotorA.set(0);
        	raiseRobotMotor.liftingMotorB.set(0);
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
