
/**
 * Partay.java
 * 
 * Author: Nico Mayoral
 * Date: 2/23/25
 * Preconditons: Comma separate text files with companies and attendees. File names: partyguest.txt and companies.txt
 * Postconditions: uses the text files to sort the people/companies into array lists and does the assignment to each table
 * 
 * Purpose: This object contains all various methods for the program that loads the attendees and companies from files, validates that the structure is correct,
 * places the attendees on each table, and additional methods to display rosters, and find attendees.  
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

/* Partay Class:  Loads the text files and stores each attendee as an object and each company as an object into ArrayLists.   Methods available for validations,
 *  table placement, print rosters and find persons.
 */

 public class Partay {
// Attributes to store for the party
	private ArrayList<Attendee> attList = new ArrayList<Attendee>();
	private ArrayList<Company> CompanyList = new ArrayList<Company>();
// variables that can be customized to represent the maximum number of tables, people per table and maximum per company
    private int max_per_table = 10;
    private int number_of_tables = 10;
    private int max_per_company = 10;

// method to read the partyguest.txt file and store in ArrayList
	public void loadPeople() {
         try {
			//adds the people to the code from the text file
           File myObj = new File("partyguests.txt");
           Scanner myReader = new Scanner(myObj);
           while (myReader.hasNextLine()) {
               String data = myReader.nextLine();
               String[] newData1 = data.split(",");
               Attendee att2 = new Attendee(newData1[2], newData1[1], Integer.parseInt(newData1[3])); //gets the information and sets it to the array list
               attList.add(att2);
           }//close while
           myReader.close();
         } catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
         } //close catch -  //print ppl
	}

// method to read the companies.txt file and store in ArrayList
	public void loadCompanies() {

	      try {
			  //adds the companies from the text file into the code
            File myObj = new File("companies.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
               String data = myReader.nextLine();
               if (!data.isEmpty()) { 
                  String[] newData2 = data.split(",");
                  Company comp2 = new Company(Integer.parseInt(newData2[0]), newData2[1]); //grambs the information needed from the text file
                  CompanyList.add(comp2);
               }
            }
            myReader.close();
      // Calculate persons per company, this is needed for program to be able to sort by attendees size and place on each table   
            for (int i = 0; i < CompanyList.size() ; i++) {
		       int count = 0;
		       for (int j = 0 ; j < attList.size(); j++) {
			       if (attList.get(j).getcompID() == CompanyList.get(i).getcompID()) {
				     count++;
			       }
		        }
		       CompanyList.get(i).set_count(count);
	         }      
         } catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
		 }
	  }


// method to register a person manually
	 public void registerperson () {
		 //registers a person into the list 
		
        boolean register_person = false; 
        
        do {
           
           Scanner inputQuestion = new Scanner(System.in);  // Create a Scanner object
           System.out.println("Would you like to register a person? (yes/no): ");
           String question = inputQuestion.nextLine();
        
           if (question.equals("yes")) {
		register_person = true;
        
	           Scanner inputFirstName = new Scanner(System.in);  // Create a Scanner object
               System.out.println("Enter a new Attendee First Name: ");
               String FirstName = inputFirstName.nextLine();  // Read user input

               Scanner inputLastName = new Scanner(System.in);  // Create a Scanner object
               System.out.println("Enter a new Attendee Last Name: ");
               String LastName = inputLastName.nextLine();  // Read user input
        
	           Scanner inputCompanyID = new Scanner(System.in);  // Create a Scanner object
               System.out.println("Enter a new company ID: ");
               String CompanyID = inputCompanyID.nextLine();  // Read user input 
	 
               int max_participants = max_per_table * number_of_tables;
      
		       if(attList.size() < max_participants){
			      Attendee new_att = new Attendee(FirstName, LastName, Integer.parseInt(CompanyID)); //sets a new attendee with their company to add to a list
			      attList.add(new_att); 
		        }
		       else {
			      System.out.println("Max number of participants has been reached");
			      register_person = false;
		       } 
		     }  
	       else {
		      register_person = false;
		    }  
		      
	       }
          while (register_person);

		}
		
