package org.usfirst.frc.team2976.robot.override;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.communication.UsageReporting;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tInstances;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tResourceType;

public class TankDrivePlus extends RobotDrive {

	public TankDrivePlus(int leftMotorChannel, int rightMotorChannel) {
		super(leftMotorChannel, rightMotorChannel);
		// TODO Auto-generated constructor stub
	}

	public TankDrivePlus(SpeedController leftMotor, SpeedController rightMotor) {
		super(leftMotor, rightMotor);
		// TODO Auto-generated constructor stub
	}

	public TankDrivePlus(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}

	public TankDrivePlus(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor,
			SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}
	  public void tankDrive(double leftValue, double rightValue, boolean squaredInputs) {

		    if (!kTank_Reported) {
		      UsageReporting.report(tResourceType.kResourceType_RobotDrive, getNumMotors(),
		          tInstances.kRobotDrive_Tank);
		      kTank_Reported = true;
		    }

		    // square the inputs (while preserving the sign) to increase fine control
		    // while permitting full power
		    leftValue = limit(leftValue);
		    rightValue = limit(rightValue);
		    if (squaredInputs) {
		      if (leftValue >= 0.0) {
		        leftValue = (leftValue * leftValue);
		      } else {
		        leftValue = -(leftValue * leftValue);
		      }
		      if (rightValue >= 0.0) {
		        rightValue = (rightValue * rightValue);
		      } else {
		        rightValue = -(rightValue * rightValue);
		      }
		    }
		    setLeftRightMotorOutputs(leftValue, rightValue);
		  }

}
