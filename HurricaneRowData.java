/*
Jade Walters
CSCI 2251
Assignment: Hurricane Data/Linked List
Purpose: Practive working with classes and objects
Sources: I referenced some of my coding projects from 
CS 1152 for array lists and classes
*/

public class HurricaneRowData {
	
	//create instance variables
	private int year;  //Year
	private int aceIndex;  //Ace Index
	private int numStorms;  //# tropical storms
	private int numHurr;  //# hurricanes, cat. 1-5
	private int numMajHurr;  //# hurricanes, cat. 3-5
	
	//hurricane row data constructor
	public HurricaneRowData
		(int year, int aceIndex, int numStorms, int numHurr, int numMajHurr) {
		this.year = year;
		this.aceIndex = aceIndex;
		this.numStorms = numStorms;
		this.numHurr = numHurr;
		this.numMajHurr = numMajHurr;
	}
	
	//toString method
	@Override
	public String toString() {
		return String.format
			("%15d %15d %15d %15d %15d", this.getYear(), this.getAceIndex(), this.getNumStorms(), this.getNumHurr(), this.getNumMajHurr());
	}
	
	//setter for year
	public void setYear(int year) {
		this.year = year;
	}
	
	//getter for year
	public int getYear() {
		return this.year;
	}
	
	//setter for aceIndex
	public void setAceIndex(int aceIndex) {
		this.aceIndex = aceIndex;
	}
	
	//getter for aceIndex
	public int getAceIndex() {
		return this.aceIndex;
	}
	
	//setter for numStorms
	public void setNumStorms(int numStorms) {
		this.numStorms = numStorms;
	}
	
	//getter for numStorms
	public int getNumStorms() {
		return this.numStorms;
	}
	
	//setter for numHurr
	public void setNumHurr(int numHurr) {
		this.numHurr = numHurr;
	}
	
	//getter for numHurr
	public int getNumHurr() {
		return this.numHurr;
	}
	
	//setter for numMajHurr
	public void setNumMajHurr(int numMajHurr) {
		this.numMajHurr = numMajHurr;
	}
	
	//getter for numMajHurr
	public int getNumMajHurr() {
		return this.numMajHurr;
	}
}