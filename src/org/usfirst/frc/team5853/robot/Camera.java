package org.usfirst.frc.team5853.robot;

import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * Handles the vision computations. The Idea is that this entire class is modular, so 
 * each individual process can be called by itself. That may not turn out very well.
 * @author Benjamin Kittendorf
 * @version 0.0.0001
 */
public class Camera {

	USBCamera cam;
	CameraServer server;
	public static Image imageFinal = null;
	static int framesPerSecond = 1;
	Preferences prefs = Robot.prefs;
	public int[] hsvPrefs = new int[6];

	/**
	 * Instantiates a USBCamera object.
	 * @param name What to call the thing
	 * @param fps number of pictures per second. While 60fps is glorious, don't try it.
	 */
	public Camera(String name, int fps){
		cam = new USBCamera(name);
		server = CameraServer.getInstance();
		cam.openCamera();
		setCamParams();
		framesPerSecond = fps;
		server.setQuality(50);
		inithsvPrefs();
	}

	/**
	 * Initializes Preferences for HSV filtering. If a preference isn't found, assumes the widest range.
	 */
	private void inithsvPrefs(){
		hsvPrefs[0] = prefs.getInt("hMin", 0);
		hsvPrefs[1] = prefs.getInt("hMax", 255);
		hsvPrefs[2] = prefs.getInt("sMin", 0);
		hsvPrefs[3] = prefs.getInt("sMax", 255);
		hsvPrefs[4] = prefs.getInt("vMin", 0);
		hsvPrefs[5] = prefs.getInt("vMax", 255);
	}

	/**
	 * I don't know if this is required, but it sets up some basic parameters for the camera, like
	 * Exposure, Brightness, White Balance, and FPS
	 */
	private void setCamParams(){
		cam.setExposureAuto();
		cam.setBrightness(30);
		cam.setWhiteBalanceAuto();
		cam.setFPS(framesPerSecond);
		cam.updateSettings();
	}

	/**
	 * The (second) simplest way to send a camera image to the dashboard.
	 */
	public void simpleVision(){
		cam.getImage(imageFinal);
		server.setImage(imageFinal);
		Timer.delay(1/framesPerSecond);
		//TODO Fix this, it is required.
	}

}
