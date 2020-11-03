import java.util.*;
//By Yun Peng Zou 500628304
public class CarDealership {
	private ArrayList <Car> list;
	private SalesTeam team ;
	private AccountingSystem account;
	private boolean awd = false;
	private boolean electric = false;
	private boolean price= false;
	private double minPrice;
	private double maxPrice;
	/**
   constructor
  */
	public CarDealership() {
		list = new ArrayList<Car>();
		team= new SalesTeam();
		account = new AccountingSystem();
	}
	/**
    A static method that adds new cars to the list
  */
	public void addCars(ArrayList <Car> newCars) {
		list.addAll(newCars);
	}
	/**
    A static method that buy car from list which removes it
    @return string representation of transaction 
  */
	public String buyCar(int VIN) throws Exception{
		
		ListIterator<Car> iterator = list.listIterator();
		Car temp;
		int ind = 0;
		if(!iterator.hasNext())
			throw new Exception("List is empty");
		while (iterator.hasNext()) {
			temp = iterator.next();
			if (temp.getVIN() == VIN) {
				break;
			}
			ind++;
			if(!iterator.hasNext())
				throw new Exception("Can't find car id");
		}
		temp = list.remove(ind);
		String person = team.getPerson();
		Random rand = new Random();
		int month = rand.nextInt(11);
		
		GregorianCalendar calendar = new GregorianCalendar(2019,month, rand.nextInt(20)+1);
		
		return account.add(calendar, temp, person, "BUY", temp.getPrice());
	}
	/**
    A static method that returnCar to list using transaction id, if not found return, calendar part is to get new date for transaction that is later than old date buy less than max day of month, add new transaction object
  */
	public void returnCar(int transaction) {
		Random rand = new Random();
		
		Transaction tran = account.getTransaction(transaction);
		if(tran == null) 
			return;
		
		Calendar  oldDate=  tran.getDate();
		int maxDay =oldDate.getActualMaximum(Calendar.DAY_OF_MONTH);
		int difference = maxDay- oldDate.get(Calendar.DAY_OF_MONTH) ;
		int newDay = rand.nextInt(difference)+oldDate.get(Calendar.DAY_OF_MONTH)+1;
		System.out.println(account.add(new GregorianCalendar(2019,oldDate.get(Calendar.MONTH), newDay), tran.getCar(), tran.getName(), "RETURN", tran.getPrice()));
		list.add(tran.getCar());
	}
	/**
    A static method that displays all the inventory depending on what filter is on 
  */
	public void displayInventory() {
		for (int i = 0; i <list.size(); i ++) {
			if(electric == true && !list.get(i).getClass().getName().equals("ElectricCar")) { // if filter turned on then if does not equal electric car then skip
				continue;
			}
			if(awd == true && list.get(i).getAWD() == false) // if filter turned on and car is not awd then skip
				continue;
			if(price == true && (list.get(i).getPrice()>maxPrice || list.get(i).getPrice()<minPrice))//if filter is turned on and price is above or below range than skip
				continue;
			System.out.println(list.get(i).display());
		}
			
	}
	/**
    A static method that displays all sales
  */
	public void displaySales() {
		account.getSales();
	}
	/**
    A static method that displays all Team members
  */
	public void displayTeam() {
		
		team.getTeam();
	}
	
	/**
    A static method that displays top sales person
  */
	public void displayTopSales() {
		account.getTop();
	}
	/**
    A static method that displays transaction for the month
  */
	public void displayMonthly(int month) {
		account.getMonth(month);
	}
	/**
    A static method that displays Stats for year
  */
	public void displayStat() {
		account.displayStat();
	}
	/**
    A static method that  turns on electric filter
  */
	public void filterByElectric() {
		electric = true;
	}
	/**
    A static method that  turns on awd filter
  */
	public void filterByAWD() {
		awd = true;
	}
	/**
    A static method that  turns on sort by price
  */
	public void filterByPrice(double minPrice, double maxPrice) {
		price = true;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	/**
    A static method that  turns off all filters
  */
	public void filterClear() {
		electric = false;
		awd = false;
		price = false;
	}
	/**
    A static method that sortByPrice 
  */
	public void sortByPrice() {
		Collections.sort(list);
	}
	
	class safetyRating implements Comparator <Car> {
		/**
	    A static method that compare safety rating
	  */
		public int compare(Car other, Car here) {// how to compare safety rating
			if (other.getSafetyRating() < here.getSafetyRating()) return -1;
	        if (other.getSafetyRating() > here.getSafetyRating()) return 1;
	        return 0;
			
		}
	}
	/**
    A static method that sortBySafetyRating 
  */
	public void sortBySafetyRating() {
		list.sort(new safetyRating().reversed());
	}
	class maxRange implements Comparator <Car> {
		public int compare(Car other, Car here) {// how to compare max Range
			if (other.getMaxRange() < here.getMaxRange()) return -1;
	        if (other.getMaxRange() > here.getMaxRange()) return 1;
	        return 0;
		}
	}
	/**
    A static method that sortByMaxRange 
  */
	public void sortByMaxRange() {
		list.sort(new maxRange().reversed());
	}
}
