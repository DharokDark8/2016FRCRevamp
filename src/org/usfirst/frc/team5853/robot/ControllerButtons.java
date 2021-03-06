package org.usfirst.frc.team5853.robot;

/**
 * Stores the unchangeable values of controller button numbers.
 * Currently only has listings for the Logitech f310 controller.
 * @author Benjamin
 */
public interface ControllerButtons {

	//Gamepad Controller Buttons
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

	//Gamepad Controller Axes
	final int leftXaxis = 0;
	final int leftYaxis = 1;
	final int lTrigaxis = 2;
	final int rTrigaxis = 3;
	final int rightXaxis = 4;
	final int rightYaxis = 5;

	//HOTAC Controller Buttons
	//HOTAC Controller Axes

	
	
//THIS MIGHT CRASH. I DON'T KNOW HOW INTERFACES HANDLE PREFERENCES
	//Should the inputs be squared. Checks against preferences, so it is modifiable from the dashboard
	boolean squareInputs = Robot.prefs.getBoolean("squareInputs", false);
}
