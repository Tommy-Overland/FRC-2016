package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {	
	public static CANTalon rightFrontMotor = new CANTalon(RobotMap.RightFrontDriveMotor); //Talon Object
	public static CANTalon leftFrontMotor = new CANTalon(RobotMap.LeftFrontDriveMotor);	 //Talon Object
	public static CANTalon rightBackMotor = new CANTalon(RobotMap.RightBackDriveMotor); //Talon Object
	public static CANTalon leftBackMotor = new CANTalon(RobotMap.LeftBackDriveMotor);	 //Talon Object
	
	private Encoder left_encoder, right_encoder;
	/*
	 * WTF, GUYS GUYS GUYS LOOK HERE LOOK HERE LOOK HERE	
	 * GUYS GUYS GUYS LOOK HERE LOOK HERE LOOK HERE			
	 * GUYS GUYS GUYS LOOK HERE LOOK HERE LOOK HERE			
	 * 
	 * Where do you relate the encoders the motors? 	<---------------ACTUAL COMMENT
	 * 
oooo                      oooo             oooo                                          
`888                      `888             `888                                          
 888   .ooooo.   .ooooo.   888  oooo        888 .oo.    .ooooo.  oooo d8b  .ooooo.       
 888  d88' `88b d88' `88b  888 .8P'         888P"Y88b  d88' `88b `888""8P d88' `88b      
 888  888   888 888   888  888888.          888   888  888ooo888  888     888ooo888      
 888  888   888 888   888  888 `88b.        888   888  888    .o  888     888    .o      
o888o `Y8bod8P' `Y8bod8P' o888o o888o      o888o o888o `Y8bod8P' d888b    `Y8bod8P'  
	 */
	private final double moveThreshold=0.2;		//This one is for if we should move at all
	private final double sideThreshold=0.2;		//This one decides forwards or backwards
	private final double speedMultiplier=0.5;	//Multiplied before setting speed, used for testing
	//Prefix f means fine control, values used for motor movement during fine control
	private final double fmoveThreshold=0.08;	//See above comments for value usage
	private final double fsideThreshold=0.08;
	private final double fspeedMultiplier=0.25;
	
	//Names abbreviated for simplicity. l=left r=right f=front b=back q=queue
	//Used to store values motor should be set to
	private double lfq=0;
	private double rfq=0;
	private double lbq=0;
	private double rbq=0;
	//Previous state of button, used for fineControl
	private boolean previousFine=false;
	
	public static RobotDrive m_drive = new RobotDrive(leftBackMotor, leftFrontMotor,rightBackMotor, rightBackMotor); //Robot Drive Class
	public void initDefaultCommand() {
		//rightFrontMotor.reverseOutput(true);
		//rightBackMotor.reverseOutput(true);
		//leftFrontMotor.reverseOutput(true);
		//leftBackMotor.reverseOutput(true);
	}
	public void goodTank(Joystick joystick)
	{
		goodTank(joystick, false);
	}
	public void goodTank(Joystick joystick, boolean fineControl)
	{
		double l;
		double r;
		l=joystick.getRawAxis(OI.Axis.LY.getAxisNumber());
		r=joystick.getRawAxis(OI.Axis.RY.getAxisNumber());
		if(!fineControl)
		{
			if(l>=moveThreshold)
			{
				leftMotor(l, fineControl);
			}
			else
			{
				leftMotor(0.0, fineControl);
			}
			if(r>=moveThreshold)
			{
				rightMotor(r, fineControl);
			}
			else
			{
				rightMotor(0.0, fineControl);
			}
		}
		else
		{
			if(l>=fmoveThreshold)
			{
				leftMotor(l, fineControl);
			}
			else
			{
				leftMotor(0.0, fineControl);
			}
			if(r>=fmoveThreshold)
			{
				rightMotor(r, fineControl);
			}
			else
			{
				rightMotor(0.0, fineControl);
			}
		}
		moveMotor();
	}
	public boolean fineControlToggle(Joystick joystick, int buttonNumber)
	{
		//Returns true if you should toggle, your code to use should be...
		/*
		 * if(fineControlToggle(joystick, 2)
		 * {
		 * 		fineControl=!fineControl;
		 * }
		 */
		boolean current=joystick.getRawButton(buttonNumber);
		if(current==previousFine)
		{
			return false;
		}
		if(current)
		{
			previousFine=true;
			return true;
		}
		else
		{
			previousFine=false;
			return false;
		}
	}
	public boolean fineControlPress(Joystick joystick, int buttonNumber)
	{
		if(joystick.getRawButton(buttonNumber))
		{
			previousFine=true;
			return true;
		}
		previousFine=false;
		return false;
	}
	//You have badArcade(), I have goodArcade(Joystick joystick). Who wins?
	public void goodArcade(Joystick joystick)
	{
		//When no fineControl boolean is set, assume to turn off
		goodArcade(joystick,false);
	}
	public void goodArcade(Joystick joystick, boolean fineControl)
	{
		double x;
		double y;
		x=joystick.getX();
		y=-1*joystick.getY();
		//Fine control reduces movement thresholds and speed for finer control.
		//Use with a toggle button or held button. Should be false during normal driving
		if(!fineControl)
		{
			//Check for significant joystick movement
			if(x>=moveThreshold||y>=moveThreshold)
			{
				//Check if more inclined towards forwards or sidewise
				if(Math.abs(x)<sideThreshold)
				{
					//Time for forwards/backwards movement
					leftMotor(y, fineControl);
					rightMotor(y, fineControl);
				}
				else
				{
					//Turning
					leftMotor(x, fineControl);
					rightMotor(-1.0*x, fineControl);
				}
			}
			else
			{
				//Stops all motors
				leftMotor(0.0, fineControl);
				rightMotor(0.0, fineControl);
			}
		}
		else
		{
			//Fine control enabled. Essentially same code but with "f" prefix
			//Check for significant joystick movement
			if(x>=fmoveThreshold||y>=fmoveThreshold)
			{
				//Check if more inclined towards forwards or sidewise
				if(Math.abs(x)<fsideThreshold)
				{
					//Time for forwards/backwards movement
					leftMotor(y, fineControl);
					rightMotor(y, fineControl);
				}
				else
				{
					//Turning
					leftMotor(x, fineControl);
					rightMotor(-1.0*x, fineControl);
				}
			}
			else
			{
				//Stops all motors
				leftMotor(0.0, fineControl);
				rightMotor(0.0, fineControl);
			}
		}
		//Actually move the motors;
		moveMotor();
	}
	//I got lazy typing this over and over again
	private void leftMotor(double speed, boolean fine)
	{
		if(!fine)
		{
			lbq=(speed*speedMultiplier);
			lfq=(speed*speedMultiplier);
		}
		else
		{
			lbq=(speed*fspeedMultiplier);
			lfq=(speed*fspeedMultiplier);
		}
	}
	private void rightMotor(double speed, boolean fine)
	{
		if(!fine)
		{
			rbq=(speed*speedMultiplier);
			rfq=(speed*speedMultiplier);
		}
		else
		{
			rbq=(speed*fspeedMultiplier);
			rfq=(speed*fspeedMultiplier);
		}
	}
	private void moveMotor()
	{
		//Uses the values in the queue to move the motors
		leftBackMotor.set(limit(lbq));
		leftFrontMotor.set(limit(lfq));
		rightBackMotor.set(limit(rbq));
		rightFrontMotor.set(limit(rfq));
		/*
		//Clears queue, not sure if useful
		lbq=0.0;
		lfq=0.0;
		rbq=0.0;
		rfq=0.0;
		*/
	}
	private double limit(double speed)
	{
		//Ensures speed is a valid number for motors
		if(speed>1.0)
		{
			speed=1.0;
			return speed;
		}
		if(speed<-1.0)
		{
			speed=-1.0;
			return speed;
		}
		return speed;
	}
	
	public void drive(double left, double right) {
		m_drive.tankDrive(left, right);
	}

	/**
	 * @param joy The ps3 style joystick to use to drive tank style.
	 */
	public void drive(Joystick joy) {
		drive(joy.getRawAxis(1), joy.getRawAxis(5));
		//drive(0,0);
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		left_encoder.reset();
		right_encoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance() {
		return (left_encoder.getDistance() + right_encoder.getDistance())/2;
	}

}
