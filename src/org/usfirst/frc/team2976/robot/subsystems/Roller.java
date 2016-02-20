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
    
    public void in() {
        roller.set(-1);
    }

    public void out() {
        roller.set(1);
    }
    
    /**
     * Stops the claw motor from moving.
     */
    public void stop() {
        roller.set(0);
    }
    
    
}

