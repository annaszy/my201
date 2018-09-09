//Anna Szymanski
//ID: 7180100173

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User{
	@SerializedName("Name")
	@Expose
	Name Name;
	@SerializedName("Events")
	@Expose
	ArrayList <Event> Events;
	
	User(String fname, String lname){
		this.Name = new Name();
		this.Name.Fname = fname;
		this.Name.Lname = lname;
		this.Events = new ArrayList <Event> ();
	}
	
	public String getFullName() {
		return Name.Lname + ", " +Name.Fname;
	}
	
	public String getSortName() {
		return (Name.Lname+ ", " +Name.Fname).toLowerCase();
	}
	
	public String getLastName() {
		return Name.Lname;
	}

	public ArrayList<Event> getEvents() {
		return Events;
	}
	
	public void setEvents(ArrayList<Event> events) {
		this.Events = events;
	}
}

