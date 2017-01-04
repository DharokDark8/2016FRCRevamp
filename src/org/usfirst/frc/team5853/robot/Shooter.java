package org.usfirst.frc.team5853.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * Controls the Shooting Mechanism and associated paraphernalia, namely encoders and limit switches.
 * @author Benjamin
 */
public class Shooter implements IOs{


	private static VictorSP leftWheel;
	private static VictorSP rightWheel;
	private static Spark Arm;

	private static Encoder shooterEnc;		//winch-mounted encoder
	private static DigitalInput switchDown;
	private static DigitalInput switchUp;

	//May be made obsolete by the use of a Spark speed controller.
	private static boolean ifHitTop = false;	//For making sure the upper limit switch hasn't already been set.
	private static boolean ifHitBottom = false;	//For making sure the lower limit switch hasn't already been set.
	
	static double limitUpper = 15000;			//Current upper Limit. Should be defined by [.getDistance()]
	static double limitLower = -15000;			//Current lower Limit. Should be defined by [.getDistance()]

	private static int lastPOV = -1;

	/**
	 * Creates objects located on the shooting mechanism based on values located in the [IOs] interface
	 */
	public Shooter(){
		leftWheel = new VictorSP(lShWh);
		rightWheel = new VictorSP(rShWh);
		Arm = new Spark(shArm);

		shooterEnc = new Encoder(shEnc1, shEnc2);
		switchDown = new DigitalInput(2);
		switchUp = new DigitalInput(3);

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
	 * @param s Speed to move the winch (The winch is very slow, so 1 is recommended)
	 */
	public static void moveArm(double s){
		Arm.set(s);
	}

	/**
	 * Method for controlling the shooting arm.
	 * @param pov Input between 0-7(coincidentally the same as the output of [Gamepad.getPOV()])
	 */
	public void controlArm(int pov){
		if(lastPOV == 2 && Robot.gp.getPOV() == -1){		//If D-Pad is at 3 go all the way down
			Arm.set(-1);
		}else if(lastPOV == 6 && Robot.gp.getPOV() == -1){	//If D-Pad is at 9 go all the way up
			Arm.set(1);
		}else if(Robot.gp.getPOV() == 0){					//If D-Pad is at 1 go up
			Arm.set(1);
		}else if(Robot.gp.getPOV() == 4){					//If D-Pad is at 6 go down
			Arm.set(-1);
		}else{												//Emergency State if input is f'ed up.
			Arm.set(0);
		}

		lastPOV = Robot.gp.getPOV();
	}

	/**
	 * Call this periodically to ensure that the limit switches record encoder values.
	 */
	public void setLimits(){
		if(switchUp.get() && !ifHitTop){
			limitUpper = shooterEnc.getDistance();
		}
		if(switchDown.get() && !ifHitBottom){
			limitLower = shooterEnc.getDistance();
		}
	}
}
