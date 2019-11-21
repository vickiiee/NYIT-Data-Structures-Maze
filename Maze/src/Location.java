public class Location {
		int rowLocation;
		int colLocation;
		void setLocation(int row, int col){
			this.rowLocation=row;
			this.colLocation = col;
		}
		
		int getRowLocation(){
			return rowLocation;
		}
		
		int getColLocation(){
			return colLocation;
		}
	}


	class Node<T>{
		T data;
	    Node next;
	    public Node(T data){
	        this.data=data;
	    }
	    public void displayNode(){
	        System.out.print(data+ " ");
	    }
	}


	class LinkList <T> {

	    
	    private Node first = null;
	    private Node last = null;

	    public boolean isEmpty() {
	        return (first == null);
	    }

	    public <T> void addLast(T data) {
	        Node n = new Node(data);
	        if (isEmpty()) {
	            n.next = null;
	            first = n;
	            last = n;
	        } else {
	            last.next = n;
	            last = n;
	            last.next = null;
	        }

	    }

	    public T removeFirst() {

	            Node temp = first;
	            if(first != null){
	            	if (first.next == null)
	            		last = null;
	            	first = first.next;
	            	temp.next=null;
	            	return (T) temp.data;
	            }else{
	            	return null;
	            }
	        }


	    public void displayList() {
	        Node current = first;
	        while (current != null) {
	            current.displayNode();
	            current = current.next;
	        }
	    }

	}
