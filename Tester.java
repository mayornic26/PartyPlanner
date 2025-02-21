
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

	public class Tester {
		public static void main(String[] args){
		
		
		Partay p1 = new Partay();
		try {
		   p1.loadPeople();//called method for p1 object, which is an instance of partay
		   p1.check_user_amounts();	
		   p1.registerperson();
	       p1.loadCompanies();
	       p1.place_users_table();
	       System.out.println("Roster by Company:");
           p1.print_rosters_by_company();
		   System.out.println("Roster by Table:");
		   p1.print_rosters_by_table();
	    } catch (IllegalArgumentException e) {
           System.out.println(e.getMessage());
		}
	    
	}
 }
