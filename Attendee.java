
/**
 * Attendee.java
 * 
 * Preconditons: txt file to import attendee objects
 * Postconditions: generates and attendee object with name,tableID, tablePos, and companyID
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
 
 public class Attendee{
	 private String nameFirst;
	 private String nameLast;
	 private int tableID;
	 private int seatID; 
	 private int companyID;
 
 
 public Attendee(String first, String last, int compID){
	 nameFirst = first;
	 nameLast = last;
	 tableID = -1;
	 seatID = -1;
	 companyID = compID;
 }
 
 public int gettableID(){
	 return tableID;
	}
public int getseatID(){
	return seatID;
}
 public String getfirst(){
	return nameFirst;	
	}
public String getlast(){
	return nameLast;
}
	
 public int getcompID(){
	return companyID;
	}
	
	public String toString(){
	
	return (nameFirst + " " + nameLast + "works at " + companyID + "\n");
	}
}
