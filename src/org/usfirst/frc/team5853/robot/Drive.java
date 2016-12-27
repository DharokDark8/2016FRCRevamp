package org.usfirst.frc.team5853.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
/**
 * Controls the Drivetrain and associated paraphernalia, namely encoders and gyros.
 * @author Benjamin
 */
public class Drive implements IOs{

	private VictorSP lf;
	private VictorSP lr;
	private VictorSP rf;
	private VictorSP rr;
	public Encoder lDrEnc;		//Left tuffbox Encoder
	public Encoder rDrEnc;		//Right tuffbox Encoder
	public ADXRS450_Gyro gyro;



	public Drive(){
		lf = new VictorSP(lfW);	//Left Front Wheel
		rf = new VictorSP(rfW);	//Right Front Wheel
		lr = new VictorSP(lrW);	//Left Rear Wheel
		rr = new VictorSP(rrW);	//Right Rear Wheel

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

	/**
	 * Drives right wheels. Designed to make driving methods easier to write
	 * @param r Speed of the right wheels.
	 */
	private void driveR(double r) {
		rf.set(r);
		rr.set(r);
	}

	/**
	 * Drives right wheels. Designed to make driving methods easier to write
	 * @param r Speed of the right wheels.
	 */
	private void driveL(double l){
		lf.set(l);
		lr.set(l);
	}

	/**
	 * Modifies input variables. Checks against deadzone and turbo, and will square input as well.
	 * @param input [l] or [r]
	 * @return Modified Input
	 */
	public double inputMods(double input, int turboButton, boolean squareInputs) {
		if(input > deadzone){
			//Checks to see if Turbo is active.
			double multi = (Robot.gp.getRawButton(turboButton))? 1 : nonTurboSpeed;

			//Checks to see whether inputs should be squared.
			return (squareInputs)? Math.pow(input * multi, 2): input * multi;
		}else{
			return 0;
		}
	}

}
