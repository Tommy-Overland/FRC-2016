/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.PIDSourceType;
import org.usfirst.frc.team2976.robot.Robot;

/**
 * Drive the given distance straight (negative values go backwards).
 * Uses a local PID controller to run a simple PID loop that is only
 * enabled while this command is running. The input is the averaged
 * values of the left and right encoders.
 */
public class AutoDriveStraight extends Command {
    private PIDController pid;
    /*
     * REQUEST: Add a boolean to the drivestraight part for turning or not turning.
     * This codes is what the below comment says so if isn't what the code does then oh well.
     */
    /*
     * I HAVE A QUESTION
     * WHO WROTE THIS CODE?
     * THIS IS THE LITERAL ESSENCE OF CANCER
     * Brackets EVERYWHERE... ALL OVER THE PLACE
     * This code barely makes sense
     * Please fix this
     */
    public AutoDriveStraight(double distance) {
        requires(Robot.drivetrain);
        pid = new PIDController(4, 0, 0,
                new PIDSource() {
                    PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

                    public double pidGet() {
                    	//returns average of left and right encoder position
                        return (Robot.leftdriveencoder.getLeftDrivePosition()+Robot.rightdriveencoder.getRightDrivePosition())/2;
                    }

                    @Override
                    public void setPIDSourceType(PIDSourceType pidSource) {
                      m_sourceType = pidSource;
                    }

                    @Override
                    public PIDSourceType getPIDSourceType() {
                        return m_sourceType;
                    }
                },
                new PIDOutput() { public void pidWrite(double d) {
                    Robot.drivetrain.drive(d, d);
                }});
        pid.setAbsoluteTolerance(0.01);
        pid.setSetpoint(distance);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Get everything in a safe starting state.
        //Robot.drivetrain.reset();
    	pid.reset();
        pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stop PID and the wheels
    	pid.disable();
        Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
