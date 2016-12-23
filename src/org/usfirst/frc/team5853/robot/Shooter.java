package org.usfirst.frc.team5853.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;

public class Shooter implements IOs{

	private static VictorSP leftWheel;
	private static VictorSP rightWheel;
	private static Spark Arm;
	
	public Shooter(){
		leftWheel = new VictorSP(lShWh);
		rightWheel = new VictorSP(rShWh);
		Arm = new Spark(shArm);
		
		leftWheel.setInverted(true);
	}
	
	/**
	 * Spins the Shooter's ejection wheels.
	 * @param s Speed at which to spin said wheels
	 */
	public static void spinWheels(double s){
		leftWheel.set(s);
		rightWheel.set(s);
	}
	
	/**
	 * Controls the which motor for raising and lowering the Shooting mechanism
	 * @param s Speed to move the winch
	 */
	public static void moveArm(double s){
		Arm.set(s);
	}
}
