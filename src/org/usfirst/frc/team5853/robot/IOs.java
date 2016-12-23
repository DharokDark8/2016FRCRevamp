package org.usfirst.frc.team5853.robot;

public interface IOs {


	/**
	 * 		PLUGS		*
	 * PWMS
	 * 0	Left Drive motor
	 * 1	Left Drive motor
	 * 2	Right Drive Motor
	 * 3	Right Drive Motor
	 * 4	Left Shooter Wheel
	 * 5	Right Shooter Wheel
	 * 6	Shooter Arm
	 * 7	Shooting servo
	 * 8	
	 * 9	
	 * 
	 * RELAYS		none
	 * SOLENOIDS	none
	 * 
	 * DIGITAL IOs
	 * 0	Shooter Encoder 1
	 * 1	Shooter Encoder 2
	 * 2	Lower Shooter Limit Switch
	 * 3	Upper Shooter Limit Switch
	 * 4	
	 * 5	
	 * 6	
	 * 7	
	 * 8	
	 * 9	
	 * 
	 * ANALOG IOs
	 * 1
	 * 2
	 * 3	REV MXPdisplay Potentiometer
	 * 4
	 * 5
	 * 6
	 * 7
	 * 8
	 * 9
	 * 10
	 * 
	 * JOYSTICK 1
	 */

	//Drive Motor Constants
	final int lfP = 0;
	final int lrP = 1;
	final int rfP = 2;
	final int rrP = 3;
	
	final double nonTurboSpeed = .5;
	final double deadzone = .05;

	//Shooter Constants
	final int lShWh = 4;
	final int rShWh = 5;
	final int shArm = 6;
	final int shServ = 7;

	//DIOs
	final int shEnc1 = 0;
	final int shEnc2 = 1;
	final int shDnSw = 2;
	final int shUpSw = 3;
	final int lDrEnc1 = 4;
	final int lDrEnc2 = 5;
	final int rDrEnc1 = 6;
	final int rDrEnc2 = 7;

	//AIOs
	final int revPot = 3;

	//Controller Buttons
	final int BUTTON_A = 1;
	final int BUTTON_B = 2;
	final int BUTTON_X = 3;
	final int BUTTON_Y = 4;
	final int BUTTON_SHOULDER_LEFT = 5;
	final int BUTTON_SHOULDER_RIGHT = 6;
	final int BUTTON_BACK = 7;
	final int BUTTON_START = 8;
	final int BUTTON_LEFT_STICK = 9;
	final int BUTTON_RIGHT_STICK = 10;
	
	final boolean squareInputs = false;
	
	//Controller Axes
	final int leftXaxis = 0;
	final int leftYaxis = 1;
	final int lTrigaxis = 2;
	final int rTrigaxis = 3;
	final int rightXaxis = 4;
	final int rightYaxis = 5;
}
