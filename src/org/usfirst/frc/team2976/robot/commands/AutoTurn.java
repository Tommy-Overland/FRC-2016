package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;
import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2976.robot.subsystems.HookMotor;
/**
 *
 */
public class AutoTurn extends Command {
	
	double TurnValue;
	double time;
	int degrees;
    public AutoTurn(int turnDegrees, double rTurnValue) {
    	requires(Robot.drivetrain);
    	degrees= turnDegrees;
    	TurnValue = rTurnValue;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(Robot.mygyro.getGyro()<degrees){
    		DriveTrain.leftBackMotor.set(TurnValue);
    		DriveTrain.leftFrontMotor.set(TurnValue);
    		DriveTrain.rightBackMotor.set(-TurnValue);
    		DriveTrain.rightFrontMotor.set(-TurnValue);
    	}
    	DriveTrain.leftBackMotor.set(0);
    	DriveTrain.leftFrontMotor.set(0);
    	DriveTrain.rightBackMotor.set(0);
    	DriveTrain.rightFrontMotor.set(0);
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
