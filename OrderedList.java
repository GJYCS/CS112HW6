package hw6;
/*
 * Your First Name: Matthew Your Last Name: Gagnon Your BU username: mgnon
 * 
 * Honor Code: I pledge that this program represents my own // program code and that I have coded on
 * my own. I have also // read the collaboration policy on the course syllabus for // CS 112 and my
 * program adheres and is consistent with the // course syllabus.
 * 
 */
public class OrderedList <T extends Comparable<T>>{
	private class Node {
		T value;
		Node next;
		Node(T v, Node n) {
			value = v;
			next = n;
		}
	}
	
	// A dummy head node -- having it simplifies a lot of code
	private Node head = new Node(null, null);
	
	/*
	 * Inserts v into the list, maintaining elements in increasing order
	 */
	public void insert (T v) {
		// TODO: Implement
	  
	  if(head.next == null) {
	    head.next = new Node(v, null);
	  }else {
	  
    	  Node previous = head, current = head.next;
    
    	  while(current != null) {
    	    int result = v.compareTo(current.value);
    	    if(result == 0 || result < 0) {
    	      previous.next = new Node(v, current);
    	      break;
    	      
    	    }
    	 }
	  
	  }
	  
	}
	
	/*
	 * Removes v; if there is more than one instance of v, removes only one.
	 * If v was found, returns true. Else, does nothing and returns false.
	 */
	public boolean delete (T v) {
		Node prev = head, cur = head.next;
		while (cur!=null) {
			int compResult = cur.value.compareTo(v);
			if (compResult == 0) { // we found the value to delete
				prev.next = cur.next;
				return true;
			}
			if (compResult>0) { // we went past the value to delete and it's not in the list
				return false;
			}
			prev = cur;
			cur = cur.next;
		}
		return false; // the value to delete is greater than everything in the list
	}
	
	/* 
	 * Returns true if the list contains v
	 */
	
	public boolean contains (T v) {
		// TODO: Implement
		Node prev = head, current = head.next;
		while(current != null) {
			int result = current.value.compareTo(v);
			if(result == 0) {
				return true;
			}
			if(result > 0) {
				return false;
			}
			prev = current;
			current = current.next;
		}
		
		return false;
	}
	
	/*
	 * Returns the result of merging this and that; runs in time O(|this|+|that|).
	 * Does not modify this or that.
	 */
	OrderedList<T> merge (OrderedList<T> that) {
		// TODO: Implement
	 if(that.head == null)
	   return this;
	 else if(this.head == null)
	   return that;
	 
	 OrderedList<T> newList = new OrderedList<>();
	 Node thisTemp = this.head;
	 Node thatTemp = that.head;
	 Node newListTemp = newList.head;
	 
	 
	 while(thisTemp != null && thatTemp != null) {
	   int compare = thisTemp.value.compareTo(thatTemp.value);
	   if(compare < 0) {
	     newListTemp = new Node(thisTemp.value, null);
	     thisTemp = thisTemp.next;
	   } else {
	     newListTemp = new Node(thatTemp.value, null);
	     thatTemp = thatTemp.next;
	   }
	   newListTemp = newListTemp.next;
	 }
	 return newList;
	}
	
    /* Same output format as java.util.Arrays.toString
     */
	public String toString() {
		if (head.next == null) return "[]";
		String s = "[";
		Node p;
		for (p = head.next; p.next!=null; p=p.next) {
			s+=p.value+", ";
		}
		s+=p.value+"]"; // last one is special, because it has no comma after
		return s;
	}

}