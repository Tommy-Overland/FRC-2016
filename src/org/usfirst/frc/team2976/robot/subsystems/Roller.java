package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Roller extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static Talon roller = new Talon(RobotMap.rollerMotorID);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void set(double value){
    	roller.set(value);
    }
    public static void rollerIn(){
    	roller.set(1);
    }
    
    public static void rollerOut(){
    	roller.set(-1);
    }
    
    public static void rollerStop(){
    	roller.set(0);
    }
}

