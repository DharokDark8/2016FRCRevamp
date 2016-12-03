
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

	Gamepad gp;
	Drive dr;
	Shooter sh;
	DashBoard sd;
	RevDisplay rd;
	Camera cam0;
	DriverStation ds;
	static Preferences prefs;
	
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
    	double l = gp.getRawAxis(leftYaxis);
    	double r = gp.getRawAxis(rightYaxis);
    	if(gp.getRawButton(BUTTON_SHOULDER_RIGHT)){
    		dr.tankDrive(l, r);
    	}else{
    		dr.tankDrive(l/2, r/2);
    	}
    	cam0.simpleVision();
    	sd.runDash();
    	rd.displayVoltage(ds.getBatteryVoltage());
    }
    
}
