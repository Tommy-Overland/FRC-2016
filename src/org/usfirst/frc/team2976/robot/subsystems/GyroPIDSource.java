/**
 * @author NeilHazra
 */
package org.usfirst.frc.team2976.robot.subsystems;
import org.usfirst.frc.team2976.robot.commands.myGyro;


public class GyroPIDSource implements PIDSource {
	myGyro m_gyro = new myGyro();
	
	public GyroPIDSource() {
		// TODO Auto-generated constructor stub
	}
	public void reset()	{
		m_gyro.reset();
	}
	@Override
	public double getInput() {
		// TODO Auto-generated method stub
		return m_gyro.getGyro();
	}
}
