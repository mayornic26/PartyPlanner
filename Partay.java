
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


 public class Partay{
	 public void loadPeople() {
	//ArrayList<Attendee> companies = new ArrayList<Attendee>();
	ArrayList<Attendee> attList = new ArrayList<Attendee>();
   /*
 try {
      File myObj = new File("companies.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String regex = (",");
        String[] newData1 = newData.split(regex);
        Attendee companies =  new Attendee(data[2]);
        attList.add(att);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    */
     try {
      File myObj = new File("partyguests.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        //String regex = (",");
        String[] newData1 = data.split(",");
        Attendee att2= new Attendee(newData1[2], newData1[1], Integer.parseInt(newData1[3]));
        attList.add(att2);
      }//close while
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } //close catch - 
    
    //print ppl
    System.out.println(attList);
	}
  }
 
