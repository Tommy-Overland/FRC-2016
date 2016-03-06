package org.usfirst.frc.team2976.robot;
/**
 *@author Tommy Overland
 */
import edu.wpi.first.wpilibj.Joystick;

public class XBoxController extends Joystick {

		private final int rightX=4;
		private final int rightY=5;
		private final int rightTrigger=2;
		private final int leftTrigger=3;
		private final int leftX=0;
		private final int leftY=1;
		private final int AButton=1;
		private final int BButton=2;
		private final int XButton=3;
		private final int YButton=4;
		private final int LBumber=5;
		private final int RBumber=6;
		public boolean isAuto=false;
		public double setRX=0;
		public double setRY=0;
		public double setLX=0;
		public double setLY=0;
	public XBoxController(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}

	public XBoxController(int port, int numAxisTypes, int numButtonTypes) {
		super(port, numAxisTypes, numButtonTypes);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void setAuto(boolean set){
		isAuto=set;
	}
	public void setRX(double set){
		setRX=set;
	}
	public void setRY(double set){
		setRY=set;
	}
	public void setLX(double set){
		setLX=set;
	}
	public void setLY(double set){
		setLY=set;
	}
	public double getLX(){
		if(isAuto){
			return setLX;
		}
		return super.getRawAxis(this.leftX);
	}
	public double getLY(){
		if(isAuto){
			return setLY;
		}
		return super.getRawAxis(this.leftY);
	}
	public double getRX(){
		if(isAuto){
			return setRX;
		}
		return super.getRawAxis(this.rightX);
	}
	public double getRY(){
		if(isAuto){
			return setRY;
		}
		return super.getRawAxis(this.rightY);
	}
	public boolean getAButton(){
		return super.getRawButton(this.AButton);
	}
	public boolean getBButton(){
		return super.getRawButton(this.BButton);
	}
	public boolean getXButton(){
		return super.getRawButton(this.XButton);
	}
	public boolean getYButton(){
		return super.getRawButton(this.YButton);
	}
	public boolean getLBumper(){
		return super.getRawButton(this.LBumber);
	}
	public boolean getRBumber(){
		return super.getRawButton(this.RBumber);
	}
	public double getLTriggerPos(){
		return super.getRawAxis(this.leftTrigger);
	}
	public double getRTriggerPos(){
		return super.getRawAxis(this.rightTrigger);
	}
	public boolean getLTriggerPressed(){
		if(super.getRawAxis(this.leftTrigger)>=.6){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean getRTriggerPressed(){
		if(super.getRawAxis(this.rightTrigger)>=.6){
			return true;
		}
		else{
			return false;
		}
	}
	
}
