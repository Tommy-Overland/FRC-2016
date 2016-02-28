package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import org.usfirst.frc.team2976.robot.override.TankDrivePlus;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author NeilHazra
 */
public class DriveTrain extends Subsystem {	
	public static CANTalon rightFrontMotor = new CANTalon(RobotMap.RightFrontDriveMotor); //Talon Object
	public static CANTalon leftFrontMotor = new CANTalon(RobotMap.LeftFrontDriveMotor);	 //Talon Object
	public static CANTalon rightBackMotor = new CANTalon(RobotMap.RightBackDriveMotor); //Talon Object
	public static CANTalon leftBackMotor = new CANTalon(RobotMap.LeftBackDriveMotor);	 //Talon Object
	
	public static TankDrivePlus m_drive = new TankDrivePlus(leftBackMotor, leftFrontMotor,rightBackMotor, rightBackMotor); //Robot Drive Class
	
	public void initDefaultCommand() {
	}	
	
	public static void setZero(){
		rightFrontMotor.set(0);
		leftFrontMotor.set(0);
		rightBackMotor.set(0);
		leftBackMotor.set(0);
	}
	public static void Break()	{
		DriveTrain.leftBackMotor.enableBrakeMode(true);
		DriveTrain.leftFrontMotor.enableBrakeMode(true);
		DriveTrain.rightBackMotor.enableBrakeMode(true);
		DriveTrain.rightFrontMotor.enableBrakeMode(true);
	}
	public static void releaseBreak()	{
		DriveTrain.leftBackMotor.enableBrakeMode(false);
		DriveTrain.leftFrontMotor.enableBrakeMode(false);
		DriveTrain.rightBackMotor.enableBrakeMode(false);
		DriveTrain.rightFrontMotor.enableBrakeMode(false);
	}

}
