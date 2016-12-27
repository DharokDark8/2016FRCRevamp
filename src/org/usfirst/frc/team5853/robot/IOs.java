package org.usfirst.frc.team5853.robot;

/**
 * Stores the unchangeable values of PWM, DIO, and AIO channels.
 * @author Benjamin
 */
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
}
