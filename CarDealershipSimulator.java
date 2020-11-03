import java.io.*;
import java.util.*;


//By Yun Peng Zou 500628304


public class CarDealershipSimulator 
{
  public static void main(String[] args)
  {
	  // Create a CarDealership object
	  ArrayList <Car> list = new ArrayList<Car>();	  
	  // Then create an (initially empty) array list of type Car
      // Then create some new car objects of different types
	  // See the cars file for car object details
	  // Add the car objects to the array list
      // The ADD command should hand this array list to CarDealership object via the addCars() method
	  Scanner in = null;
	    try {
	      in = new Scanner(new File("cars.txt"));
	    } catch (FileNotFoundException exception) {
	      System.err.println("failed to open dates.txt");
	      System.exit(1);
	    }
	    String name;
	    String color;
	    String model;
	    double rating;
	    int maxRange;
	    boolean awd;
	    int price;
	    int recharge;
	    StringTokenizer st;
	    while (in.hasNextLine()) {
	      String line = in.nextLine();

	       st = new StringTokenizer(line);
	     
	      if(st.countTokens()==8) {
	    	  name = st.nextToken();
	    	  color = st.nextToken();
	    	  model = st.nextToken();
	    	  st.nextToken();
	    	  rating = Double.parseDouble(st.nextToken());
	    	  maxRange = Integer.parseInt(st.nextToken());
	    	  awd = st.nextToken().equals("AWD");
	    	  price = Integer.parseInt(st.nextToken());
	    	 
	    	  list.add(new Car(Arrays.asList(Car.modelName).indexOf(model), maxRange,rating,awd, price, name, color, 0,4));
	      }
	      if(st.countTokens()==9) {
	    	  name = st.nextToken();
	    	  color = st.nextToken();
	    	  model = st.nextToken();
	    	  st.nextToken();
	    	  rating = Double.parseDouble(st.nextToken());
	    	  maxRange = Integer.parseInt(st.nextToken());
	    	  awd = st.nextToken().equals("AWD");
	    	  price = Integer.parseInt(st.nextToken());
	    	  recharge = Integer.parseInt(st.nextToken());
	    	  list.add(new ElectricCar(recharge,"LITHIUM", Arrays.asList(Car.modelName).indexOf(model), maxRange,rating,awd, price, name, color, 0,4));
	      }  
	  
	    
	    }
	  
	
	  CarDealership dealer = new CarDealership();
	  
	
	  String input, command;
	  int ind, min, max;
	  Scanner scan = new Scanner(System.in); 
	  while(scan.hasNextLine() ) {
		  input = scan.nextLine();
		   st = new StringTokenizer(input);
		   command = st.nextToken();
		  
		  if (input.equals("L"))
			  dealer.displayInventory();
		  else if(input.equals("Q"))
			  return;
		 
		  else if (input.equals("ADD"))
			  dealer.addCars(list);
		  else if (input.equals("SPR"))
			  dealer.sortByPrice();
		  else if (input.equals("SSR"))
			  dealer.sortBySafetyRating();
		  else if (input.equals("SMR")) {
			  dealer.sortByMaxRange();
		  }
		  else if (input.equals("FPR")) {
			  min =scan.nextInt();
			  max = scan.nextInt();
			  dealer.filterByPrice(min, max);
		  }
		  else if (input.equals("FEL"))
			  dealer.filterByElectric();
		  else if (input.equals("FAW"))
			  dealer.filterByAWD();
		  else if (input.equals("FCL"))
			  dealer.filterClear();
		  else if (input.equals("SALES"))
			  dealer.displaySales();
		  else if (input.equals("SALES TEAM"))
			  dealer.displayTeam();
		  else if (input.equals("SALES TOPSP"))
			  dealer.displayTopSales();
		  else if (input.equals("SALES STATS"))
			  dealer.displayStat();
		  else if (st.countTokens() == 1 && command.equals("BUY")) {
			 
			  ind = Integer.parseInt(st.nextToken());
			  try {
		  	  System.out.println(dealer.buyCar(ind));
			  }
			  catch(Exception e) {
				  System.out.println(e.getMessage());
			  }
		  }
		  else if (st.countTokens() == 1 && command.equals("SALES")) {
			  ind = Integer.parseInt(st.nextToken());
		  	  dealer.displayMonthly(ind);
		  }
		  else if (st.countTokens() == 1 && command.equals("RET") ){
			
			  ind = Integer.parseInt(st.nextToken());
		  	  dealer.returnCar(ind);
		  	 
		  }
		  else {
			  
		  }
	
			  
	  }
	  scan.close();

	
  }
}