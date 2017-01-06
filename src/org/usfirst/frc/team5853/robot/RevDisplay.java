package org.usfirst.frc.team5853.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.Timer;

/**
 * Controls the REV Digit MXP Display. Handy little bugger, for sure.
 * 
 * @author Github's "red-green" for base code.
 * @author Dan Katanski for getting it working (and some technical clerical fixes).
 * @author Benjamin Kittendorf of team 5853 for cleaning it up.
 */
public class RevDisplay
{
	I2C i2c;

	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;

	static byte osc [];
	static byte blink [];
	static byte bright [];

	static byte charreg [] [];								//Character bit pattern array.

	final int SPACE_CHARACTER_INDEX = 36;
	final byte DECIMAL_POINT = 0b01000000;					//Bit to turn on a decimal point.

	Timer scrollTimer = new Timer();
	
	/**
	 *  Instantiates an I2C connection with proper byte values to turn on the Display.
	 */
	public RevDisplay(){
		//I2C address of the digit board is 0x70
		i2c = new I2C(Port.kMXP, 0x70);

		osc = new byte [1];
		osc[0] = (byte)0x21;								//Put values into the arrays.

		blink = new byte [1];
		blink[0] = (byte)0x81;

		bright = new byte [1];
		bright[0] = (byte)0xEF;

		//This is the array of all characters.
		charreg = new byte[39][2];
		charreg[0][0] = (byte)0b00111111; charreg[0][1] = (byte)0b00000000; //0	
		charreg[1][0] = (byte)0b00000110; charreg[1][1] = (byte)0b00000000; //1
		charreg[2][0] = (byte)0b11011011; charreg[2][1] = (byte)0b00000000; //2
		charreg[3][0] = (byte)0b11001111; charreg[3][1] = (byte)0b00000000; //3
		charreg[4][0] = (byte)0b11100110; charreg[4][1] = (byte)0b00000000; //4
		charreg[5][0] = (byte)0b11101101; charreg[5][1] = (byte)0b00000000; //5
		charreg[6][0] = (byte)0b11111101; charreg[6][1] = (byte)0b00000000; //6
		charreg[7][0] = (byte)0b00000111; charreg[7][1] = (byte)0b00000000; //7
		charreg[8][0] = (byte)0b11111111; charreg[8][1] = (byte)0b00000000; //8
		charreg[9][0] = (byte)0b11101111; charreg[9][1] = (byte)0b00000000; //9

		charreg[10][0] = (byte)0b11110111; charreg[10][1] = (byte)0b00000000; //A
		charreg[11][0] = (byte)0b10001111; charreg[11][1] = (byte)0b00010010; //B
		charreg[12][0] = (byte)0b00111001; charreg[12][1] = (byte)0b00000000; //C
		charreg[13][0] = (byte)0b00001111; charreg[13][1] = (byte)0b00010010; //D
		charreg[14][0] = (byte)0b11111001; charreg[14][1] = (byte)0b00000000; //E
		charreg[15][0] = (byte)0b11110001; charreg[15][1] = (byte)0b00000000; //F
		charreg[16][0] = (byte)0b10111101; charreg[16][1] = (byte)0b00000000; //G
		charreg[17][0] = (byte)0b11110110; charreg[17][1] = (byte)0b00000000; //H
		charreg[18][0] = (byte)0b00001001; charreg[18][1] = (byte)0b00010010; //I
		charreg[19][0] = (byte)0b00011110; charreg[19][1] = (byte)0b00000000; //J
		charreg[20][0] = (byte)0b01110000; charreg[20][1] = (byte)0b00001100; //K
		charreg[21][0] = (byte)0b00111000; charreg[21][1] = (byte)0b00000000; //L
		charreg[22][0] = (byte)0b00110110; charreg[22][1] = (byte)0b00000101; //M
		charreg[23][0] = (byte)0b00110110; charreg[23][1] = (byte)0b00001001; //N
		charreg[24][0] = (byte)0b00111111; charreg[24][1] = (byte)0b00000000; //O
		charreg[25][0] = (byte)0b11110011; charreg[25][1] = (byte)0b00000000; //P
		charreg[26][0] = (byte)0b00111111; charreg[26][1] = (byte)0b00001000; //Q
		charreg[27][0] = (byte)0b11110011; charreg[27][1] = (byte)0b00001000; //R
		charreg[28][0] = (byte)0b10001101; charreg[28][1] = (byte)0b00000001; //S
		charreg[29][0] = (byte)0b00000001; charreg[29][1] = (byte)0b00010010; //T
		charreg[30][0] = (byte)0b00111110; charreg[30][1] = (byte)0b00000000; //U
		charreg[31][0] = (byte)0b00110000; charreg[31][1] = (byte)0b00100100; //V
		charreg[32][0] = (byte)0b00110110; charreg[32][1] = (byte)0b00101000; //W
		charreg[33][0] = (byte)0b00000000; charreg[33][1] = (byte)0b00101101; //X
		charreg[34][0] = (byte)0b00000000; charreg[34][1] = (byte)0b00010101; //Y
		charreg[35][0] = (byte)0b00001001; charreg[35][1] = (byte)0b00100100; //Z

		charreg[36][0] = (byte)0b00000000; charreg[36][1] = (byte)0b00000000; //Space

		charreg[37][0] = (byte)0b00001100; charreg[37][1] = (byte)0b11000000; //+ 
		charreg[38][0] = (byte)0b00000000; charreg[38][1] = (byte)0b11000000; //-
		//charreg[__][0] = (byte)0b00000000; charreg[__][1] = (byte)0b00000000; // Template.


	} // public void RevDisplay ()


