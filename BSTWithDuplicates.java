package hw6;

/*
 * Your First Name: Matthew Your Last Name: Gagnon Your BU username: mgnon
 * 
 * Honor Code: I pledge that this program represents my own // program code and that I have coded on
 * my own. I have also // read the collaboration policy on the course syllabus for // CS 112 and my
 * program adheres and is consistent with the // course syllabus.
 * 
 */
import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.Node;

public class BSTWithDuplicates<T extends Comparable<T>> {
	BinaryNode root;

	public BSTWithDuplicates() {
		super();
	}

	private class BinaryNode {
		/*
		 * You are not required to add any new instance variables or methods to
		 * BinaryNode class.
		 */
		T data;
		BinaryNode left;
		BinaryNode right;

		private BinaryNode(T rootEntry) {
			data = rootEntry;
		}

	}

	/*
	 * We have completed the constructor of BSTWithDuplicates for you.
	 */
	public BSTWithDuplicates(T rootEntry) {
		root = new BinaryNode(rootEntry);
	}

	/*
	 * TODO: Write a method called getMin that returns back the minimum of the
	 * binary search tree. You can use recursion or no recursion for this method.
	 */
	public T getMin() {
		if (root == null)
			return null;
		return _getMin(root);
	}

	private T _getMin(BinaryNode a) {
		if (a.left == null)
			return a.data;
		return _getMin(a.left);
	}

	/*
	 * TODO: Write a method called getMax that returns back the maximum of the
	 * binary search tree. You can use recursion or no recursion for this method.
	 */
	public T getMax() {
		if (root == null)
			return null;
		return _getMax(root);
	}

	private T _getMax(BinaryNode a) {
		if (a.right == null)
			return a.data;
		return _getMax(a.right);
	}

	/*
	 * TODO: Write a method called getEntry that returns back the data (of type T)
	 * if entry is in the binary search tree. If there are duplicates of entry,
	 * getEntry must return back the first occurance of entry. You must use
	 * recursion to solve this. Feel free to create a helper method that does the
	 * recursion for you.
	 */
	public T getEntry(T entry) {
		if (root == null)
			return null;
		return _getEntry(root, entry);
	}

	private T _getEntry(BinaryNode a, T entry) {
		if (a != null) {
			if (a.data == entry)
				return a.data;
			T left = _getEntry(a.left, entry), right = _getEntry(a.right, entry);
			T ret = left != null ? left : right;
			return ret;
		}
		return null;
	}

	/*
	 * TODO: Write a method called getAllEntry that returns back all data (of type
	 * T) for entry. All the occurances of entry must be put inside an ArrayList. If
	 * there is no entry, then you return back null. You must use recursion to solve
	 * this. Feel free to create a helper method that does the recursion for you.
	 */
	public ArrayList<T> getAllEntriesEqualTo(T entry) // *
	{
		
		ArrayList<T> list = new ArrayList<>();
		_getAllEntries(root, entry, list);
		return list;
	}

	private void _getAllEntries(BinaryNode a, T entry, ArrayList list) {

		if (a != null) {
			if (a.data == entry)
				list.add(a.data);

			_getAllEntries(a.left, entry, list);
			_getAllEntries(a.right, entry, list);

		}
		

	}

	/*
	 * TODO: Write a method called contains that checks whether a entry of type T is
	 * present in the binary search tree with duplicates or not. If it is present
	 * return back True or otherwise return back False. This method must call
	 * getEntry.
	 */
	public boolean contains(T entry) {
		if (root == null)
			return false;
		return _contains(entry, root);
	}

	private boolean _contains(T entry, BinaryNode a) {
		if (a != null) {
			if (a.data == entry)
				return true;
			return _contains(entry, a.left) || _contains(entry, a.right);
		}
		return false;
	}

	/*
	 * TODO: Write a method called add that adds newEntry onto the binary tree with
	 * duplicates. This method must use recursion. Feel free to create another
	 * helper method that does the recursion for you.
	 */
	public T add(T newEntry) {

		root = _add( root, new BinaryNode(newEntry));
		return newEntry;

	}
	private BinaryNode _add(BinaryNode currentParent,BinaryNode current) {
		if(currentParent == null)
			return current;
		else if(current.data.compareTo(currentParent.data) > 0) {
			currentParent.right = _add(currentParent.right, current);
		}else if(current.data.compareTo(currentParent.data) <= 0 ) {
			currentParent.left = _add(currentParent.left, current);
		}
		return currentParent;
	}

}