/**
 * @author NeilHazra
 */
package org.usfirst.frc.team2976.robot.subsystems;
import org.usfirst.frc.team2976.robot.commands.LeftArmEncoder;;


public class LeftEncoderPIDSource implements PIDSource {
	LeftArmEncoder encoder = new LeftArmEncoder();
	
	public LeftEncoderPIDSource() {
		// TODO Auto-generated constructor stub
	}
	public void reset()	{
		encoder.MotorLeftEncoder.reset();
	}
	@Override
	public double getInput() {
		// TODO Auto-generated method stub
		return encoder.getLeftArmPosition();
	}
}
