package Code;
import java.sql.*;
import java.util.*;

public class Database {
	
	public static Connection con;
	public static void connection() {
		String url = "jdbc:mysql://localhost:3306/new_schema";
		String username = "root";
		String pass = "supercheackbear";
		
		try {
			con = DriverManager.getConnection(url, username, pass);
			System.out.println("Connected");
			Statement st = con.createStatement();
			st.executeUpdate("create table activity(activityName varchar(50),date varchar(50),timer varchar(50),notes varchar(280))");
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	public static final String activityName = "activityName";
	public static final String date = "date";
	public static final String timer = "timer";
	public static final String notes = "notes";
	public static final String table = "activity";
		
	/**
	 * method that returns the table from the database
	 * @return output table from database
	 */
	public static String printTable() {
		String output = "";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from activity");
			while(rs.next()) {
				output += (rs.getString(activityName) + " | ");
				output += (rs.getString(date) + " | ");
				output += (rs.getString(timer) + " |\n ");
				output += (rs.getString(notes));
				output += "\n"+"\n";
			}
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
		return output;
	}
	
	/**
	 * method to remove entry if any of parameters are present
	 * @param name
	 * @param activityDate
	 * @param activityTimer
	 * @param activityNotes
	 */
	public static void remove(String name, String activityDate, String activityTimer, String activityNotes) {
		
		//StringBuilder toRemove = new StringBuilder();
		ArrayList<String> conditions = new ArrayList<String>();
		
		//create conditions for removal
		if(!name.equals("")) {
			conditions.add(activityName + "=\"" + name + "\"");
		}
		if(!activityDate.equals("")) {
			conditions.add(date + "=\"" + activityDate + "\"");
		}
		if(!activityTimer.equals("")) {
			conditions.add(timer + "=\"" + activityTimer + "\"");
		}
		if(!activityNotes.equals("")) {
			conditions.add(notes + "=\"" + activityNotes + "\"");
		}
		
		String joinedConditions = String.join(" OR ", conditions);
		
		//check if conditions were empty
		if(joinedConditions.isEmpty()) {
			return;
		}
		String query = "Delete from " + table + " where " + joinedConditions;
		System.out.println("Try to delete: " + query);
		
		try {
			con.createStatement().executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	/**
	 * method to add entries into table
	 * @param name
	 * @param activityDate
	 * @param activityTimer
	 * @param activityNotes
	 */
	public static void add(String name, String activityDate, String activityTimer, String activityNotes) {
		//get conditions
		ArrayList<String> conditions = new ArrayList<String>();
		
		//add input to array list and enter Null if empty
		if(!name.equals("")) {
			conditions.add("\"" + name + "\"");
		}else {
			conditions.add("NULL");
		}
		if(!activityDate.equals("")) {
			conditions.add("\"" + activityDate + "\"");
		}else {
			conditions.add("NULL");
		}
		if(!activityTimer.equals("")) {
			conditions.add("\"" + activityTimer + "\"");
		}else {
			conditions.add("NULL");
		}
		if(!activityNotes.equals("")) {
			conditions.add("\"" + activityNotes + "\"");
		}else {
			conditions.add("NULL");
		}
		
		//make into one string
		String joinedConditions = String.join(",", conditions);
		
		//check if joined conditions is empty
		if(joinedConditions.isEmpty()) {
			return;
		}
		
		//create final query
		String query = "Insert into " + table + "(activityName,date,timer,notes) values (" + joinedConditions + ")";
		System.out.println("Try to add: " + query);
		
		try {
			con.createStatement().executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	
	/**
	 * method to update entries based on then date and timer of activity
	 * @param name
	 * @param activityDate
	 * @param activityTimer
	 * @param activityNotes
	 */
	public static void update(String name, String activityDate, String activityTimer, String activityNotes) {
		//get conditions
		String conditions ="";
		
		//create conditions for updating
		if(name.equals("")) {
			return;
		}

		if(!activityNotes.equals("")) {
			conditions = notes + "=\"" + activityNotes +'"';
		}
		
		//create final query
		String query = "Update " + table + " set " + conditions + " where " + activityName + "=" + "'" + name+"'";
		System.out.println("Try to update: " + query);
		
		try {
			con.createStatement().executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
}
