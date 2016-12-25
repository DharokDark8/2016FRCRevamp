package org.usfirst.frc.team5853.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Gamepad extends Joystick implements IOs{



	public Gamepad(int port){
		super(port);
	}

	/**
	 * @param Button ID. See [IOs] for list of IDs
	 * @return Boolean Value of button
	 */
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
	 * Gets the position of the D-pad, clockwise starting at 0, and ending at 7.
	 */
	public int getPOV(){
		if(super.getPOV() != -1){
			return super.getPOV() / 45;			
		}else{
			return -1;
		}
	}


}
