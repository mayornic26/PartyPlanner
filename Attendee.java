	
/**
 * Attendee.java
 * 
 * Author: Nico Mayoral
 * Date: 2/23/25
 * 
 * Preconditons: Attendee Class and Objects
 * Postconditions: Generates an attendee object containing First Name, Last Name, Table Number, position, and company ID
 * Purpose:  This object allows to store the information for each attendee to the party.  The program using the Attendee class is able to store multiple attendees
 * in an array structure for each retrieval.
 * 
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
 
/* Attendee Class:  Creates the structure for attendees for the use of storing each attendee and its attributes including first name, last name,
 * table and company that the person works for.   It can be used to be stored in an ArrayList by the program using the class
 */
 

 public class Attendee {
	 
	 // Attributes to store for each attendee
	 private String nameFirst;
	 private String nameLast;
	 private int tableID;
	 private int companyID;
	 private int posID;
 
     // Constructor for the class
     public Attendee(String first, String last, int compID) {
	    nameFirst = first;
	    nameLast = last;
	    tableID = -1;
	    posID = -1;
	    companyID = compID;
     }


     // Getter method to obtain the table ID attribute
     public int gettableID() {
	   return tableID;
	  }
 
     // Setter method to set the table number for an attendee
     public void settable (int tablenumber) {
	    this.tableID = tablenumber;	 
	}
      // Setter method to set the position numner for an attendee
     public void setposition (int position) {
	    this.posID = position;	 
	}
 
     // Getter method for the first name attribute
     public String getfirst() {
	    return nameFirst;	
	 }
	 
	 // Getter method for the last name attribute
     public String getlast() {
	    return nameLast;
     }
	
	 // Getter method for the Company ID attribute
     public int getcompID() {
	    return companyID;
	 }
	 
	 // Getter method for the position ID attribute
     public int getposID() {
	    return posID;
	 }
	
	 // Method to print the attendee in String format
     public String toString() {
	   return (nameFirst + " " + nameLast);
	 }
}
