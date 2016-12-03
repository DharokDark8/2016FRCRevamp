package org.usfirst.frc.team5853.robot;

import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Camera {

	USBCamera cam;
	CameraServer server;
	public static Image imageFinal = null;
	static int framesPerSecond = 1;
	Preferences prefs = Robot.prefs;
	public int[] hsvPrefs = new int[6];

	public Camera(String name, int fps){
		cam = new USBCamera(name);
		server = CameraServer.getInstance();
		cam.openCamera();
		setCamParams();
		framesPerSecond = fps;
		server.setQuality(50);
		inithsvPrefs();
	}

	private void inithsvPrefs(){
		hsvPrefs[0] = prefs.getInt("hMin", 0);
		hsvPrefs[1] = prefs.getInt("hMax", 255);
		hsvPrefs[2] = prefs.getInt("sMin", 0);
		hsvPrefs[3] = prefs.getInt("sMax", 255);
		hsvPrefs[4] = prefs.getInt("vMin", 0);
		hsvPrefs[5] = prefs.getInt("vMax", 255);
	}
	
	private void setCamParams(){
		cam.setExposureAuto();
		cam.setBrightness(30);
		cam.setWhiteBalanceAuto();
		cam.setFPS(2);
		cam.updateSettings();
	}

	public void simpleVision(){
		cam.getImage(imageFinal);
		server.setImage(imageFinal);
		Timer.delay(1/framesPerSecond);
	}

}
