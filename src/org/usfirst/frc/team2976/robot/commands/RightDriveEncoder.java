package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;

/**
 * @author NeilHazra
 */
public class RightDriveEncoder {
	public Encoder MotorRightEncoder = new Encoder(RobotMap.RightDriveEncoderA, RobotMap.RightDriveEncoderB);
	double motor1position;

	public void reset() {
		MotorRightEncoder.reset();
	}

	public double getRightDrivePosition() {
		motor1position = MotorRightEncoder.get();
		return motor1position;
	}
}
