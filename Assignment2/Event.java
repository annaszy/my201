//Anna Szymanski
//ID: 7180100173

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {
	@SerializedName("Title")
	@Expose
	String Title;
	@SerializedName("Time")
	@Expose
	String Time;
	@SerializedName("Date")
	@Expose
	Date Date;
	
	Event(String title, String time, int month, int day, int year){
		this.Title = title;
		this.Time = time;
		
		this.Date = new Date();
		this.Date.Month = InttoMonth(month);
		this.Date.Day = day;
		this.Date.Year = year;	
	}
	
	public String InttoMonth(int monthnum){
		if(monthnum == 1)
			return "January";
		else if(monthnum ==2)
			return "February";
		else if(monthnum ==3)
			return "March";
		else if(monthnum ==4)
			return "April";
		else if(monthnum ==5)
			return "May";
		else if(monthnum==6)
			return "June";
		else if(monthnum==7)
			return "July";
		else if(monthnum==8)
			return "August";
		else if(monthnum ==9)
			return "September";
		else if(monthnum==10)
			return "October";
		else if(monthnum ==11)
			return "November";
		else if(monthnum == 12)
			return "December";
		else
			return "Fake Month";
	}
	
	public String PrettyPrintEvent(){
		return Title+", "+Time+", "+Date.Month+" "+Date.Day+", "+Date.Year;
	}
	
	public int getDateasInt(){
		return Date.getDateasInt();
	}
}
