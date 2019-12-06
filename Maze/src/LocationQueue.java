//Author:Vickie Wu and Rosenaldie Beauvais
// 12-10-19

public class LocationQueue {

	private Location first;
	private Location last;

	private Maze m;

	public LocationQueue() {	
		first = null;
		last = null;
	}

	public void insertLast(Location data) { // insert last
		if (first == null) {
			first = data;
		} else {
			last.setNext(data);
			data.setPrevious(last);
		}
		last = data;

		// System.out.println(" INSERTLAST");
	}

	public Location getFirst() {
		return first;
	}

	public Location deleteFirst() { // delete first
		/*
		 * Link temp = first; if(first.next == null) // if only one item last = null; //
		 * null <-- last else first.next.previous = null; // null <-- old next first =
		 * first.next; // first --> old next return temp;
		 * 
		 */
		if (first != null) {
			Location temp = first;
			if (first.getNext() == null) {
				last = null;
			} else {
				first.getNext().setPrevious(null);
			}
			first = first.getNext();
			System.out.println("deletefirst ");
			return temp;
		} else {
			System.out.println("No items to delete");
			return null;
		}
	}

	public void displayQueue() {
		Location current = first;
		while (current != null) {
			//getCoordinates();
			System.out.println("( " + current.getRowLocation() + "," + current.getColLocation() + ") . "
					+ m.getVisit()[current.getRowLocation()][current.getColLocation()] + "|"
					+ m.getMazeArr()[current.getRowLocation()][current.getColLocation()]);
			current = current.getNext();
		}
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void getMazeClass(Maze maze) {
		m = maze;
	}
}
