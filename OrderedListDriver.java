package hw6;
/*
 * Your First Name: Matthew Your Last Name: Gagnon Your BU username: mgnon
 * 
 * Honor Code: I pledge that this program represents my own // program code and that I have coded on
 * my own. I have also // read the collaboration policy on the course syllabus for // CS 112 and my
 * program adheres and is consistent with the // course syllabus.
 * 
 */
/*
 * You can edit this file in any way you like. This will not be graded. 
 */
public class OrderedListDriver {

	public static void main(String[] args) {
		OrderedList<Integer> l = new OrderedList<Integer>();
		System.out.println(l);
		l.insert(100);
		System.out.println(l);
		l.insert(100);
		System.out.println(l);
		l.insert(22);
		System.out.println(l);
		l.insert(Integer.MIN_VALUE);
		System.out.println(l);
		System.out.println(l.delete(100));
		System.out.println(l.delete(2));
		System.out.println(l);
		
		/*
		 * You should get the following output once you have your code completed: 
		[]
		[100]
		[100, 100]
		[22, 100, 100]
		[-2147483648, 22, 100, 100]
		true
		false
		[-2147483648, 22, 100]
		 */
	}
}