package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author NeilHazra
 */
public class LeftArmEncoder extends Subsystem {
	public Encoder MotorLeftEncoder = new Encoder(RobotMap.LeftArmEncoderA, RobotMap.LeftArmEncoderB);
	double motor1position;

	public void reset() {
		MotorLeftEncoder.reset();
	}

	public double getLeftArmPosition() {
		motor1position = MotorLeftEncoder.get();
		return motor1position;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
