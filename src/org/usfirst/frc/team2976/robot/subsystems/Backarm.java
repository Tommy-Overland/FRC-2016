package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Backarm extends Subsystem {
	public static CANTalon BackarmLift = new CANTalon(RobotMap.BackarmLiftMotor); //Talon Object
	
	public static CANTalon BackarmFrontPull = new CANTalon(RobotMap.BackarmPullFrontMotor);	 //Talon Object
	public static CANTalon BackarmBackPull = new CANTalon(RobotMap.BackarmPullBackMotor);
	
	public static Solenoid BackarmSolenoid = new Solenoid(RobotMap.BackarmSolenoid);
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pneumaticSetTrue(){
    	BackarmSolenoid.set(true);
    }
    
    public void pneumaticSetFalse(){
    	BackarmSolenoid.set(false);
    }
    
    public void moveLiftMotor(double sec){
    	BackarmLift.set(0.5);
    }
}

