package Code;

public class Note {
	
	//variable that will be updated with whatever user chooses to enter
	private String note = " ";
	
	/**
	 * A constructor for the Note class
	 * @param note note that will be used as the base note
	 */
	public Note (String note) {
		this.note = note;
	}
	
	/**
	 * Method that will add onto already existing note if chosen to add during activity
	 * @param note String that will be added onto notes that may already exist
	 */
	public void addNote(String note) {
		this.note += " " +note;
	}
	
	/**
	 * Method that will return the string that contains note for display purposes
	 * @return current note
	 */
	public String getNote() {
		return note;
	}
}
