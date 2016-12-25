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
	final int lfW = 0;	//Left Front Wheel
	final int lrW = 1;	//Left Rear Wheel
	final int rfW = 2;	//Right Front Wheel
	final int rrW = 3;	//Right Rear Wheel
	
	final double nonTurboSpeed = .5;	//Speed multiplier for non-turbo
	final double deadzone = .05;		//Joystick Deadzone

	//Shooter Constants
	final int lShWh = 4;	//Left Ejection Wheel
	final int rShWh = 5;	//Right Ejection Wheel
	final int shArm = 6;	//Winch Motor
	final int shServ = 7;	//Launching Servo

	//DIOs
							//Encoders require 2 DIO channels
	final int shEnc1 = 0;	//Shooter Encoder Primary
	final int shEnc2 = 1;	//Shooter Encoder Secondary
	final int shDnSw = 2;	//Lower Shooter Limit Switch
	final int shUpSw = 3;	//Upper Shooter Limit Switch
	final int lDrEnc1 = 4;	//Left Drive Encoder Primary
	final int lDrEnc2 = 5;	//Left Drive Encoder Secondary
	final int rDrEnc1 = 6;	//Right Drive Encoder Primary
	final int rDrEnc2 = 7;	//Right Drive Encoder Secondary

	//AIOs
	final int revPot = 3;	//Analog Address of the REV Digit MXP Potentiometer.

	//Controller Buttons
	//I'm not labeling every single one of these.
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
	
	final boolean squareInputs = false;	//Should the inputs be squared.
	
	//Controller Axes
	//I'm not labeling every one of these.
	final int leftXaxis = 0;
	final int leftYaxis = 1;
	final int lTrigaxis = 2;
	final int rTrigaxis = 3;
	final int rightXaxis = 4;
	final int rightYaxis = 5;
}
