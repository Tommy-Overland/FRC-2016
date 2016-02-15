package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {	
	public static CANTalon rightFrontMotor = new CANTalon(RobotMap.RightFrontDriveMotor); //Talon Object
	public static CANTalon leftFrontMotor = new CANTalon(RobotMap.LeftFrontDriveMotor);	 //Talon Object
	public static CANTalon rightBackMotor = new CANTalon(RobotMap.RightBackDriveMotor); //Talon Object
	public static CANTalon leftBackMotor = new CANTalon(RobotMap.LeftBackDriveMotor);	 //Talon Object
	
	private Encoder left_encoder, right_encoder;
	
	public static RobotDrive m_drive = new RobotDrive(leftBackMotor, leftFrontMotor,rightBackMotor, rightBackMotor); //Robot Drive Class
	public void initDefaultCommand() {
		//rightFrontMotor.reverseOutput(true);
		//rightBackMotor.reverseOutput(true);
		//leftFrontMotor.reverseOutput(true);
		//leftBackMotor.reverseOutput(true);
	}
	
	public void drive(double left, double right) {
		m_drive.tankDrive(left, right);
	}

	/**
	 * @param joy The ps3 style joystick to use to drive tank style.
	 */
	public void drive(Joystick joy) {
		drive(joy.getRawAxis(1), joy.getRawAxis(5));
		//drive(0,0);
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		left_encoder.reset();
		right_encoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance() {
		return (left_encoder.getDistance() + right_encoder.getDistance())/2;
	}

}
