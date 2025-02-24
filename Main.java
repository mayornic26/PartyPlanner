
/**
 * Main.java
 * 
 * Author: Nico Mayoral
 * Date: 2/23/25
 * Preconditons: Main  Class and Object
 * Postconditions: uses Partay.java and calls the methods available
 * 
 * Purpose: This object is used as a tester for the partay class able to execute all needed methods
 * 
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/** Main Class: Loads people, companies, validates quantities, registers additional persons, place users and print rosters
*/

	public class Main {
		public static void main(String[] args){
		
// Creates a new Partay object
		Partay p1 = new Partay();
		try {
			//all the methods which are called from Partay.java
		   p1.loadPeople();//called method for p1 object, which is an instance of partay
		   p1.check_user_amounts();	 //called method to check that there are are the right amount of people and companies in the files
		   p1.registerperson();  //called method to register a new person manually
	           p1.loadCompanies(); //called method to load companies from files
	           p1.place_users_table(); // called method to place attendees on tables
	           System.out.println("Roster by Company:");
                   p1.print_rosters_by_company(); // called method to print rosters per company
		   System.out.println("Roster by Table:");
		   p1.print_rosters_by_table(); // called method to print rosters by table
                   p1.findperson();
		   
	       } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
		}
	}
 }
