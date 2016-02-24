
package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.Robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

//import org.usfirst.frc.team2976.robot.Robot;

/**
 *
 */
public class VisionCommand extends Command {
	 public int session;
	 public Image frame;
	 public int session2;
	 public Image frame2;


    public VisionCommand(int p_session, Image p_frame) {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.exampleSubsystem);
        requires(Robot.camera);
    	session = p_session;
    	frame = p_frame;
    	/*session2= s_session;
    	frame2 = s_frame;*/
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 NIVision.Rect rect=new NIVision.Rect(150,150,100,460);

        NIVision.IMAQdxGrab(session, frame, 1);
        ///NIVision.IMAQdxGrab(session2, frame2, 1);
        
        NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
            
        CameraServer.getInstance().setImage(frame);
            
           
          //  NIVision.imaqDrawShapeOnImage(frame,frame,rect2,DrawMode.PAINT_VALUE,ShapeMode.SHAPE_RECT,0.0f);
            //CameraServer.getInstance().setImage(frame);
           
            /** robot code here! **/
      //    Timer.delay(0.005);		// wait for a motor update time
        
      //  NIVision.IMAQdxStopAcquisition(session);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
