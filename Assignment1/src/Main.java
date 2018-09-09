//Anna Szymanski
//ID: 7180100173

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class Main {

	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		Container container = null;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		boolean edited = false;
		String inputFilename;
		
		while(true) {
			System.out.print("What is the name of the input file? ");
			inputFilename = scan.nextLine();
			System.out.println();
			try {
				container = gson.fromJson(new BufferedReader(new FileReader(inputFilename)), Container.class);
				break;
			} catch (FileNotFoundException e) {
				System.out.println("Error: the file is not found. ");
				System.out.println();
			} catch (JsonSyntaxException e) {
				System.out.println("Error: incorrect JSON. ");
				System.out.println();
			} catch (JsonIOException e) {
				System.out.println("Error: incorrect JSON. ");
				System.out.println();
			} catch (NullPointerException npe){
				System.out.println(npe.getMessage());
				System.out.println();
			}
		}	
		try {
			while(true){
				
				System.out.println("1) Display User’s Calendar");
				System.out.println("2) Add User");
				System.out.println("3) Remove User");
				System.out.println("4) Add Event");
				System.out.println("5) Delete Event");
				System.out.println("6) Sort Users");
				System.out.println("7) Write File");
				System.out.println("8) Exit");
				System.out.println(); 
				System.out.print("What would you like to do? ");
				
				String optionscan = scan.nextLine();
				System.out.println();
				
				if(optionscan.equals("1")){
					DisplayUsersCalendar(container,scan);
				}
				else if(optionscan.equals("2")){
					edited = AddUser(container,scan,edited);
				}
				else if(optionscan.equals("3")){
					edited = RemoveUser(container,scan,edited);
				}
				else if(optionscan.equals("4")){
					edited = AddEvent(container,scan,edited);
				}
				else if(optionscan.equals("5")){
					edited = RemoveEvent(container,scan,edited);
				}
				else if(optionscan.equals("6")){
					edited = SortUsers(container,scan,edited);
				}
				else if(optionscan.equals("7")){
					edited = WriteFile(container, inputFilename,gson,edited);
				}
				else if(optionscan.equals("8")){
					edited = Exit(scan,container,gson,edited, inputFilename);
					break;
				}
				else{
					System.out.println("That is not a valid option.");
					System.out.println();
				}
			}
		}catch (JsonSyntaxException jpe){
			System.out.println("That file is not a well-formed JSON file.");			
		}catch (NullPointerException npe){
			System.out.println(npe.getMessage());
		}
		
		scan.close();
	}
	
	public static boolean RemoveUser(Container container, Scanner scan, boolean edited){
		
		for(int i=0; i<container.Users.size(); i++){
			System.out.println(Integer.toString(i+1) + ") " + container.Users.get(i).getFullName());
		}
		System.out.println();
		
		int numuser = getIntFromUser("Which user would you like to delete? ", 1, container.Users.size(), scan);
		
		container.Users.remove(container.Users.get(numuser-1));
		edited = true;
		
		return edited;
	}
	
	private static int getIntFromUser(String message, int minInt, int maxInt, Scanner scan) {
		int userinput;
		
		while(true){
			try {
				System.out.print(message);
				userinput = scan.nextInt();
				scan.nextLine();
			}catch (Exception e) {
				System.out.println();
				scan.nextLine();
				System.out.println("Invalid input.");
				System.out.println();
				continue;
			}
			System.out.println();
			
			if(minInt > userinput || userinput > maxInt || (userinput != (int)userinput) ){
				System.out.println("Invalid input.");
				System.out.println();
			} 
			else{
				break;
			}
		}		
		return userinput;
	}

	public static boolean RemoveEvent(Container container, Scanner scan, boolean edited){
		
		for(int i=0; i<container.Users.size(); i++){
			System.out.println(Integer.toString(i+1) + ") " + container.Users.get(i).getFullName());
		}
		System.out.println();
		
		int numuser = getIntFromUser("From which user would you like to delete an event? ",1,container.Users.size(),scan);
		
		if(container.Users.get(numuser-1).Events.size() == 0 ){
			System.out.println("Calendar is empty.");
		}
		else{
			int numevent;

			for(int j=0; j<container.Users.get(numuser-1).Events.size(); j++){
				System.out.println("\t"+(j+1) +") " + container.Users.get(numuser-1).Events.get(j).PrettyPrintEvent());
			}	
			System.out.println();
			
			numevent = getIntFromUser("Which event would you like to delete? ", 1,container.Users.get(numuser-1).Events.size(), scan);
	
			String titleoftoberemoved = container.Users.get(numuser-1).Events.get(numevent-1).Title;
			
			container.Users.get(numuser-1).Events.remove(container.Users.get(numuser-1).Events.get(numevent-1));
			
			//print which event has been deleted
			System.out.println(titleoftoberemoved + " has been deleted.");
			System.out.println();
			
			edited = true;
		}
		return edited;
	}
	
	public static void DisplayUsersCalendar(Container container, Scanner scan){

		for(int i=0; i<container.Users.size(); i++){
			System.out.println(Integer.toString(i+1) + ") " + container.Users.get(i).getFullName());
			Collections.sort(container.Users.get(i).Events, Comparator.comparing(Event::getDateasInt));
			for(int j=0; j<container.Users.get(i).Events.size(); j++){
				System.out.println("\t"+((char)(j+97))+". " + container.Users.get(i).Events.get(j).PrettyPrintEvent());
			}
		}
		System.out.println();
	}
	
	public static boolean AddUser(Container container, Scanner scan, boolean edited){
		

		while(true){
			
			System.out.print("What is the user's name? ");
			String newusername = scan.nextLine();
			System.out.println();
			String[] namearray = newusername.split("\\s+");
			
			//if they only put in one name
			if(namearray.length < 2){
				System.out.println();
				System.out.println("Invalid, must have first and last name.");
				System.out.println();
				continue;
			}
			String firstname = namearray[0];
			String lastname = "";
			for(int i=1;i<namearray.length;i++){
				lastname = lastname+ " " +namearray[i];
			}
			lastname= lastname.trim();
			boolean alreadyin= false;
			
			//see if user is already in there
			for(int i=0; i<container.Users.size(); i++){
				if(container.Users.get(i).getFullName().toLowerCase().equals((lastname+", "+firstname).toLowerCase())){
					//if its already in there
					System.out.println("User is already in there.");
					System.out.println();
					alreadyin = true;
					break;
				}
			}
			if(alreadyin == false){
				//if they're not already in the system
				User newuser = new User(firstname,lastname);
				container.Users.add(newuser);
				edited = true;
				break;
			}	
		}
		return edited;
	}
	
	public static boolean AddEvent(Container container, Scanner scan, boolean edited){
		
		//print the users
		for(int i=0; i<container.Users.size(); i++){
			System.out.println(Integer.toString(i+1) + ") " + container.Users.get(i).getFullName());
		}
		System.out.println();
		System.out.println("To which user would you like to add an event? ");
		int usernum = scan.nextInt();
		System.out.println();
		scan.nextLine();
		System.out.print("What is the title of the event? ");
		String eventname = scan.nextLine();
		System.out.println();
		System.out.print("What time is the event? ");
		String eventtime = scan.nextLine();
		System.out.println();
		
		int eventmonth = getIntFromUser("What month? ",1,12,scan);
		int eventday = getIntFromUser("What day? ",1,31,scan);
		int eventyear = getIntFromUser("What year? ",0,9999,scan);		
		
		Event newevent = new Event(eventname,eventtime,eventmonth,eventday,eventyear);
		container.Users.get(usernum-1).Events.add(newevent);
		System.out.println("Added: "+ newevent.PrettyPrintEvent()+ " to "+container.Users.get(usernum-1).Name.getFname()+
				" "+container.Users.get(usernum-1).Name.getLname()+"'s calendar.");
		System.out.println();
		edited = true;
		
		return edited;
	}
	

	public static boolean SortUsers(Container container, Scanner scan, boolean edited){
		
		System.out.println("1) Ascending (A-Z)");
		System.out.println("2) Descending (Z-A)");
		System.out.println();
		System.out.print("How would you like to sort? ");
		int sortdirection = getIntFromUser("How would you like to sort? ",1,2,scan);

		//this line should be ok with Java8
		Collections.sort(container.Users, Comparator.comparing(User::getSortName));
	
		if (sortdirection==1){
			//ascending order
			for(int i=0; i<container.Users.size(); i++){
				System.out.println(Integer.toString(i+1) + ") " + container.Users.get(i).getFullName());
			}
			edited = true;
		}
		else if(sortdirection==2){
			//descending order
			Collections.reverse(container.Users);
			
			for(int i=0; i<container.Users.size(); i++){
				System.out.println(Integer.toString(i+1) + ") " + container.Users.get(i).getFullName());
			}
			edited = true;
		}
		return edited;
	}
	
	public static boolean WriteFile(Container container, String inputFilename, Gson gson, boolean edited){

		
		for(int i=0; i<container.Users.size(); i++){
			Collections.sort(container.Users.get(i).Events, Comparator.comparing(Event::getDateasInt));
		}
		
		//write the file out to the same one that the user put in
		try {
			FileWriter fw;
	
			fw = new FileWriter(inputFilename);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(gson.toJson(container));
			
			edited = false;
			
			pw.flush(); 
			pw.close();
			fw.close();
			} catch (IOException e) {
				System.out.println("Error saving the file. ");
			} catch (JsonIOException e) {
				System.out.println("Error saving the file. ");
			}	
		
		System.out.println("File has been saved.");
		return edited;
	}
	
	public static boolean Exit(Scanner scan, Container container, Gson gson, boolean edited, String inputFilename){
		
		if(edited == false){
		}
		else if(edited == true){
			System.out.println("Changes have been made since the file was last saved.");
			
			System.out.print("Would you like to save the file before exiting?");
			System.out.println("   1) Yes");
			System.out.println("   2) No");
			
			int response = scan.nextInt();
			if(response ==1){
				System.out.println("File was saved.");
				edited = WriteFile(container,inputFilename,gson,edited);
				System.out.println();
			}
			else if (response ==2){
				System.out.println("File was not saved.");
				System.out.println();	
			}
			scan.nextLine();
		}
		System.out.println("Thank you for using my program!");
		
		edited = false;
		
		return edited;
	}	
}