package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Roller extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon roller = new CANTalon(RobotMap.rollerMotorID);

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void set(double value){
    	roller.set(value);
    }
    public void rollerIn(){
    	roller.set(1);
    }
    
    public void rollerOut(){
    	roller.set(-1);
    }
    
    public void rollerStop(){
    	roller.set(0);
    }
}

