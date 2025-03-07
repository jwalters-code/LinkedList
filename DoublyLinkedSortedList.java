

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
	
	//Remove the DoublyLinkedSortedList element that has toRemove as its value
	public DoublyLinkedSortedList remove(HurricaneRowData toRemove) {
		
		//create toRemove variable
		DoublyLinkedSortedList toReturn = null;
		
		//Call the next linked list until it finds the data
		while(!getValue().equals(toRemove)) { //while data != toRemove
			next.remove(toRemove); //check next linkedlist
		} 
		
		//if it finds the data, redirect next and previous pointers
		if(getValue().equals(toRemove)) {
			if(hasPrevious() && hasNext()) { //middle linkedlist
				toReturn = this;
				next.setPrevious(previous);  //set next's previous to current previous
				previous.setNext(next);  //set previous' next to current next
			}
			
			else if(!hasPrevious() && hasNext()) { //first linkedlist
				toReturn = this;
				next.setPrevious(null);  //set next's previous to null
			}
			
			else if(hasPrevious() && !hasNext()) {  //last linkedlist
				toReturn = this;
				previous.setNext(null);  //set previous's next to null
			}
			
			else { //only link on list
				toReturn = this;
				data = null;  //erase data, pointers already null
			}
		}
		return toReturn;  //null if not found, or set to deleted linked list if found
	}
	
	//Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
	//sort maxAce from max to min
	public void insert(HurricaneRowData newValue) {
		if(newValue.getAceIndex() > data.getAceIndex()) {
			if(hasPrevious()) { //middle or end linkedlist
				DoublyLinkedSortedList newList = new DoublyLinkedSortedList(newValue);  //create newList
				newList.previous = previous; //set newList's previous to current previous
				newList.next = this;  //set newLists's next to current linkedList
				
				//reset pointers of linkedlists ahead and behind to point to the inserted linkedlist
				previous.next = newList;
				next.previous = newList;
			}
			
			else if(!hasPrevious() && hasNext()) { //first linkedlist
				DoublyLinkedSortedList newList = new DoublyLinkedSortedList(newValue);  //create newList
				//don't set newList previous because already null
				newList.next = this; //newList's next set to current linkedList
				previous = newList; //current linkedList's previous set to newList
			}
		}
		
		else if(hasNext()) {
			next.insert(newValue);  //call insert on next linkedlist
		}
		
		else { //smallest value, add to end
			DoublyLinkedSortedList newList = new DoublyLinkedSortedList(newValue);  //create newList
			//don't set newList next because already null
			newList.previous = this;  //newList's previous is current linkedList
			next = newList;  //current linkedList's next is set to newList
		}
	}
	
	//Return the entire list as a multi-line String
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