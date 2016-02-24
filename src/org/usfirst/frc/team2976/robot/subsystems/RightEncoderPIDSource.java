/**
 * @author NeilHazra
 */
package org.usfirst.frc.team2976.robot.subsystems;
import org.usfirst.frc.team2976.robot.commands.RightArmEncoder;;


public class RightEncoderPIDSource implements PIDSource {
	RightArmEncoder encoder = new RightArmEncoder();
	
	public RightEncoderPIDSource() {
		// TODO Auto-generated constructor stub
	}
	public void reset()	{
		encoder.MotorRightEncoder.reset();
	}
	@Override
	public double getInput() {
		// TODO Auto-generated method stub
		return encoder.getRightArmPosition();
	}
}
