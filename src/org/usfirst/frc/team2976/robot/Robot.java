
package org.usfirst.frc.team2976.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2976.robot.commands.ArcadeBot;
import org.usfirst.frc.team2976.robot.commands.ArmDynamicSetpointPID;
import org.usfirst.frc.team2976.robot.commands.LowBarAutonomous;
import org.usfirst.frc.team2976.robot.commands.DriveBOT;
import org.usfirst.frc.team2976.robot.commands.ExampleCommand;
import org.usfirst.frc.team2976.robot.commands.LeftDriveEncoder;
import org.usfirst.frc.team2976.robot.commands.RaiseBackArm;
import org.usfirst.frc.team2976.robot.commands.RaiseHook;
import org.usfirst.frc.team2976.robot.commands.RaiseRobot;
import org.usfirst.frc.team2976.robot.commands.RightDriveEncoder;
import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2976.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2976.robot.subsystems.Roller;
import org.usfirst.frc.team2976.robot.commands.RunRoller;
import org.usfirst.frc.team2976.robot.commands.TankBot;
import org.usfirst.frc.team2976.robot.commands.startCompressor;

/**
 * @author NeilHazra
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;
	SendableChooser autoChooser;
	
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final ArcadeBot ArcadeBOT = new ArcadeBot();
	public static final TankBot TankBOT = new TankBot(); //Do not start both BOTS in a single program
	public static final ArmDynamicSetpointPID armPID = new ArmDynamicSetpointPID();
	public static final RaiseRobot raiseRobot = new RaiseRobot();
	public static final RaiseHook raiseHook = new RaiseHook();
	public static final DriveBOT DriveBot = new DriveBOT();
	public static final RaiseBackArm raiseBackArm = new RaiseBackArm();
	
	
	//Drive Commands are exclusive

	public static OI oi;
	public static DriveTrain drivetrain;
	public static LeftDriveEncoder leftdriveencoder;
	public static RightDriveEncoder rightdriveencoder;
	public static Roller roller;
	//Btn Commands are started in the OI constructor
	

   
    
   

    
   // Command autonomousCommand;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Default program", new LowBarAutonomous());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
	}
	

    public void autonomousInit() {
        autonomousCommand = (Command)autoChooser.getSelected();
        if(autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
         //ArcadeBOT.start();
        //armPID.start();
        //TankBOT.start();
        DriveBot.start();
        raiseHook.start();
        raiseRobot.start();
        raiseBackArm.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
