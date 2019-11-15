package hw6;
/*
 * Your First Name: Matthew Your Last Name: Gagnon Your BU username: mgnon
 * 
 * Honor Code: I pledge that this program represents my own // program code and that I have coded on
 * my own. I have also // read the collaboration policy on the course syllabus for // CS 112 and my
 * program adheres and is consistent with the // course syllabus.
 * 
 */

public class Tree {
	private Node root;
	
	private class Node {
		/*
		 * TODO: Complete the class Node. 
		 * You can add any number of instance variables or methods
		 * or constructor to the Node class. 
		 */
	}
	
	
	/*
	 * We have completed the constructor of the Tree class. 
	 */
	public Tree()
	{
		root=new Node();
		
	}
	
	/*
	 * TODO: add the word into the tree based on the structure
	 * provided in the handout. You must use recursion. Feel free
	 * to create a helper private method that will do the recursion 
	 * for you.  
	 */
	public void add(String word)
	{
		
		    
	}

	
	/*
	 * TODO: Checks whether the word is present in the tree or not. 
	 * You must use recursion. Feel free
	 * to create a helper private method that will do the recursion 
	 * for you.  
	 */
	
	public boolean check(String word)
	{
		return false;
	}

	
	/*
	 * We have already completed this method for you. 
	 * This method works with the preconditions that all letter
	 * are lower case and between and inclusive a-z
	 * For example, if the letter is a, then the output is 0
	 * For example, if the letter is b, then the output is 1
	 * For example, if the letter is c, then the output is 2
	 * .
	 * .
	 * .
	 * For example, if the letter is z, then the output is 25
	 */
	private static int convertFromLetterToIndexPosition(char letter)
	{
		int temp = (int)letter;
		int temp_integer = 96; //for lower case
		return (temp-temp_integer-1);
		
	}
	
	
	/*
	 * We have already completed this method for you. 
	 * This method works with the preconditions that all integers
	 * are between 0 and 25. 
	 * For example, if the index is 0, then the output is a
	 * For example, if the letter is 1, then the output is b
	 * For example, if the letter is 2, then the output is c
	 * .
	 * .
	 * .
	 * For example, if the letter is 25, then the output is z
	 */
	private static String convertFromIndexToLetter(int index)
	{
		return String.valueOf((char)(index + 97));
	}
	
	/*
	 * TODO: You must complete this method. You can use recursion or no recursion. 
	 * It is completely upto you. This method however, must return back a string of 
	 * words in alphabetical order that represents the dictionary that the tree is 
	 * currently holding. See the main method for an expected output of this. 
	 */
	public String getDictionaryInAlphabeticalOrder()
	{
		
		
	}
	
	
	public static void main(String[] args)
	{
		Tree dictionary=new Tree();
		dictionary.add("abbas");
		dictionary.add("ab");
		dictionary.add("a");
		dictionary.add("xan");
		dictionary.add("ban");
		dictionary.add("acbbas");
		dictionary.add("cat");
		dictionary.add("dog");
		
		System.out.println(dictionary.check("abbas")); //true
		System.out.println(dictionary.check("ab"));  //true
		System.out.println(dictionary.check("abb")); //false
		System.out.println(dictionary.check("a")); //true
		System.out.println(dictionary.check("xab")); //false
		System.out.println(dictionary.check("xan")); //true
		
		System.out.println(dictionary.getDictionaryInAlphabeticalOrder()); //a ab abbas acbbas ban cat dog xan 
		
	}

}
