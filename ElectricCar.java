//By Yun Peng Zou 500628304
public class ElectricCar  extends Car{
	private int rechargeTime;
	private String batteryType;
	/**
	   constructor
	  */
	public ElectricCar (int time, String bat,int mod, int max , double safe, boolean aw, double pri, String man, String col, int  pow, int wheel) {
		super( mod, max , safe,  aw,  pri,  man,  col,   pow,  wheel);
		rechargeTime = time;
		batteryType = bat;
	}
	/**
    A static method that get Recharge Time
    @return string representation of transaction 
  */
	public int getRechargeTime(){
		return rechargeTime;
	}
	/**
    A static method that gets type of battery type
    @return string representation of transaction 
  */
	public String getBatteryType(){
		return batteryType;
	}
	/**
    A static method that set Recharge Time 
    
  */
	public void setRechargeTime(int t){
		rechargeTime = t;
	}
	/**
    A static method that set BatteryType
    
  */
	public void setBatteryType(String b){
		batteryType= b;
	}
	/**
    A static method that to string method to display
    
  */
	public String display() {
		return super.display() +" EL, Bat:" +batteryType +" RCH: "+ rechargeTime;
	}
	
}
