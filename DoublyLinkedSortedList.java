

public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
	
	//instance variables
	private HurricaneRowData data;
	private DoublyLinkedSortedList previous;
	private DoublyLinkedSortedList next;
	
	//default constructor
	public DoublyLinkedSortedList() {
		this.data = null;
		previous = null;
		next = null; 
	}
	
	//constructor with data
	public DoublyLinkedSortedList(HurricaneRowData data) {
		this.data = data;
		previous = null;
		next = null; 
	}		
	
	//Get the value of the current DoublyLinkedSortedList
	public HurricaneRowData getValue() {
		return data;
	}
	
	//Return true if next is not null
	public boolean hasNext() {
		return next != null;
	}
	
	//Set next to be the given DoublyLinkedSortedList
	public void setNext(DoublyLinkedSortedList n) {
		next = n;
	}
	
	//Return a reference to the next DoublyLinkedSortedList
	public DoublyLinkedSortedList getNext() {
		return next;
	}
	
	//Return true if previous is not null
	public boolean hasPrevious() {
		return previous != null;
	}
	
	//Set previous to be the given DoublyLinkedSortedList
	public void setPrevious(DoublyLinkedSortedList p) {
		previous = p;
	}
	
	//Return a reference to the previous DoublyLinkedSortedList
	public DoublyLinkedSortedList getPrevious() {
		return previous;
	}
	
	//Return a reference to the first DoublyLinkedSortedList element in the list
	public DoublyLinkedSortedList getFirst() {
		if(!hasPrevious()) {
			return this;
		}
		return previous.getFirst();
	}
	
	//Return a reference to the last DoublyLinkedSortedList element in the list
	public DoublyLinkedSortedList getLast() {
		if(!hasNext()) {
			return this;
		}
		return next.getLast();
	}
	
	//TODO Remove the DoublyLinkedSortedList element that has toRemove as its value
	public DoublyLinkedSortedList remove(HurricaneRowData toRemove) {
		if(!getValue().equals(toRemove)) { //if not data == toRemove
			//go to next?????
		}
		return this; //placeholder
	}
	
	//TODO Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
	//sort maxAce from max to min
	public void insert(HurricaneRowData newValue) {
		//create new linkedList for current data
		DoublyLinkedSortedList newList = new DoublyLinkedSortedList(newValue);
		
		//insert into correct location based on maxAce value
		
		//once determined where to put
		
	}
	
	//TODO Return the entire list as a multi-line String
	@Override
	public String toString() {
		
		//create String variable
		String listString = String.format("%10s %10s %10s %10s %10s\n", 
			"Year", "Ace Index", "# Tropical Storms", 
			"# Hurricanes Cat. 1-5", "# Major Huricanes Cat. 3-5");
		
		while(hasNext()) {
			
			//add each LinkedList on separate lines
			listString.concat(String.format("%10d %10d %10d %10d %10d\n",
				data.getYear(), data.getAceIndex(), data.getNumStorms(), 
				data.getNumHurr(), data.getNumMajHurr()));
				
			//advance to next and calltoString on next
			if(hasNext()) {
				next.toString();
			}
		}
		
		return listString;
	}
}