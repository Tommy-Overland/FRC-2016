package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RaiseRobotMotor extends Subsystem {
    
	public CANTalon liftingMotorA = new CANTalon(RobotMap.PickUpRobotA);
	public CANTalon liftingMotorB = new CANTalon(RobotMap.PickUpRobotB);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

