public class Location {
	private int rowLocation;
	private int colLocation;

	private Location next; 
	private Location previous;
	
	/*private boolean top;
	private boolean bottom;
	private boolean left;
	private boolean right;*/
	
	private boolean visit;
	
	public Location(int row, int col) {
		this.rowLocation = row;
		this.colLocation = col;
		
		/*top = false;
		bottom = false;
		left = false;
		right = false;*/
		
		visit = false;
	}

	/*public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean isBottom() {
		return bottom;
	}

	public void setBottom(boolean bottom) {
		this.bottom = bottom;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}*/

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
		System.out.print("("+rowLocation+","+colLocation+")");
	}

	public boolean isVisit() {
		return visit;
	}

	public void setVisit(boolean visit) {
		this.visit = visit;
	}
	
}
