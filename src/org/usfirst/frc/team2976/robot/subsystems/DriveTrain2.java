
package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;
import org.usfirst.frc.team2976.robot.override.TankDrivePlus;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class DriveTrain2 extends Subsystem {
    
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public TankDrivePlus Mdrive = new TankDrivePlus (RobotMap.LeftFrontDriveMotor, RobotMap.LeftBackDriveMotor, RobotMap.RightFrontDriveMotor, RobotMap.RightBackDriveMotor);
	
    
	// public static Talon leftMotor = new Talon(RobotMap.leftMotor);
	 // public static Talon rightMotor = new Talon(RobotMap.rightMotor);
	  
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

