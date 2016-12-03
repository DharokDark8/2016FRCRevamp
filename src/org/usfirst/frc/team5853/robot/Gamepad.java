package org.usfirst.frc.team5853.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Gamepad extends Joystick implements IOs{

	
	
	public Gamepad(int port){
		super(port);
	}

	public boolean getRawButton(int button){
		return super.getRawButton(button);
	}

	/**
	 * Gets the current value from the chosen axis.
	 * See the IOs Interface for the axis labels.
	 */
	public double getRawAxis(int axis){
		return super.getRawAxis(axis);
	}
	
	/**
	 * Gets the position of the Dpad, clockwise starting at 0.
	 */
	public int getPOV(){
		return super.getPOV() / 45;
	}
	

}
