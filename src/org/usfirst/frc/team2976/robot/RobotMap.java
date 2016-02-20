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
	
	public static final int GyroInput = 1;
	
	public static final int RightArmEncoderA = 0;
	public static final int RightArmEncoderB = 1;
	public static final int LeftArmEncoderA = 2;
	public static final int LeftArmEncoderB = 3;
	
	public static final int RaiseHookMotor = 7;
	public static final int RaiseHookSolenoid = 1;
	
	public static final int  PickUpRobotA = 8;
	public static final int  PickUpRobotB = 9;
	
	public static final int RightDriveEncoderA = 0;
	public static final int RightDriveEncoderB = 0;
	public static final int LeftDriveEncoderA = 0;
	public static final int LeftDriveEncoderB = 0;
}
