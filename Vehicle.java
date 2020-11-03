//By Yun Peng Zou 500628304
import java.util.*;
public class Vehicle {
	private String mfr;
	private String color;
	private int power;
	private int numWheels;
	public  int ELECTRIC_MOTOR =0;
	public  int GAS_ENGINE =1;
	private int VIN;
	/**
	   constructor
	  */
	public Vehicle(String man, String col, int  pow, int wheel) {
		mfr= man;
		color = col;
		power = pow;
		wheel = numWheels;
		Random rand = new Random();
		VIN = rand.nextInt(399);
		VIN = VIN + 100;
	}
	/**
    A static method that get VIN
    @return return VIN
  */
	public int getVIN() {
		return VIN;
	}
	/**
    A static method that get manufacturer 
    @return return manufacturer
  */
	public String getManu() {
		return mfr;
	}
	/**
    A static method that set manufacturer 
  */
	public void setManu(String manu) {
		mfr= manu;
	}
	/**
    A static method that get color 
    @return return color
  */
	public String getColor() {
		return color;
	}
	/**
    A static method that set color 
  
  */
	public void setColor(String col) {
		color = col;
	}
	
	/**
    A static method that get color 
    @return return power
  */
	public int getPower() {
		return power;
	}
	/**
    A static method that set power 
  
  */
	public void setPower(int pow) {
		power = pow;
	}
	/**
    A static method that get wheel 
  
  */
	public int getWheel() {
		return numWheels;
	}
	/**
    A static method that set wheel 
  
  */
	public void setWheel(int wheel) {
		numWheels = wheel;
	}
	/**
    A static method that equals wheel 
    @return  the two Vehicle are equal to one another
  */
	public boolean equals(Object other) {
		Vehicle otherv = (Vehicle) other;
		
		if(mfr.equals(otherv.getManu())  && power== otherv.getPower() && numWheels == otherv.getWheel())
			return true;
		return false; 
	}
	/**
    A static method that display the object as string
  */
	public String display() {
		return"VIN "+ VIN +" "+ mfr +" "+ color;
	}
	
}
