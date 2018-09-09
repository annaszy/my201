//Anna Szymanski
//ID: 7180100173

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Date {
	@SerializedName("Month")
	@Expose
	String Month;
	@SerializedName("Day")
	@Expose
	int Day;
	@SerializedName("Year")
	@Expose
	int Year;
	
	public int MonthAsInt(String month){
		int monthnum;
		if(month.equals("January") || month.equals("january"))
			monthnum = 1;
		else if(month.equals("February") || month.equals("february") )
			monthnum = 2;
		else if(month.equals("March") || month.equals("march"))
			monthnum = 3;
		else if(month.equals("April") || month.equals("april"))
			monthnum = 4;
		else if(month.equals("May") || month.equals("may"))
			monthnum = 5;
		else if(month.equals("June") || month.equals("june"))
			monthnum = 6;
		else if(month.equals("July") || month.equals("july"))
			monthnum = 7;
		else if(month.equals("August") || month.equals("august"))
			monthnum = 8;
		else if(month.equals("September") || month.equals("september"))
			monthnum = 9;
		else if(month.equals("October") || month.equals("october"))
			monthnum = 10;
		else if(month.equals("November") || month.equals("november"))
			monthnum = 11;
		else if(month.equals("December") || month.equals("december"))
			monthnum=12;
		else{
			monthnum = -1;
		}		
		return monthnum;		
	}
	
	public int getDateasInt(){
		return this.Year*10000+ MonthAsInt(this.Month)*100+this.Day;
	}
}
