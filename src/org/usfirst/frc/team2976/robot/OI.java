package org.usfirst.frc.team2976.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2976.robot.commands.AutoRaisePortcullis;
import org.usfirst.frc.team2976.robot.commands.DriveStraight;
import org.usfirst.frc.team2976.robot.commands.ExampleCommand;
import org.usfirst.frc.team2976.robot.commands.RaiseBackArm;
import org.usfirst.frc.team2976.robot.commands.RaiseHook;
import org.usfirst.frc.team2976.robot.commands.RaiseRobot;
import org.usfirst.frc.team2976.robot.commands.RunRoller;

/**
 * @author NeilHazra
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static final DriveStraight driveStraight = new DriveStraight();
	
	public enum Button {
		RBumper(6), LBumper(5), A(1), B(2), X(3), Y(4), RightJoystickBtn(10), LeftJoystickBtn(9);

		private final int number;

		Button(int number) {
			this.number = number;
		}

		public int getBtnNumber() {
			return number;
		}
	}
	public enum Axis {
		LX(0), LY(1), LTrigger(2), RTrigger(3), RX(4), RY(5);
		private final int number;

		Axis(int number) {
			this.number = number;
		}

		public int getAxisNumber() {
			return number;
		}
	}
	
	public OI()	{
		(new JoystickButton(OI.driveStick, Button.RBumper.getBtnNumber())).whileHeld(driveStraight); //Start the DriveStraight Command when held
	}
	
	public static XBoxController driveStick = new XBoxController(0);
	public static XBoxController otherStick = new XBoxController(1);
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	 public Joystick getJoystick() {
	        return driveStick;
	    }
}

