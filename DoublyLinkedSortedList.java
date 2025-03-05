

public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
	
	//TODO Get the value of the current DoublyLinkedSortedList
	public HurricaneRowData getValue();
	
	//TODO Return true if next is not null
	public boolean hasNext();
	
	//TODO Set next to be the given DoublyLinkedSortedList
	public void setNext(DoublyLinkedSortedList next);
	
	//TODO Return a reference to the next DoublyLinkedSortedList
	public DoublyLinkedSortedList getNext();
	
	//TODO Return true if previous is not null
	public boolean hasPrevious();
	
	//TODO Set previous to be the given DoublyLinkedSortedList
	public void setPrevious(DoublyLinkedSortedList previous);
	
	//TODO Return a reference to the previous DoublyLinkedSortedList
	public DoublyLinkedSortedList getPrevious();
	
	//TODO Return a reference to the first DoublyLinkedSortedList element in the list
	public DoublyLinkedSortedList getFirst();
	
	//TODO Return a reference to the last DoublyLinkedSortedList element in the list
	public DoublyLinkedSortedList getLast();
	
	//TODO Remove the DoublyLinkedSortedList element that has toRemove as its value
	public DoublyLinkedSortedList remove(HurricaneRowData toRemove);
	
	//TODO Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
	public void insert(HurricaneRowData newValue);
	
	//TODO Return the entire list as a multi-line String
	public String toString();
}