package org.usfirst.frc.team2976.robot.commands;
import org.usfirst.frc.team2976.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
/**
 *@author NeilHazra 
 */
public class RightArmEncoder {
    public Encoder MotorRightEncoder = new Encoder(RobotMap.RightArmEncoderA, RobotMap.RightArmEncoderB);	
    double motor1position;
    
	public void reset()	{
		MotorRightEncoder.reset();
	}
    public double getRightArmPosition()	{    	
    	motor1position = MotorRightEncoder.get();
    	return motor1position;	
    }
}

