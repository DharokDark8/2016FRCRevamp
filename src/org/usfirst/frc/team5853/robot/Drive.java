package org.usfirst.frc.team5853.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;

public class Drive implements IOs{

	private static VictorSP lf;
	private static VictorSP lr;
	private static VictorSP rf;
	private static VictorSP rr;
	public Encoder lDrEnc;		//Left tuffbox Encoder
	public Encoder rDrEnc;		//Right tuffbox Encoder
	public ADXRS450_Gyro gyro;


	public Drive(){
		lf = new VictorSP(lfP);
		rf = new VictorSP(rfP);
		lr = new VictorSP(lrP);
		rr = new VictorSP(rrP);

		lDrEnc = new Encoder(lDrEnc1, lDrEnc2, true);
		rDrEnc = new Encoder(rDrEnc1, rDrEnc2, false);

		gyro = new ADXRS450_Gyro();

		lf.setInverted(true);
		lr.setInverted(true);
	}

	/**
	 * Controls the Robot based on two inputs.
	 * @param l Speed of left side
	 * @param r Speed of right side
	 */
	public void tankDrive(double l, double r){
		driveL(l);
		driveR(r);
	}

	private static void driveR(double r) {
		rf.set(r);
		rr.set(r);
	}

	private static void driveL(double l){
		lf.set(l);
		lr.set(l);
	}

	/**
	 * Modifies input variables. Checks against deadzone and turbo, and will square input as well.
	 * @param input [l] or [r]
	 * @return Modified Input
	 */
	public double inputMods(double input) {
		if(input > deadzone){
			//Checks to see if Turbo is active.
			double multi = (Robot.gp.getRawButton(BUTTON_SHOULDER_RIGHT))? 1 : nonTurboSpeed;

			//Checks to see whether inputs should be squared.
			return (squareInputs)? Math.pow(input * multi, 2): input * multi;
		}else{
			return 0;
		}
	}

}
