//By Yun Peng Zou 500628304
import java.text.SimpleDateFormat;
import java.util.*;
public class Transaction {
	private int id;
	private GregorianCalendar date;
	private Car car;
	private String name;
	private String type;
	private int price;
	public Transaction(int id, GregorianCalendar date, Car car,String name, String type, int price) {
		this.id = id;
		this.date = date;
		this.car = car;
		this.name = name;
		this.type = type;
		this.price = price; 
	}
	/**
    A static method get date 
    @return  date
  */
	public GregorianCalendar getDate() {
		return date;
	}
	/**
    A static method get car 
    @return  car
  */
	public Car getCar() {
		return car;
	}
	/**
    A static method get Name 
    @return  name
  */
	public String getName() {
		return name;
	}
	/**
    A static method get Type 
    @return  type
  */
	public String getType() {
		return type;
	}
	/**
    A static method get Price 
    @return  Price
  */
	public int getPrice() {
		return price;
	}
	/**
    A static method displays the transaction
    @return  String representation of transaction
  */
	public String display() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
		sdf.setCalendar(date);
		String sdate =sdf.format(date.getTime());
		return "ID: "+ id+" " + sdate + " " + type + " SalesPerson: "+ name +" Car: " + car.display();
	}
	
}
