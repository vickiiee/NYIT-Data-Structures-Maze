public class LocationQueue {

	private Location first; 
	private Location last; 
	
	private Maze m;
	
	public LocationQueue() {
		first = null; 
		last = null; 
	}

	public void insertLast(Location data) { //insert last
		if(first == null ) {
			first = data; 
			last = data;
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
	
	public void findRoute() {//int endRow, int endCol, char[][] mazeArr
		Location current = first;
		while(current != null) {
			//if current location/coordinate is end, you found the end
			
			m.getMazeArr()[current.getRowLocation()][current.getColLocation()] = '.';
			deleteFirst();
			if(current.getRowLocation() == m.getEndRow() && current.getColLocation() == m.getEndCol()) {
				System.out.println("You did it! You found the end!");
				break;
			}else {
				//add possible next coordinates from current
				
				//check top
				if(current.getRowLocation()!= 0) {
					if(m.getMazeArr()[current.getRowLocation()-1][current.getColLocation()] == ' ') {
						insertLast(new Location(current.getRowLocation()-1, current.getColLocation()));
					}
				}

//----->		//check bottom
				if(current.getRowLocation()!= m.getMazeArr().length-1) {
					if(m.getMazeArr()[current.getRowLocation()+1][current.getColLocation()] == ' ') {
						insertLast(new Location(current.getRowLocation()+1, current.getColLocation()));
					}
				}
				
				//check left
				if(current.getColLocation()!= 0) {
					if(m.getMazeArr()[current.getRowLocation()][current.getColLocation()-1] == ' ') {
						insertLast(new Location(current.getRowLocation(), current.getColLocation()-1));
					}
				}
				
				//check right
				if(current.getColLocation()!= m.getMazeArr()[0].length-1) {
					if(m.getMazeArr()[current.getRowLocation()][current.getColLocation()+1] == ' ') {
						Location k =new Location(current.getRowLocation(), current.getColLocation()+1);
						insertLast(k);
					}
				}
				
				current = current.getNext();
			}
			
		}
	}
	
	public void getMazeClass(Maze maze) {
		m = maze;
	}
}
