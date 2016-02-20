/**
 * @author NeilHazra
 */
package org.usfirst.frc.team2976.robot.subsystems;
import org.usfirst.frc.team2976.robot.commands.RightDriveEncoder;;


public class RightDriveEncoderPIDSource implements PIDSource {
	RightDriveEncoder encoder = new RightDriveEncoder();
	
	public RightDriveEncoderPIDSource() {
		// TODO Auto-generated constructor stub
	}
	public void reset()	{
		encoder.MotorRightEncoder.reset();
	}
	@Override
	public double getInput() {
		// TODO Auto-generated method stub
		return encoder.getRightDrivePosition();
	}
}
