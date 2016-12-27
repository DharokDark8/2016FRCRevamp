package org.usfirst.frc.team5853.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Accesses and controls the Java Smart Dashboard.
 * @author Benjamin Kittendorf
 */
public class DashBoard {

	int screenNum = 0;


	public DashBoard(){
		initDash();	
	}

	/**
	 * Initializes every Smart Dashboard field with empty values.
	 */
	private void initDash(){

		SmartDashboard.putNumber("Screen", 0);

		SmartDashboard.putString("0", "TEAM 5853 SMART DASHBOARD");
		SmartDashboard.putString("1", "  MADE BY YOURS TRUELY,");
		SmartDashboard.putString("2", "  BENJAMIN KITTNENDORF");
		SmartDashboard.putString("3", "");
		SmartDashboard.putString("4", "");
		SmartDashboard.putString("5", "");
		SmartDashboard.putString("6", "");
		SmartDashboard.putString("7", "");
		SmartDashboard.putString("8", "");
		SmartDashboard.putString("9", "");
		SmartDashboard.putString("10", "");
		SmartDashboard.putString("11", "");
		SmartDashboard.putString("12", "");
		SmartDashboard.putString("13", "");
		SmartDashboard.putString("14", "");
	}


	/**
	 * Runs the Smart Dashboard with custom inputs, switching screens based on [screenNum].
	 */
	public void runDash(){

		switch(screenNum){
		case 0:
			SmartDashboard.putString("0", "Overview Mode");
			SmartDashboard.putString("1", "");
			SmartDashboard.putString("2", "");
			SmartDashboard.putString("3", "");
			SmartDashboard.putString("4", "");
			SmartDashboard.putString("5", "");
			SmartDashboard.putString("6", "");
			SmartDashboard.putString("7", "");
			SmartDashboard.putString("8", "");
			SmartDashboard.putString("9", "");
			SmartDashboard.putString("10", "");
			SmartDashboard.putString("11", "");
			SmartDashboard.putString("12", "");
			SmartDashboard.putString("13", "");
			SmartDashboard.putString("14", "");
			break;
		case 1:
			SmartDashboard.putString("0", "Drive Overview");
			SmartDashboard.putString("1", "");
			SmartDashboard.putString("2", "");
			SmartDashboard.putString("3", "");
			SmartDashboard.putString("4", "");
			SmartDashboard.putString("5", "");
			SmartDashboard.putString("6", "");
			SmartDashboard.putString("7", "");
			SmartDashboard.putString("8", "");
			SmartDashboard.putString("9", "");
			SmartDashboard.putString("10", "");
			SmartDashboard.putString("11", "");
			SmartDashboard.putString("12", "");
			SmartDashboard.putString("13", "");
			SmartDashboard.putString("14", "");
			break;
		case 2:
			SmartDashboard.putString("0", "Shooter Overview");
			SmartDashboard.putString("1", "");
			SmartDashboard.putString("2", "");
			SmartDashboard.putString("3", "");
			SmartDashboard.putString("4", "");
			SmartDashboard.putString("5", "");
			SmartDashboard.putString("6", "");
			SmartDashboard.putString("7", "");
			SmartDashboard.putString("8", "");
			SmartDashboard.putString("9", "");
			SmartDashboard.putString("10", "");
			SmartDashboard.putString("11", "");
			SmartDashboard.putString("12", "");
			SmartDashboard.putString("13", "");
			SmartDashboard.putString("14", "");
			break;
		case 3:
			SmartDashboard.putString("0", "");
			SmartDashboard.putString("1", "");
			SmartDashboard.putString("2", "");
			SmartDashboard.putString("3", "");
			SmartDashboard.putString("4", "");
			SmartDashboard.putString("5", "");
			SmartDashboard.putString("6", "");
			SmartDashboard.putString("7", "");
			SmartDashboard.putString("8", "");
			SmartDashboard.putString("9", "");
			SmartDashboard.putString("10", "");
			SmartDashboard.putString("11", "");
			SmartDashboard.putString("12", "");
			SmartDashboard.putString("13", "");
			SmartDashboard.putString("14", "");
			break;
		case 4:
			SmartDashboard.putString("0", "");
			SmartDashboard.putString("1", "");
			SmartDashboard.putString("2", "");
			SmartDashboard.putString("3", "");
			SmartDashboard.putString("4", "");
			SmartDashboard.putString("5", "");
			SmartDashboard.putString("6", "");
			SmartDashboard.putString("7", "");
			SmartDashboard.putString("8", "");
			SmartDashboard.putString("9", "");
			SmartDashboard.putString("10", "");
			SmartDashboard.putString("11", "");
			SmartDashboard.putString("12", "");
			SmartDashboard.putString("13", "");
			SmartDashboard.putString("14", "");
			break;
		case 5:
			SmartDashboard.putString("0", "");
			SmartDashboard.putString("1", "");
			SmartDashboard.putString("2", "");
			SmartDashboard.putString("3", "");
			SmartDashboard.putString("4", "");
			SmartDashboard.putString("5", "");
			SmartDashboard.putString("6", "");
			SmartDashboard.putString("7", "");
			SmartDashboard.putString("8", "");
			SmartDashboard.putString("9", "");
			SmartDashboard.putString("10", "");
			SmartDashboard.putString("11", "");
			SmartDashboard.putString("12", "");
			SmartDashboard.putString("13", "");
			SmartDashboard.putString("14", "");
			break;
		case 6:
			SmartDashboard.putString("0", "");
			SmartDashboard.putString("1", "");
			SmartDashboard.putString("2", "");
			SmartDashboard.putString("3", "");
			SmartDashboard.putString("4", "");
			SmartDashboard.putString("5", "");
			SmartDashboard.putString("6", "");
			SmartDashboard.putString("7", "");
			SmartDashboard.putString("8", "");
			SmartDashboard.putString("9", "");
			SmartDashboard.putString("10", "");
			SmartDashboard.putString("11", "");
			SmartDashboard.putString("12", "");
			SmartDashboard.putString("13", "");
			SmartDashboard.putString("14", "");
			break;
		case 7:
			SmartDashboard.putString("0", "");
			SmartDashboard.putString("1", "");
			SmartDashboard.putString("2", "");
			SmartDashboard.putString("3", "");
			SmartDashboard.putString("4", "");
			SmartDashboard.putString("5", "");
			SmartDashboard.putString("6", "");
			SmartDashboard.putString("7", "");
			SmartDashboard.putString("8", "");
			SmartDashboard.putString("9", "");
			SmartDashboard.putString("10", "");
			SmartDashboard.putString("11", "");
			SmartDashboard.putString("12", "");
			SmartDashboard.putString("13", "");
			SmartDashboard.putString("14", "");
			break;
		case 8:
			SmartDashboard.putString("0", "");
			SmartDashboard.putString("1", "");
			SmartDashboard.putString("2", "");
			SmartDashboard.putString("3", "");
			SmartDashboard.putString("4", "");
			SmartDashboard.putString("5", "");
			SmartDashboard.putString("6", "");
			SmartDashboard.putString("7", "");
			SmartDashboard.putString("8", "");
			SmartDashboard.putString("9", "");
			SmartDashboard.putString("10", "");
			SmartDashboard.putString("11", "");
			SmartDashboard.putString("12", "");
			SmartDashboard.putString("13", "");
			SmartDashboard.putString("14", "");
			break;
		case 9:
			SmartDashboard.putString("0", "");
			SmartDashboard.putString("1", "");
			SmartDashboard.putString("2", "");
			SmartDashboard.putString("3", "");
			SmartDashboard.putString("4", "");
			SmartDashboard.putString("5", "");
			SmartDashboard.putString("6", "");
			SmartDashboard.putString("7", "");
			SmartDashboard.putString("8", "");
			SmartDashboard.putString("9", "");
			SmartDashboard.putString("10", "");
			SmartDashboard.putString("11", "");
			SmartDashboard.putString("12", "");
			SmartDashboard.putString("13", "");
			SmartDashboard.putString("14", "");
			break;
		default:
			screenNum = 0;
			return;
		}
		readScreen();
	}
	/**
	 * Updates [readScreen], for switching Diagnostic Screens. Called internally.
	 */
	private void readScreen() {
		try{
			screenNum = (int) SmartDashboard.getNumber("Screen", 0);
		}catch(IllegalArgumentException IAE){
			IAE.printStackTrace();
		}
	}
}
