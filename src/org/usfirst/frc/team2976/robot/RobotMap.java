package org.usfirst.frc.team2976.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int RightFrontDriveMotor = 3;
	public static final int LeftFrontDriveMotor = 2;
	public static final int RightBackDriveMotor = 4;
	public static final int LeftBackDriveMotor = 1;
	
	public static final int RightArmMotor = 6;
	public static final int LeftArmMotor = 5;
	
		
	public static final int rollerMotorID = 10;
	public static final int GyroInput = 0;
	
	public static final int RightArmEncoderA = 0;
	public static final int RightArmEncoderB = 1;
	public static final int LeftArmEncoderA = 2;
	public static final int LeftArmEncoderB = 3;
	
	//motors for the backarm:
	public static final int BackarmLiftMotor = 7;
	public static final int BackarmPullFrontMotor = 8;
	public static final int BackarmPullBackMotor = 9;
	public static final int BackarmSolenoid = 9;//ask lucas for port
}
