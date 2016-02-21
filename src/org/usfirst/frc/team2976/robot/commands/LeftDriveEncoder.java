package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;

/**
 * @author NeilHazra
 */
public class LeftDriveEncoder {
	public Encoder MotorLeftEncoder = new Encoder(RobotMap.LeftDriveEncoderA, RobotMap.LeftDriveEncoderB);
	double motor1position;

	public void reset() {
		MotorLeftEncoder.reset();
	}

	public double getLeftDrivePosition() {
		motor1position = MotorLeftEncoder.get();
		return motor1position;
	}

	

}
