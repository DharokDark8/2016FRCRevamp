
package org.usfirst.frc.team5853.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;

/**
 * 
 * @author Benjamin K
 * @version 0.0.001 (This is legit probs bad)
 *
 */
public class Robot extends IterativeRobot implements IOs{

	static Gamepad gp;					//Accesses the Gamepad
	static Drive dr;					//Controls the Drivetrain
	static Shooter sh;					//Controls the Shooting Mechanism
	static DashBoard sd;				//Accesses the Smart Dashboard
	static RevDisplay rd;				//Controls the REV Digit MXP Display
	static Camera cam0;				//Controls the Camera
	static DriverStation ds;			//Accesses advances information from the Driver Station
	static Preferences prefs;	//Stores Data Fields across power cycles
	
	public void robotInit() {
		prefs = Preferences.getInstance();
		ds = DriverStation.getInstance();
		gp = new Gamepad(0);
		dr = new Drive();
		sh = new Shooter();
		sd = new DashBoard();
		rd = new RevDisplay();
		cam0 = new Camera("cam0", 2);
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
    	cam0.simpleVision();
    	sd.runDash();
    	rd.displayVoltage(ds.getBatteryVoltage());
    }
    
}
