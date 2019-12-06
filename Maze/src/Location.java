//Author: Vickie Wu and Rosenaldie Beauvais
// 12-10-19

public class Location {
	private int rowLocation;
	private int colLocation;

	private Location next;
	private Location previous;
	
	public Location(int row, int col) {
		this.rowLocation = row;
		this.colLocation = col;
	}

	int getRowLocation() {
		return rowLocation;
	}

	public Location getNext() {
		return next;
	}

	public void setNext(Location next) {
		this.next = next;
	}

	public Location getPrevious() {
		return previous;
	}

	public void setPrevious(Location previous) {
		this.previous = previous;
	}

	public void setRowLocation(int rowLocation) {
		this.rowLocation = rowLocation;
	}

	public int getColLocation() {
		return colLocation;
	}

	public void getCoordinates() {
		System.out.print("(" + rowLocation + "," + colLocation + ")");
	}

}
