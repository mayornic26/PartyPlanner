

 public class Partay{
	ArrayList<attendeeObjects> att = new ArrayList<attendeeObjects>();
	ArrayList<companyObejcts> companies = new ArrayList<companyObjects>();
    try {
      File myObj = new File("companies.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String regex = (",");
        String[] newData1 = newData.split(regex);
        Attendee companies= new Attendee(data[2], data[1] Integer.parseInt(data[3]);
        attList.addd(att);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
       try {
      File myObj = new File("partyguests.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String regex = (",");
        String[] newData1 = newData.split(regex);
        Attendee att= new Attendee(data[2]);
        attList.addd(att);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
 }
 
