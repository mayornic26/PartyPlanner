
/**
 * Company.java
 * 
 * Preconditons: txt file to import copany objects
 * Postconditions: generates and company object with companyID,companyName
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
//
 
 public class Company {
	 private int companyID;
     private String companyName;
     public int count;
 
     public Company(int compID, String name) {
	    companyID = compID;
	    companyName = name;
     }

     public int getcompID() {
	   return companyID;
	  }

     public String getname() {
	   return companyName;
     }
     
     public void set_count(int total) {
	   this.count = total;	 
	 }
 	
	 public String toString() {
	   return (companyID + " " + companyName);
	 }
}

