
/**
 * Company.java
 * 
 * Author: Nico Mayoral
 * Date: 2/23/25
 * Preconditons: Company Class and Object
 * Postconditions: generates a company object with companyID,companyName
 *  
 * Purpose: This object allows to store the information for each Compay to the party.  The program using the Company class is able to store multiple companies
 * in an array structure for each retrieval.
 * 
 */

/* Company Comparator Class implementing for a Company:   This class defines a comparison method to be able to sort an ArraList of companies in descending order based
 * on how many attendees are attending for each company.  This is needed for proper function of the table seating algorithm
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.util.*;

 class CompanyComparator implements Comparator<Company> { 
    // override the compare() method 
    //this is available online using w3 schools which makes sure the companies are sorted so when they are sorted it is easier
    public int compare(Company c1, Company c2) 
    { 
		// if the number of attendees is the same, returns 0
        if (c1.count == c2.count) 
            return 0; 
        else if (c1.count < c2.count) 
        // if the first company has fewer attendees than 2nd company return 1
            return 1; 
        else
        // return -1 if first company has more attendees than second company
            return -1; 
    } 
} 

/* Attendee Class:  Creates the structure for attendees for the use of storing each attendee and its attributes including first name, last name,
 * table and company that the person works for.   It can be used to be stored in an ArrayList by the program using the class
 */


 public class Company {
// Attributes to store for each company
     private int companyID;
     private String companyName;
     public int count;
 
 // constructor for the class
     public Company(int compID, String name) {
	    companyID = compID;
	    companyName = name;
     }

// Getter for the company ID attribute 
     public int getcompID() {
	   return companyID;
	  }

// Getter method for the company name
     public String getname() {
	   return companyName;
     }
     
// Setter method to set the number of people for a company
     public void set_count(int total) {
	   this.count = total;	 
     }

// Method to print the company in String format 	
     public String toString() {
	   return (companyID + " " + companyName);
     }
}

