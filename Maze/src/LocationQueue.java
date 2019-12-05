public class LocationQueue {

	private Location first; 
	private Location last; 
	
	private Maze m;
	
	private boolean stop; 
	public LocationQueue() {
		stop = false;
		first = null; 
		last = null; 
	}

	public void insertLast(Location data) { //insert last
		if(first == null ) {
			first = data; 
			//last = data;
		}else{
			last.setNext(data);
			data.setPrevious(last);
		}
		last = data;
		
		System.out.println("INSERTLAST");
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

	public Location getFirst() {
		return first;
	}

	public void deleteFirst() { //delete first
		if(first!=null) {
			if(first.getNext() ==null) {
				last = null;
			}else {
				first = first.getNext();
				first.setPrevious(null);
			}
			System.out.println("deletefirst ");
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
	
	/**public void findRoute() {//int endRow, int endCol, char[][] mazeArr
		//RECURSION; no while loop just dequeue and make parameter the location class
		Location current = first;
		while(current != null) {
			//if current location/coordinate is end, you found the end
			
			m.getMazeArr()[current.getRowLocation()][current.getColLocation()] = '.';
			//deleteFirst();
			if(current.getRowLocation() == m.getEndRow() && current.getColLocation() == m.getEndCol()) {
				System.out.println("You did it! You found the end!");
				
				break;
			}else {
				//add possible next coordinates from current
				
				//check top
				if(current.getRowLocation()!= 0) {
					if(m.getMazeArr()[current.getRowLocation()-1][current.getColLocation()] == ' ') {
						insertLast(new Location(current.getRowLocation()-1, current.getColLocation()));
						deleteFirst();
						//delete first?
						//method with ^location as parameter and make possibly 2 booleans: visted and in queue so no repeated location classes in it... mayb not need this bcuz visited space will already b marked with '.'
					}
				}

//----->		//check bottom
				if(current.getRowLocation()!= m.getMazeArr().length-1) {
					if(m.getMazeArr()[current.getRowLocation()+1][current.getColLocation()] == ' ') {
						insertLast(new Location(current.getRowLocation()+1, current.getColLocation()));
						deleteFirst();
					}
				}
				
				//check left
				if(current.getColLocation()!= 0) {
					if(m.getMazeArr()[current.getRowLocation()][current.getColLocation()-1] == ' ') {
						insertLast(new Location(current.getRowLocation(), current.getColLocation()-1));
						deleteFirst();
					}
				}
				
				//check right
				if(current.getColLocation()!= m.getMazeArr()[0].length-1) {
					if(m.getMazeArr()[current.getRowLocation()][current.getColLocation()+1] == ' ') {
						Location k =new Location(current.getRowLocation(), current.getColLocation()+1);
						insertLast(k);
						deleteFirst();
					}
				}
				
				current = current.getNext();
			}
			
		}
	}**/
	
	public String findRouteRecursion(Location current) {//int endRow, int endCol, char[][] mazeArr
		System.out.println("-----------------------RECURSION--------------------------");
		//-RECURSION; no while loop just dequeue and make parameter the  location class
		//Location current = first;
		//while(current != null) {
			//-if current location/coordinate is end, you found the end
			System.out.println("Current location: "+ current.getRowLocation()+","+current.getColLocation() +"\n endrow: "+ m.getEndRow()+ ", end col:" + m.getEndCol());
			m.getMazeArr()[current.getRowLocation()][current.getColLocation()] = '+';
			//deleteFirst();
			if(current.getRowLocation() == m.getEndRow() && current.getColLocation() == m.getEndCol()) {
				System.out.println("--------------------------------You did it! You found the end!--------------------------------------------------");
				stop = true;
				
				return "You did it! You found the end!";
			}else {
				//add possible next coordinates from current
				
				//check top
				if(current.getRowLocation()!= 0 && stop == false) {
					if(m.getMazeArr()[current.getRowLocation()-1][current.getColLocation()] == ' ') {
						System.out.println("	top");
						Location k =new Location(current.getRowLocation()-1, current.getColLocation());
						insertLast(k);
						findRouteRecursion(k);
						//deleteFirst();
						//delete first?
						//method with ^location as parameter and make possibly 2 booleans: visted and in queue so no repeated location classes in it... mayb not need this bcuz visited space will already b marked with '.'
					}
				}
				
				//check right
				if(current.getColLocation()!= m.getMazeArr()[0].length-1 && stop == false) {
					if(m.getMazeArr()[current.getRowLocation()][current.getColLocation()+1] == ' ') {
						System.out.println("	right");
						Location k =new Location(current.getRowLocation(), current.getColLocation()+1);
						insertLast(k);
						findRouteRecursion(k);
						//deleteFirst();
					}
				}
				
//----->		//check bottom
				if(current.getRowLocation()!= m.getMazeArr().length-1 && stop == false) {
					if(m.getMazeArr()[current.getRowLocation()+1][current.getColLocation()] == ' ') {
						System.out.println("	bottom");
						Location k = new Location(current.getRowLocation()+1, current.getColLocation());
						insertLast(k);
						findRouteRecursion(k);
						//deleteFirst();
					}
				}
				
				
				//check left
				if(current.getColLocation()!= 0 && stop == false) {
					if(m.getMazeArr()[current.getRowLocation()][current.getColLocation()-1] == ' ') {
						System.out.println("	left");
						Location k = new Location(current.getRowLocation(), current.getColLocation()-1);
						insertLast(k);
						findRouteRecursion(k);
						//deleteFirst();
					}
				}
				
				
				
				deleteFirst();
				
				//current = current.getNext();
			}
			
		
		return "nononoonono";
	}
	
	public void findRouteQ(Location current) {//int endRow, int endCol, char[][] mazeArr
		System.out.println("-----------------------BREADTH FIRST SEARCH... KINDA--------------------------");
		//-RECURSION; no while loop just dequeue and make parameter the  location class
		//Location current = first;
		while(current != null) {
			//-if current location/coordinate is end, you found the end
			System.out.println("Current location: "+ current.getRowLocation()+","+current.getColLocation() +"\n endrow: "+ m.getEndRow()+ ", end col:" + m.getEndCol());
			m.getMazeArr()[current.getRowLocation()][current.getColLocation()] = '+';
			//deleteFirst();
			if(current.getRowLocation() == m.getEndRow() && current.getColLocation() == m.getEndCol()) {
				System.out.println("--------------------------------You did it! You found the end!--------------------------------------------------");
				stop = true;
				break;
				//return "You did it! You found the end!";
			}else {
				//add possible next coordinates from current
				
				//check top
				if(current.getRowLocation()!= 0 && stop == false) {
					if(m.getMazeArr()[current.getRowLocation()-1][current.getColLocation()] == ' ') {
						System.out.println("	top");
						Location k =new Location(current.getRowLocation()-1, current.getColLocation());
						insertLast(k);
						//findRouteQ(k);
						//current = current.getNext();
						//break;
						//method with ^location as parameter and make possibly 2 booleans: visted and in queue so no repeated location classes in it... mayb not need this bcuz visited space will already b marked with '.'
					}
				}

				//check right
				if(current.getColLocation()!= m.getMazeArr()[0].length-1 && stop == false) {
					if(m.getMazeArr()[current.getRowLocation()][current.getColLocation()+1] == ' ') {
						System.out.println("	right");
						Location k =new Location(current.getRowLocation(), current.getColLocation()+1);
						insertLast(k);
						//current = current.getNext();
						//break;
						//deleteFirst();
					}
				}
				
//----->		//check bottom
				if(current.getRowLocation()!= m.getMazeArr().length-1 && stop == false) {
					if(m.getMazeArr()[current.getRowLocation()+1][current.getColLocation()] == ' ') {
						System.out.println("	bottom");
						Location k = new Location(current.getRowLocation()+1, current.getColLocation());
						insertLast(k);
						//current = current.getNext();
						//break;
						//deleteFirst();
					}
				}
				
				
				
				
				
				//check left
				if(current.getColLocation()!= 0 && stop == false) {
					if(m.getMazeArr()[current.getRowLocation()][current.getColLocation()-1] == ' ') {
						System.out.println("	left");
						Location k = new Location(current.getRowLocation(), current.getColLocation()-1);
						insertLast(k);
						//current = current.getNext();
						//break;
						//deleteFirst();
					}
				}
				
				current = current.getNext();
				//current = current.getNext();
				deleteFirst();
			}
		}
	}
		
		//return "nononoonono";
	

	public void getMazeClass(Maze maze) {
		m = maze;
	}
}
