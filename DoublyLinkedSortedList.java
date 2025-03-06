

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
		
		//create toRemove variable
		DoublyLinkedSortedList toReturn = null;
		
		if(!getValue().equals(toRemove)) { //if data != toRemove
			next.remove(toRemove); //check next linkedlist
		} 
		
		else {
			if(hasPrevious() && hasNext()) { //middle linkedlist
				
			}
			else if(!hasPrevious() && hasNext()) { //first linkedlist
				
			}
			else if(hasPrevious() && !hasNext()) {  //last linkedlist
				
			}
		}
		return toReturn;
	}
	
	/*
	//example code, DELETE
	public T removeAt(int index)
	{
		T toReturn = null;
		// This doesn't remove the link.
		// Should index 0 throw an error instead?
		if(index == 0)
		{
			toReturn = data;
			data = null;
			System.out.println("Possible error in LinkedList.removeAt. Link not actually delete for index 0.");
		}
		if(index == 1)
		{
			if(hasNext())
			{
				// Skip next
				toReturn = next.getData();
				LinkedList<T> nextNext = next.getNext();
				setNext(nextNext);
			}
			else
			{
				// There is no next to be deleted.
				// Throw an error?
				System.out.println("Possible error in LinkedList.removeAt. Link to be deleted does not exist.");
			}
		} //if(index == 1)
		else
		{	// Recurse
			toReturn = next.removeAt(index-1);
		}
		return toReturn;
	} */
	
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