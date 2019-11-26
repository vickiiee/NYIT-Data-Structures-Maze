public class LocationQueue {

	private Location first; 
	private Location last; 
	
	public LocationQueue() {
		first = null; 
		last = null; 
	}

	public void insertLast(Location data) { //insert last
		if(first == null ) {
			first = data; 
		}else{
			last.setNext(data);
			data.setPrevious(last);
		}
		last = data;
		/*
		 * 
		Link newLink = new Link(dd); // make new link
		if (isEmpty()) // if empty list,
			setFirst(newLink); // first --> newLink
		else {
			last.setNext(newLink);// old last --> newLink
			newLink.setPrevious(last);// old last <-- newLink
		}
		last = newLink; // newLink <-- last
		 */
	}

	public void deleteFirst() { //delete first
		if(first!=null) {
			if(first.getNext() ==null) {
				last = null;
			}else {
				first = first.getNext();
				first.setPrevious(null);
			}
			
		}
	}

	public void displayQueue() {
		Location current = first;
		while(current != null) {
			System.out.println("( " + current.getRowLocation()+ ","+ current.getColLocation()+ ") ");
			current = current.getNext();
		}
	}

	public boolean isEmpty() {
		return first == null; 
	}
}
