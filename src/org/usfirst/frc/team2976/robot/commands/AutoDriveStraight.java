package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;
import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2976.robot.subsystems.HookMotor;
/**
 *@author JasmineCheng
 */
public class AutoDriveStraight extends Command {
	
	double speed;
	double time;
    public AutoDriveStraight(double mSpeed, double mTime) {
    	requires(Robot.drivetrain);
    	speed= mSpeed;
    	time = mTime;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		DriveTrain.leftBackMotor.set(speed);
    		DriveTrain.leftFrontMotor.set(speed);
    		DriveTrain.rightBackMotor.set(speed);
    		DriveTrain.rightFrontMotor.set(speed);
    		
    		Timer.delay(time);
    
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