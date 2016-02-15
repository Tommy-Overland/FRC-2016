package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;


/**
 * @author NeilHazra
 */
public class myGyro {
	public Gyro driveGyro = new Gyro(RobotMap.GyroInput);
	public void reset()	{
		driveGyro.reset();
	}
	
	public double getGyro() {
		return driveGyro.getAngle();
	}
}
