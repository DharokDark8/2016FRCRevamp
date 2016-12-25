
package org.usfirst.frc.team5853.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;

/**
 * 
 * @author Benjamin K
 * @version 0.0.001 
 * This is legit probably the buggiest thing I've ever made.
 * This has never been tested. NEVER. Thats why its buggy.
 * It isn't buggy from a lack of good programming. It is
 * buggy because It has been in development for months now,
 * and it has never ONCE been deployed, let alone tested.
 * 
 * 
 * 
 * Obligatory ASCII of my team number name below.
 * 
 *			8888888888   ad88888ba  8888888888   ad888888b,  
 *			88          d8"     "8b 88          d8"     "88  
 *			88  ____    Y8a     a8P 88  ____            a8P  
 *			88a8PPPP8b,  "Y8aaa8P"  88a8PPPP8b,      aad8"   
 *			PP"     `8b  ,d8"""8b,  PP"     `8b      ""Y8,   
 *			         d8 d8"     "8b          d8         "8b  
 *			Y8a     a8P Y8a     a8P Y8a     a8P Y8,     a88  
 *			 "Y88888P"   "Y88888P"   "Y88888P"   "Y888888P'   
 *
 *I am not artistic, so ASCII is courtesy of [http://www.network-science.de/ascii/] (univers font)
 *
 */
public class Robot extends IterativeRobot implements IOs{

	static Gamepad gp;					//Accesses the Gamepad
	static Drive dr;					//Controls the Drivetrain
	static Shooter sh;					//Controls the Shooting Mechanism
	static DashBoard sd;				//Accesses the Smart Dashboard
	static RevDisplay rd;				//Controls the REV Digit MXP Display
	static Camera cam0;					//Controls the Camera
	static DriverStation ds;			//Accesses advances information from the Driver Station
	static Preferences prefs;			//Stores Data Fields across power cycles
	
	public void robotInit() {
		prefs = Preferences.getInstance();
		ds = DriverStation.getInstance();
		gp = new Gamepad(0);
		dr = new Drive();
		sh = new Shooter();
		sd = new DashBoard();
		rd = new RevDisplay();
		cam0 = new Camera("cam0", 2);
		
		dr.gyro.calibrate();
    }
	
	public void disabledInit(){
		rd.revDisplayInit();
	}

	public void disabledPeriodic(){
		cam0.simpleVision();
		sd.runDash();
		rd.displayVoltage(ds.getBatteryVoltage());
	}
    public void teleopInit(){
    	
    }
    
    public void teleopPeriodic() {
    	double l = dr.inputMods(gp.getRawAxis(leftYaxis));
    	double r = dr.inputMods(gp.getRawAxis(rightYaxis));
    	dr.tankDrive(l, r);
    	sh.controlArm(gp.getPOV());
    	cam0.simpleVision();
    	sd.runDash();
    	rd.displayVoltage(ds.getBatteryVoltage());
    }
    
}
