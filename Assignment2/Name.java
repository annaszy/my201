//Anna Szymanski
//ID: 7180100173

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name {
	@SerializedName("Fname")
	@Expose
	String Fname;
	@SerializedName("Lname")
	@Expose
	String Lname;
	
	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		this.Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		this.Lname = lname;
	}

}
