

public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
	
	//instance variables
	private HurricaneRowData data;
	private DoublyLinkedSortedList previous;
	private DoublyLinkedSortedList next;
	
	//default constructor
	public DoublyLinkedSortedList() {
		this.data = null;
		this.previous = null;
		this.next = null; 
	}
	
	//constructor with data
	public DoublyLinkedSortedList(HurricaneRowData data) {
		this.data = data;
		this.previous = null;
		this.next = null; 
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
	public void setNext(DoublyLinkedSortedList next) {
		this.next = next;
		next.previous = this;
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
	public void setPrevious(DoublyLinkedSortedList previous) {
		this.previous = previous;
		previous.next = this;
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
	
		//if empty list, set first linkedlist to this value
		if(this.data == null) { 
			this.data = newValue;
		}
		
		//if ace index value is greater than the current, add new behind it
		else if(newValue.getAceIndex() > data.getAceIndex()) {
			
		}

		else {  //smallest value, add to end
			DoublyLinkedSortedList newList = new DoublyLinkedSortedList(newValue);  //create newList
			DoublyLinkedSortedList lastList = getLast(); //get last list
			newList.setPrevious(lastList);
		}
	}
		/*
		else if(newValue.getAceIndex() > data.getAceIndex()) {
			if(hasPrevious() && hasNext()) { //middle
				DoublyLinkedSortedList newList = new DoublyLinkedSortedList(newValue);  //create newList
				newList.setPrevious(previous); //set newList's previous to current previous
				newList.setNext(this);  //set newLists's next to current linkedList
				
				//reset pointers of linkedlists ahead and behind to point to the inserted linkedlist
				previous.setNext(newList);
				next.setPrevious(newList);
			}
			
			else if(!hasPrevious() && hasNext()) { //first linkedlist
				DoublyLinkedSortedList newList = new DoublyLinkedSortedList(newValue);  //create newList
				//don't set newList previous because already null
				newList.setNext(this); //newList's next set to current linkedList
				setPrevious(newList); //current linkedList's previous set to newList
			}
		}
		
		else if(hasNext()) {
			next.insert(newValue);  //call insert on next linkedlist
		}
		
		else { //smallest value, add to end
			DoublyLinkedSortedList newList = new DoublyLinkedSortedList(newValue);  //create newList
			//don't set newList next because already null
			newList.setPrevious(this);  //newList's previous is current linkedList
			setNext(newList);  //current linkedList's next is set to newList
		}*/
	//}
	
	//TODO THIS DOES NOT WORK
	//Return the entire list as a multi-line String
	@Override
	public String toString() {
		
		//String listString = "";
		
		DoublyLinkedSortedList current = this.getFirst();
		
		
		//create String variable and add headers
		String listString = String.format("%-10s %10s %20s %20s %20s\n", 
			"Year", "Ace Index", "Tropical Storms", 
			"Hurricanes(cat.1-5)", "Huricanes(cat.3-5)");
		
		listString = String.format("%s%s\n", listString, current.getValue());
		
		while(current.hasNext()) {
			current = current.getNext();
			listString = String.format("%s%s\n", listString, current.getValue());
		}
		
		
	
		/*		
		DoublyLinkedSortedList printList = getFirst();
		
		if(printList.hasNext()) {
			//add each LinkedList on separate lines
			listString.concat(String.format("%-10d %10d %10d %10d %10d\n",
				printList.data.getYear(), printList.data.getAceIndex(), printList.data.getNumStorms(), 
				printList.data.getNumHurr(), printList.data.getNumMajHurr()));
			
			//set printList to next
			printList = getNext();
		}
			
		//advance to next and calltoString on next
		if(hasNext()) {
			next.toString();
		}*/
		return listString;
	}
}