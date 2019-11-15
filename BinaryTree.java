package hw6;
/*
 * Your First Name: Matthew Your Last Name: Gagnon Your BU username: mgnon
 * 
 * Honor Code: I pledge that this program represents my own // program code and that I have coded on
 * my own. I have also // read the collaboration policy on the course syllabus for // CS 112 and my
 * program adheres and is consistent with the // course syllabus.
 * 
 */

import java.util.LinkedList;

public class BinaryTree<T> {

	private Node root;
	private class Node
	{
		T data;
		Node left;
		Node right;
		
		public Node(T d)
		{
			data=d;
			left=null;
			right=null;
		}
		
		
		/*
		 * DO NOT MODIFY THIS METHOD
		 */
		public void addData(Node aboutToGetInserted)
		{
			LinkedList<Node> q=new LinkedList<Node>();
			q.add(this); //adding the root onto the linked list
			while(true)
			{
				Node candidate=q.poll();
				if (candidate.left==null)
				{
					candidate.left=aboutToGetInserted;
					break;
				}
				else if (candidate.right==null)
				{
					candidate.right=aboutToGetInserted;
					break;
				}
				else
				{
					q.add(candidate.left);
					q.add(candidate.right);
				}
				
			}
			
		}
	}
	
	/*TODO: This method returns true if 
	 * the argument tree is structurally 
	 * identical to this binary tree. 
	 * Two trees are structurally identical if 
	 * their nodes have corresponding positions. 
	 * You must use recursion. 
	 * 
	 */
	public boolean isStructurallyIdentical(BinaryTree<T> otherTree) {
		
		if(this.root == null && otherTree.root == null)
			return true;
		else
			return _isStructurallyIdentical(this.root, otherTree.root);
			
	
	}
	
	private boolean _isStructurallyIdentical(Node a, Node b) {
		if(a == null && b == null)
			return true;
		if(a != null && b != null) {
			return _isStructurallyIdentical(a.left, b.left) && _isStructurallyIdentical(a.right, b.right); 
		}
		return false;
		
		
	}
	
	
	/*TODO: 
	 * Write the method isIdentical, 
	 * which returns true if the argument tree is 
	 * identical to this binary tree. 
	 * Two trees are identical if 
	 * their nodes have corresponding 
	 * positions and identical values.
	 * You must use recursion for this. 
	 * 
	 */
	public boolean isIdentical(BinaryTree<T> otherTree)
	{
		if(this.root == null && otherTree.root == null)
			return false;
		return _isIdentical(this.root, otherTree.root);
	}
	private boolean _isIdentical(Node a, Node b) {
		
		if(a == null && b == null) {	//base case
			return true;
		}
		if(a != null && b != null && a.data.equals(b.data)) {
			return _isIdentical(a.left, b.left) && _isIdentical(a.right, b.right); 
		}
		
		return false;
	}
	
	/*
	 * DO NOT MODIFY THIS METHOD
	 */
	public void addData(T d)
	{
		Node temp=new Node(d);
		if (root==null)
		{
			root=temp;
			return;
		}
		root.addData(temp);
	}
	
	public static void main(String[] args)
	{
		BinaryTree<Integer> t=new BinaryTree<>();
		t.addData(1);
		t.addData(2);
		t.addData(3);
		t.addData(4);
		t.addData(5);
		t.addData(6);
		t.addData(7);
		
		BinaryTree<Integer> t1=new BinaryTree<>();
		t1.addData(11);
		t1.addData(21);
		t1.addData(31);
		t1.addData(41);
		t1.addData(51);
		t1.addData(61);
		t1.addData(71);
		
		BinaryTree<Integer> t2=new BinaryTree<>();
		t2.addData(1);
		t2.addData(2);
		t2.addData(3);
		t2.addData(4);
		t2.addData(5);
		t2.addData(6);
		t2.addData(7);
		
		BinaryTree<Integer> t3=new BinaryTree<>();
		t3.addData(1);
		t3.addData(2);
		
		
		System.out.println(t.isIdentical(t1)); //must print back false
		System.out.println(t.isIdentical(t)); //must print back true
		System.out.println(t.isIdentical(t2)); //must print back true
		
		System.out.println(t.isStructurallyIdentical(t2)); //must print back true
		System.out.println(t1.isStructurallyIdentical(t2)); //must print back true
		System.out.println(t.isStructurallyIdentical(t1)); //must print back true
		
		System.out.println(t.isStructurallyIdentical(t3)); //must print back false
		System.out.println(t3.isStructurallyIdentical(t)); //must print back false
		System.out.println(t3.isStructurallyIdentical(t1)); //must print back false
		
		
		
		
	}
}