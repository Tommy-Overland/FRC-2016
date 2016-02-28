package org.usfirst.frc.team2976.robot.subsystems;
import org.usfirst.frc.team2976.robot.commands.LeftDriveEncoder;
/**
 * 
 * @author NeilHazra
 *
 */
public class LeftDriveEncoderPIDSource implements PIDSource {
	LeftDriveEncoder encoder = new LeftDriveEncoder();
	
	public LeftDriveEncoderPIDSource() {
		// TODO Auto-generated constructor stub
	}
	public void reset()	{
		encoder.MotorLeftEncoder.reset();
	}
	@Override
	public double getInput() {
		// TODO Auto-generated method stub
		return encoder.getLeftDrivePosition();
	}
}
