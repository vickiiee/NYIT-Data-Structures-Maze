
public class LocationQueue {

	public LocationQueue() {
		// TODO Auto-generated constructor stub
	}
	 public  void enqueue(Location data) {
		 	locationList.addLast(data);
	    }

	    public Location dequeue() {
	        if(!locationList.isEmpty())
	        	return locationList.removeFirst();
	        else
	        	return null;

	    }

	    public void displayQueue() {
	    	locationList.displayList();
	        System.out.println();
	    }

	    public boolean isEmpty(){
	        return locationList.isEmpty();
	    }
}