	/**
	 * Sets up the board - turn on, set blinking and brightness, This is required to turn on the display.
	 */
	public void revDisplayInit(){
		i2c.writeBulk(osc);									//Output the command to the display.
		Timer.delay(.01);									//Pause slightly between commands.
		i2c.writeBulk(bright);
		Timer.delay(.01);
		i2c.writeBulk(blink);
		Timer.delay(.01);
	} // public revDisplayInit ()

	/**
	 * Retrieves a byte from the byte array.
	 * @param s The letter you want
	 * @param i Which of the 2 bytes you want (1 or 0)
	 * @return the first or second byte corresponding to the letter.
	 */
	private byte getCharReg(String s, int i){
		int c;												//The character to find.
		byte j;												//the index into charreg.

		c = s.charAt(i);

		if((c >= '0') && (c <= '9')){
			j = (byte) (c - '0');
		}else if((c >= 'A') && (c <= 'Z')){
			j = (byte) (c - 'A' + 10);
		}else if((c >= 'a') && (c <= 'z')){
			j = (byte) (c - 'a' + 10);						//Make the letter upper case.
		}else if(c == ' '){
			j = 36;											//Handle the space character.
		}else{
			j = 33;											//Unknown character, make it an 'X'.
		}

		return j;
	} // int getCharreg (String s, int i)


	/**
	 * This function is called periodically during operator control to display a 4 character long string. Will truncate.
	 */
	public void display(String s){

		s = s.substring(0, 3);
		byte[] byte1 = new byte[10];
		int c0, c1, c2, c3;


		// first reset the array to zeros
		for(int c = 0; c < 10; c++)
		{
			byte1[c] = (byte)(0b00000000) & 0xFF;
		}

		if (s.length() >= 1) c0 = getCharReg(s, 0); else c0 = SPACE_CHARACTER_INDEX;
		if (s.length() >= 2) c1 = getCharReg(s, 1); else c1 = SPACE_CHARACTER_INDEX;
		if (s.length() >= 3) c2 = getCharReg(s, 2); else c2 = SPACE_CHARACTER_INDEX;
		if (s.length() >= 4) c3 = getCharReg(s, 3); else c3 = SPACE_CHARACTER_INDEX;
		//if the string is too short put in space character instead.


		// put the character data in the array    	
		byte1[0] = (byte)(0b00001111);						//Slave address
		byte1[1] = (byte)(0b00001111);

		byte1[2] = charreg[c3][0];							//This is the right most character
		byte1[3] = charreg[c3][1];

		byte1[4] = charreg[c2][0];
		byte1[5] = charreg[c2][1];

		byte1[6] = charreg[c1][0];
		byte1[7] = charreg[c1][1];

		byte1[8] = charreg[c0][0];							//This is the left most character
		byte1[9] = charreg[c0][1];

		//Send the array to the board
		i2c.writeBulk(byte1);


	} //public void Display(String s[])


	/**
	 * Displays "BEN.K". 'nuf said.
	 */
	public void displayAuthor() {

		byte[] byte1 = new byte[10];

		byte1[0] = (byte)(0b00001111);						//Slave address of the REV card.
		byte1[1] = (byte)(0b00001111);

		byte1[2] = (byte)charreg[20][0];
		byte1[3] = (byte)charreg[20][1];					//Right most character

		byte1[4] = (byte)charreg[23][0];
		byte1[5] = (byte)(charreg[23][1] | DECIMAL_POINT);	//Turn on the decimal Point 

		byte1[6] = (byte) charreg[14][0];
		byte1[7] = (byte) charreg[14][1];	 

		byte1[8] = (byte)charreg[11][0];					//Left most character
		byte1[9] = (byte)charreg[11][1];

	}

	/**
	 * Displays a 4 digit number (will add zeros) and a decimal point in the middle. 
	 * Will display a decimal point even if the double need not contain one.
	 * @param v 4 digit number.
	 */
	public void displayVoltage(double v)
	{
		int c0, c1, c2, c3;
		byte[] byte1 = new byte[10];
		String s;
		long vi;

		vi = (int)(v * 100.0);
		//s = StringUtils.format(vi, 4);						//Make a string 4 characters long with leading spaces.
		s = ("    "+vi).substring(("    "+vi).length()-4);

		c0 = getCharReg(s, 0);								//Get the index into the bid table for the bit pattern.
		c1 = getCharReg(s, 1);
		c2 = getCharReg(s, 2);
		c3 = getCharReg(s, 3);

		//Put the character data in the array    	
		byte1[0] = (byte)(0b00001111);						//Slave address of the REV card.
		byte1[1] = (byte)(0b00001111);

		byte1[2] = (byte)charreg[c3][0];
		byte1[3] = (byte)charreg[c3][1];					//Right most character

		byte1[4] = (byte)charreg[c2][0];
		byte1[5] = (byte)charreg[c2][1];

		byte1[6] = (byte) charreg[c1][0];
		byte1[7] = (byte)(charreg[c1][1] | DECIMAL_POINT);	//Turn on the decimal Point  

		byte1[8] = (byte)charreg[c0][0];					//Left most character
		byte1[9] = (byte)charreg[c0][1];

		// send the array to the board
		i2c.writeBulk(byte1);
	} // public void displayVoltage(double v)

} // public class RevDisplay