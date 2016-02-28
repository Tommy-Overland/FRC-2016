package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.Timer;
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
	
	DriveTrain driveTrain = new DriveTrain();
	
    public AutoTurn(double TurnValue, double time) {
    	requires(driveTrain);
    	
    	this.TurnValue = TurnValue;
    	this.time = time; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriveTrain.setZero();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		DriveTrain.leftBackMotor.set(TurnValue);
    		DriveTrain.leftFrontMotor.set(TurnValue);
    		DriveTrain.rightBackMotor.set(-TurnValue);
    		DriveTrain.rightFrontMotor.set(-TurnValue);
    		
    		Timer.delay(time);
    
    		DriveTrain.Break(); 
    		Timer.delay(0.2);
    		DriveTrain.releaseBreak();
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
    }
}