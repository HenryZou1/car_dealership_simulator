//By Yun Peng Zou 500628304
public class Car extends Vehicle implements Comparable <Car>{
	private int model;
	private int maxRange;
	private double safetyRating;
	private boolean AWD;
	private double price;
	public final int SEDAN = 0;
	public final int SUV = 1;
	public final int SPORTS = 2;
	public final int MINIVAN = 3;
	public static final String[] modelName = {"SEDAN", "SUV", "SPORTS", "MINIVAN"}; // hold all the names of the car model to reference 
	/**
   constructor
  */
	public Car ( int mod, int max , double safe, boolean aw, double pri, String man, String col, int  pow, int wheel) {
		super(man,  col,   pow,  wheel);
		model = mod;
		maxRange = max;
		safetyRating =safe;
		AWD = aw;
		price = pri;
		
	}
	/**
    A static method that gives a string representation of a car
    @return a string representation 
  */
	public String display() {//what to print out
		return super.display()+" " + modelName[model] + " "+ price +"$ SF:" + safetyRating + " RNG:" + maxRange;
	}
	/**
    A static method that gives AWD of a car
    @return AWD
  */
	public boolean getAWD(){
		return AWD;
	}
	/**
    A static method that gives Model of a car
    @return Model
  */
	public int getModel() {
		return model;
	}
	/**
    A static method that gives MaxRange of a car
    @return MaxRange
  */
	public double getMaxRange() {
		return maxRange;
	}
	
	/**
    A static method that gives SafetyRating of a car
    @return SafetyRating
  */
	public double getSafetyRating() {
		return safetyRating;
	}
	/**
    A static method that gives Price of a car
    @return Price
  */
	public double getPrice() {
		return price;
	}
	/**
    A static method that compares if two cars are equal
    @return boolean If they are equal 
  */
	public boolean equals(Object other) {
		Car o = (Car) other;
		if(super.equals((Vehicle)o) && model == o.getModel()&& o.getAWD() == AWD) // if vehicle equals and model equals and awd equals return true
			return true;
		return false;// else return false
	}
	/**
    A static method that compares price to another
    @return difference in price 
  */
	public int compareTo (Car other) {
		return (int)(price - other.getPrice());
	}
}
