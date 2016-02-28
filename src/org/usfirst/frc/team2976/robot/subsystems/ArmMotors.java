package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author NeilHazra
 */
public class ArmMotors extends Subsystem {
	public static CANTalon rightArm = new CANTalon(RobotMap.RightArmMotor); //Talon Object
	public static CANTalon leftArm = new CANTalon(RobotMap.LeftArmMotor);	 //Talon Object
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

