package algorithm.comp3203;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.Timer;

public class Sensor {
	
	private int coorX, coorY, rotSpeed, currAngle, beamWidth, numSec, range;
	private String name;
	public int counter;
	public int state;
	public boolean connected;
	
	public Color color = Color.MAGENTA;
	public Map<Integer, Double> inRange = new HashMap<Integer, Double>(100);
	public Map<Integer, Color> connections = new HashMap<Integer, Color>(100);
	
	private int numRot, count, colour;
	private boolean noStopRot;
	Random rand = new Random();
	private boolean checked;
	
	
	public Sensor(String s, Random rand, int rs, int r, int x, int y, int sectorSpawn){
	
		rotSpeed = rs;
		range = r;
		name = s;
		coorX = x;
		coorY = y;
		numSec = rand.nextInt(9) + 3;
		beamWidth = 360/numSec;
		//currAngle = (beamWidth/2) * (rand.nextInt(numSec)); //random start angle of beam (sector)
		currAngle = (beamWidth/2) * sectorSpawn;
		counter = 0;
		
	}
	
	public void rotateBeam(){
		
		if(counter != 2){
			counter += rotSpeed;
		}
		if(counter == 2){
			if((currAngle + beamWidth) > 360){
				currAngle += beamWidth;
				currAngle -= 360;
			}else
				currAngle +=beamWidth;
			counter = 0;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public double getCurrAngle(){
		return currAngle;
	}
	
	public int getBeamWidth(){
		return beamWidth;
	}
	public int getY(){
		return coorY;
	}
	public int getX(){
		return coorX;
	}

	public double getAngleOrig(){
	
		double angle;
		double top = (coorX * coorX);
		double bottom = (int) (coorX * Math.sqrt((coorX*coorX) + (coorY*coorY)));
		double result = top/bottom;
		angle = Math.acos(result) * 180/Math.PI;
		
		return angle;
		
	}
	
	public void rotateBeam2(){
		
		if((currAngle + beamWidth) > 360){
			currAngle += beamWidth;
			currAngle -= 360;
		}else
			currAngle +=beamWidth;
		
	}
	public int getNumSect(){
       
		 return numSec;
		 
	}
	public int getNumRot(){
		return numRot;
	}
	
	public void setCount(int c){
		count = c;
	}
	
	public void setRotSpeed(int val){
		rotSpeed = val;
	}
	
	public boolean checkRotFinish(){
		if (noStopRot && (numRot > numSec*numSec))
			return true;
		else if (!noStopRot && (numRot > numSec))
			return true;
		
		return false;
	}
	
	public boolean checkRotFinish2(){
		if (noStopRot && (numRot > numSec*12))
			return true;
		else if (!noStopRot && (numRot > numSec))
			return true;
		
		return false;
	}
	
	public void setNoStopRot(boolean val){
		noStopRot = val;
	}
	public void coinFlip(){
		noStopRot = rand.nextBoolean();
		
		if (noStopRot)
			rotSpeed = 1;
		else
			rotSpeed = numSec;
	}
	public void coinFlip2(){
		noStopRot = rand.nextBoolean();
		
		if (noStopRot)
			rotSpeed = 1;
		else
			rotSpeed = 12;
	}
	
	//for thread
	public void setCurrAngle(int val){
		currAngle = val;
	}
	public int getRotSpeed(){
		return rotSpeed;
	}
	public void incNumRot(){
		numRot++;
	}
	public int getColour(){
		return colour;
	}
	public void incColour(){
		colour++;
	}
	
	//for log file
	public void setChecked(){
		checked = true;
	}
	public boolean getChecked(){
		return checked;
	}
}