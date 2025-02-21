import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

 public class Partay {
	 
	
	
	private ArrayList<Attendee> attList = new ArrayList<Attendee>();
	private ArrayList<Company> CompanyList = new ArrayList<Company>();

		 
	public void loadPeople() {
         try {
			//adds the people to the code from the text file
           File myObj = new File("partyguests.txt");
           Scanner myReader = new Scanner(myObj);
           while (myReader.hasNextLine()) {
               String data = myReader.nextLine();
               String[] newData1 = data.split(",");
               Attendee att2= new Attendee(newData1[2], newData1[1], Integer.parseInt(newData1[3]));
               attList.add(att2);
           }//close while
           myReader.close();
         } catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
         } //close catch -  //print ppl
	}
	
	public void loadCompanies() {

	      try {
			  //adds the companies from the text file into the code
            File myObj = new File("companies.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
               String data = myReader.nextLine();
               if (!data.isEmpty()) { 
                  String[] newData2 = data.split(",");
                  Company comp2 = new Company(Integer.parseInt(newData2[0]), newData2[1]);
                  CompanyList.add(comp2);
               }
            }
            myReader.close();
      // Calculate persons per company     
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
	 
	 public void registerperson () {
		 //registers a person into the list 
		
        boolean register_person = false; 
        
        do {
           
           Scanner inputQuestion = new Scanner(System.in);  // Create a Scanner object
           System.out.println("Would you like to register a person? (Yes/No): ");
           String question = inputQuestion.nextLine();
        
           if (question.equals("Yes")) {
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
			      Attendee new_att= new Attendee(FirstName, LastName, Integer.parseInt(CompanyID));
			      attList.add(new_att); 
		        }
		       else {
			      System.out.println("Max number of partipcnats has been reached");
			      register_person = false;
		       } 
		     }  
	       else {
		      register_person = false;
		    }  
		      
	       }
          while (register_person);

		}
		
	 
	 public void check_user_amounts() {
		// no more than max_per_company
		for(int i = 0; i  < CompanyList.size(); i++){
			int count = 0;
			for(int j = 0; j < attList.size(); j++){
				if(attList.get(j).getcompID() == i){
					count++;
				}
			}
			if(count > max_per_company){
				throw new IllegalArgumentException("Exeeds nunber of companies for table " + i);
			}
		}
		// no more than max_per_table * number_of_tables
		int max_participants = max_per_table * number_of_tables;
		if(attList.size() > max_participants){
			throw new IllegalArgumentException("Total Participants " + attList.size() + " is greater than " + max_participants);
		} 		 
	 }
	 
	 public void place_users_table() {

	// for each table
	// assign person to a table, only if table is not full
	    Comparator myComparator = new place_users_table();
	    Collections.sort(CompanyList, myComparator);
	    for(int i = 1;i <= number_of_tables;i++) //number of tables
	    {
	        int seats_used = 0;
	        for(int j = 0; j < CompanyList.size(); j++) //company size of array 
	        {
			     for(int k = 0; k < attList.size(); k++)//attendance size of array
			      {
				     if (CompanyList.get(j).getcompID() == attList.get(k).getcompID()) {
						  if (attList.get(k).gettableID() == -1) {
						     seats_used++;
						     if (seats_used <= max_per_table) {
						       attList.get(k).settable(i);	
						       k = attList.size();
						     } 
					      }
					 } 
				 }
			}
	     }
	     
     }
     
     //prints the rosters by the table 
	 public void print_rosters_by_table() {
		 for (int i = 1; i <= number_of_tables ; i++) {
			 
			 System.out.println("Table number " + i  + ":");
			 for (int j = 0; j < attList.size(); j++) {
				 if (attList.get(j).gettableID() == i) {
					 for (int k = 0; k < CompanyList.size(); k++) {
					     if (CompanyList.get(k).getcompID() == attList.get(j).getcompID()) {
					       System.out.println(attList.get(j).toString() + " Company: " + CompanyList.get(k).getname());
					     }  
				     }
				 }	 
		    } 	  
	     }		 
	 } 
	 
	 public void print_rosters_by_company() {
		 //prints the rosters by company 
		 for (int i = 0; i < CompanyList.size() ; i++) {
			 System.out.println(CompanyList.get(i).getname() + ":");
			 for (int j = 0; j < attList.size(); j++) {
				 if (attList.get(j).getcompID() == CompanyList.get(i).getcompID()) {
					 System.out.println(attList.get(j).toString());
				 }	 
		    } 	  
	     }			 	 
	 }
	 
	     	 
	 public void getPerson (String lastName, String firstName) {
		 //finds a person and what table they are located at 
		 for(int i = 0; i < attList.size(); i++){
			if(attList.get(i).getfirst().equals(firstName) && attList.get(i).getlast().equals(lastName)){
				System.out.println(firstName + " " + lastName + " is located at table " + attList.get(i).gettableID());
			}
		 }
	 }
  }
 