// method to validate that inputs does not contain above maximum peop[le per company and no more than total participants
	 public void check_user_amounts() {
		// no more than max_per_company
		for(int i = 0; i  < CompanyList.size(); i++){
			int count = 0;
			for(int j = 0; j < attList.size(); j++){ //check there are no more than max_per_company people attending from any company
				if(attList.get(j).getcompID() == i){
					count++;
				}
			}
			if(count > max_per_company){
				throw new IllegalArgumentException("Exeeds nunber of people for company: " + i);
			}
		}
		// no more than max_per_table * number_of_tables
		int max_participants = max_per_table * number_of_tables; //check there are no more than max_per_table * number_of_tables people in attendance
		if(attList.size() > max_participants){
			throw new IllegalArgumentException("Total Participants " + attList.size() + " is greater than " + max_participants);
		} 		 
	 }

// method to place attendees at each table,  This method uses a logic to fill each table with people from different companies
	 public void place_users_table() {

	// Sort the ArrayList of companies in descending order for nunmber of attendees per company
	    Collections.sort(CompanyList, new CompanyComparator());
	    
	// Iterate for each table
	    for(int i = 1; i <= number_of_tables; i++) //number of tables
	    {
	        int seats_used = 0;
	        // Iterate for each company
	        for(int j = 0; j < CompanyList.size(); j++) //company size of array 
	        {
				// Iterate for each attendee
			     for(int k = 0; k < attList.size(); k++)//attendance size of array
			      {
					 // If the participant is for the company
				     if (CompanyList.get(j).getcompID() == attList.get(k).getcompID()) {
						  if (attList.get(k).gettableID() == -1) {
							  // If the participant is not yet seated
						     seats_used++;
						     if (seats_used <= max_per_table) {
								 // Seat the participant
						       attList.get(k).settable(i);	
						       attList.get(k).setposition(seats_used);
						       k = attList.size();
						     } 
					      }
					 } 
				 }
			}
	     }
	     
     }
 
 //method to print the roster by the table 
	 public void print_rosters_by_table() {
		 for (int i = 1; i <= number_of_tables; i++) {
			 
			 System.out.println("Table number " + i  + ":"); //gives the table number
			 for (int j = 0; j < attList.size(); j++) {
				 if (attList.get(j).gettableID() == i) {
					 for (int k = 0; k < CompanyList.size(); k++) {
					     if (CompanyList.get(k).getcompID() == attList.get(j).getcompID()) {
					       System.out.println(attList.get(j).toString() + " - Seat Number: " + attList.get(j).getposID() + " - Company: " + CompanyList.get(k).getname()); //puts the person and then the company for the table
					     }  
				     }
				 }	 
		    } 	  
	     }		 
	 } 

// method to print roster by company
	 public void print_rosters_by_company() {
		 //prints the rosters by company 
		 for (int i = 0; i < CompanyList.size() ; i++) {
			 System.out.println(CompanyList.get(i).getname() + ":"); //prints the company to the person
			 for (int j = 0; j < attList.size(); j++) {
				 if (attList.get(j).getcompID() == CompanyList.get(i).getcompID()) {
					 System.out.println(attList.get(j).toString() + " - Table Number: " + attList.get(j).gettableID() + " - Seat Number: " + attList.get(j).getposID()); //prints people in the company 
				 }	 
		    } 	  
	     }			 	 
	 }
	 
//method to find a person by name
	 public void getPerson (String lastName, String firstName) {
		 //finds a person and what table they are located at 
		 boolean found = false;
		 for(int i = 0; i < attList.size(); i++){
			if(attList.get(i).getfirst().equals(firstName) && attList.get(i).getlast().equals(lastName)){ 
				found = true;
				System.out.println(firstName + " " + lastName + " is located at table " + attList.get(i).gettableID() + " Seat Number " + attList.get(i).getposID());
			}
		 }
		 if (!found) {
			System.out.println("Person is not found"); 
	     } 
	 }

  
 //method to find a person
  	 public void findperson () {
	
		
        boolean find_person = false; 
        
        do {
           
           Scanner inputQuestion = new Scanner(System.in);  // Create a Scanner object
           System.out.println("Would you like to find a person? (yes/no): ");
           String question = inputQuestion.nextLine();
        
           if (question.equals("yes")) {
		       find_person = true;
        
	           Scanner inputFirstName = new Scanner(System.in);  // Create a Scanner object
               System.out.println("Enter Attendee First Name: ");
               String FirstName = inputFirstName.nextLine();  // Read user input

               Scanner inputLastName = new Scanner(System.in);  // Create a Scanner object
               System.out.println("Enter Attendee Last Name: ");
               String LastName = inputLastName.nextLine();  // Read user input
        
               this.getPerson(LastName,FirstName);
        
		     }  
	       else {
		      find_person = false;
		    }  
		      
	       }
          while (find_person);

		}
  
}
