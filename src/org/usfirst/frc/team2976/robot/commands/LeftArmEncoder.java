package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;

/**
 * @author NeilHazra
 */
public class LeftArmEncoder {
	public Encoder MotorLeftEncoder = new Encoder(RobotMap.LeftArmEncoderA, RobotMap.LeftArmEncoderB);
	double motor1position;

	public void reset() {
		MotorLeftEncoder.reset();
	}

	public double getLeftArmPosition() {
		motor1position = MotorLeftEncoder.get();
		return motor1position;
	}
}
