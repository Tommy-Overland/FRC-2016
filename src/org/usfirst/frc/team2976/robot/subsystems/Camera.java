
package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.commands.VisionCommand;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
	 public int session;
	 public int session2;
	 public Image frame;
	 public Image frame2;
	    
	public Camera(String camera){
	
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera(camera,
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        
        /*frame2 = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        
        session2 = NIVision.IMAQdxOpenCamera("cam1",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session2);*/
   
	}
    	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        setDefaultCommand(new VisionCommand(session, frame));
    	
    }
}


