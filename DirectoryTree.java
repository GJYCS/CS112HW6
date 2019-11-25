package hw6;

import java.util.LinkedList;

/*
 * Your First Name: Matthew Your Last Name: Gagnon Your BU username: mgnon
 * 
 * Honor Code: I pledge that this program represents my own // program code and that I have coded on
 * my own. I have also // read the collaboration policy on the course syllabus for // CS 112 and my
 * program adheres and is consistent with the // course syllabus.
 * 
 */


public class DirectoryTree {
	// TODO nothing here is implemented, these are just empty
	// shells so the compiler doesn't complain
	// Implement private members, public methods,
	// and private helper methods, etc., as needed,
	// in order to get the behavior described on the pset
	// You will want to maintain two private members:
	// the root and the current directory.
	
	private Node root;
	public class Node {
		private Node parent;
		private LinkedList<Node> children;
		public Node(Node p) {
			parent = p;
			
		}
		
	}
	
	
	public boolean mkdir (String name) {
		
		return false;
	}
	
	public boolean cd (String name) {
		return false;
	}
	
	public boolean cdUp() {
		return false;
	}
	
	public boolean rmdir (String name) {
		return false;
	}

	public String ls () {
		return "";
	}
	
	public String printSubTree() {
		return "";
	}
	
	public String pwd () {
		return "";
	}
	
	public int numNodes() {
		return 0;
	}
}