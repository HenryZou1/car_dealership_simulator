import java.util.*;
//By Yun Peng Zou 500628304
public class SalesTeam {
	LinkedList <String> team; 
	/**
    constructor
  */
	public SalesTeam() {
		team = new LinkedList<String>(); 
		team.add("John");
		team.add("Paul");
		team.add("George");
		team.add("Ringo");
		team.add("Bruce");
	}
	/**
    A static method picks a person randomly and returns it 
    @return person picked
  */
	public String getPerson() {
		Random rand = new Random();
		int id = rand.nextInt(team.size());
		return team.get(id);
	}
	/**
    A static method displays the entire team
  */
	public void getTeam() {
		ListIterator<String> iterator = team.listIterator();
		
		while (iterator.hasNext())
		    System.out.println(iterator.next()) ;
	    
	}
}
