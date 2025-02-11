
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


 public class Partay{
	 public void loadPeople() {
	ArrayList<Attendee> attList = new ArrayList<Attendee>();
     try {
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
     System.out.println(attList);
	}
	
	public void loadCompanies(){
	ArrayList<String> attCompanies = new ArrayList<String>();
	attCompanies.add("blank");
	try {
      File myObj = new File("companies.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] newData2 = data.split(",");
        attCompanies.add(Integer.parseInt(newData2[1]));
        attCompanies.add(newData2[2]);
        for(int i = attCompanies; i > attCompanies; i++){
		
		} 
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
		}
		 System.out.println(attCompanies);
	}
	for(for int 
	//manually add people
	Scanner inputAttendee = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter a new Attendee if you choose because there are leftover spots: ");
    String userName = inputAttendee.nextLine();  // Read user input
	
	Scanner inputCompanies = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter a new company and a person: ");
    String userName = inputCompanies.nextLine();  // Read user input
    
    
    
  }
 
