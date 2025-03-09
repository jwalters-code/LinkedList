

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
		
		//Call the next link until the correct one is found
		while(!getValue().equals(toRemove)) { //not link to remove
			next.remove(toRemove); //check next linkedlist
		} 
	
		//if it finds the data, redirect pointers
		if(getValue().equals(toRemove)) {
			if(hasPrevious() && hasNext()) { //middle of linkedlist
				toReturn = this;
				previous.setNext(next);
			}
			
			else if(!hasPrevious() && hasNext()) { //first in linkedlist
				toReturn = this;
				next.setPrevious(null);
			}
			
			else if(hasPrevious() && !hasNext()) {  //last in linkedlist
				toReturn = this;
				previous.setNext(null);  //set previous's next to null
			}
			
			else { //only link on list
				toReturn = this;
				data = null;  //nullify data, pointers already null
				System.out.print("Only link in list, data has been nullified");
			}
		}
		return toReturn;  //deleted link, null if not found
	}
	
	//Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
	//sort maxAce from max to min
	public void insert(HurricaneRowData newValue) {
	
		//if empty list, set first linkedlist to this value
		if(this.data == null) { 
			this.data = newValue;
		}
		
		//create newList to be inserted
		DoublyLinkedSortedList newList = new DoublyLinkedSortedList(newValue);
		
		if((newValue.getAceIndex() > data.getAceIndex()) || (newValue.getAceIndex() <= data.getAceIndex()) && !hasNext()) {
		
			//if newList is the new first in list
			if((newValue.getAceIndex() > data.getAceIndex()) && !hasPrevious()) {
				setPrevious(newList);
			}
			
			//if newList is smallest number, attach to end
			else if((newValue.getAceIndex() <= data.getAceIndex()) && !hasNext()) {  
				setNext(newList);
			}
			
			//if newList goes between two links
			else {
				newList.setPrevious(previous);
				setPrevious(newList);
			}
		}
		else {
			next.insert(newValue);  //check next link
		}
	}
	
	//Return the entire list as a multi-line String
	@Override
	public String toString() {
		
		//create current list variable
		DoublyLinkedSortedList current = this.getFirst();
		
		//create String variable and add headers
		String listString = String.format("%-10s %10s %20s %20s %20s\n", 
			"Year", "Ace Index", "Tropical Storms", 
			"Hurricanes(cat.1-5)", "Huricanes(cat.3-5)");
		
		//add first linkedlist element to String
		listString = String.format("%s%s\n", listString, current.getValue());
		
		//add concurrent linkedlist elements to String
		while(current.hasNext()) {
			current = current.getNext();
			listString = String.format("%s%s\n", listString, current.getValue());
		}
		return listString;
	}
}