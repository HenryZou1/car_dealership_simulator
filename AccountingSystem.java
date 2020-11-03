//By Yun Peng Zou 500628304
import java.time.Month;
import java.util.*;
public class AccountingSystem {
	Map<Integer, Transaction> system;
	private static int id = 0;
	public AccountingSystem() {
		system = new TreeMap<Integer, Transaction>();
	}
	/**
    A static method that adds to the map of transaction, use the static id as key and increase instead of random so it will have no collesions 
    @return  the new transaction in display format
  */
	public String add(Calendar date, Car car, String salesPerson, String type, double salePrice) {
		Transaction rec = new Transaction(id,(GregorianCalendar) date, car,salesPerson,type, (int) salePrice);
		system.put(id, rec);
		id++;
		return rec.display();
	}
	/**
    A static method gets transaction based on id 
    @return  Transaction object or null if not found
  */
	public Transaction getTransaction(int id) {
		if (!system.containsKey(id))
			return null;
		return system.get(id);
	}
	
	/**
    A static method gets all Transaction object and prints it
  */
	
	public void getSales() {
		Set<Integer> keySet = system.keySet();
		for (Integer key : keySet) 
		    System.out.println(system.get(key).display());
	}
	/**
    A static method displays all the transaction that have the same month as int
  */
	public void getMonth(int month) {
		Set<Integer> keySet = system.keySet();
		int temp;
		for (Integer key : keySet) {
		    temp = system.get(key).getDate().get(Calendar.MONTH);
		    if(temp == month)
		    	 System.out.println(system.get(key).display());
		}
	}
	/**
    A static method iterators though map, and if month equals parameter month then increases it, counts how many sales in a month
  */
	public int getSaleMonth(int month) {
		Set<Integer> keySet = system.keySet();
		Transaction temp;
		int count = 0;
		for (Integer key : keySet) {
		    temp = system.get(key);
		    if(temp.getDate().get(Calendar.MONTH) == month&& temp.getType().equals("BUY"))
		    	 count++;
		}
		return count;
	}
	/**
    A static method displays the stats, first find total sales, total returns, then find which month has highest sales
  */
	public void displayStat() {
		Set<Integer> keySet = system.keySet();
		double total = 0;
		int sold = 0;
		int month= -1, carMonth = -1, count;
		
		int ret=0;
		Transaction temp;
		for (Integer key : keySet) {
		    temp=system.get(key);
		    if(temp.getType().equals("BUY")) {
		    	total+= temp.getPrice();
		    	sold++;
		    }
		    else {
		    	total-= temp.getPrice();
		    	ret ++;
		    }
		}
		for(int i = 0; i <12; i ++) {
			count = this.getSaleMonth(i);
			
			
			if(carMonth<count) {
				carMonth = count;
				month = i;
			}
		}
		Month mon = Month.of(month+1);
		System.out.println("Total Sales: " + total + " Total Sold: "+ sold + " Avg Sales: " + (int)(total/12)+ " Total Returned: " + ret + " Best Month: " + mon+": cars sold - "+ carMonth);
			
	}
	/**
    A static method displays person who has the most sales, goes though entire system and has 5 counters for each person counting
  */
	public void getTop() {
		Set<Integer> keySet = system.keySet();
		int couJ =0,couP =0, couG = 0, couR = 0, couB = 0, max =0;
		for (Integer key : keySet) {
		   if(system.get(key).getName().equals("John"))
			   couJ++;
		   else if(system.get(key).getName().equals("Paul"))
			   couP++;
		   else if(system.get(key).getName().equals("George"))
			   couG++;
		   else if(system.get(key).getName().equals("Ringo"))
			   couR++;
		   else if(system.get(key).getName().equals("Bruce"))
			   couB++;
		}
		max = Math.max(couJ,Math.max(couP, Math.max(couG, Math.max(couR,couB))));
		String message = "TOP SP:";
		if(couJ == max)
			message += " John " + max;
		 if(couP == max)
			message += " Paul " + max;
		 if(couG == max)
			message += " George " + max;
		 if(couR == max)
			message += " Ringo " + max;
		 if(couB == max)
			message += " Bruce " + max;
		System.out.println(message);
	}
	
	
}
