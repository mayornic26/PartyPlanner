
/**
 * Attendee.java
 * 
 * Preconditons: txt file to import attendee objects
 * Postconditions: generates and attendee object with name,tableID, tablePos, and companyID
 */
 public class Attendee{
	 private String name;
	 private int tableID;
	 private int seatID;
	 prviate int companyID;
 
 
 public Attendee(String attName, String compName, int CompID){
	 name = attName;
	 tableID = -1;
	 seatID = -1;
	 CompanyID = compID;
 }
 
 public int getTableID(){
	 return tableID;
	}
 public String getattName(){
	return attName;	
	}
 public int getCompanyID(){
	return CompanyID;
	}

}
