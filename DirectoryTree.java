package hw6;

import java.util.ArrayList;
import java.util.Collections;
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
  private Node current;

  public class Node {
    private Node parent;
    private String name;
    private LinkedList<Node> children;

    public Node(Node p, String n) {
      parent = p;
      name = n;
      children = new LinkedList<Node>();
    }

  }

  public DirectoryTree() {
    root = new Node(null, "");
    current = root;
  }

  public boolean mkdir(String name) {

    return _mkDir(name, current);
  }

  private boolean _mkDir(String n, Node c) {

    boolean alreadyExists = false;
    for (Node child : c.children) {
      if (child.name.equalsIgnoreCase(n))
        alreadyExists = true;
    }
    if (alreadyExists)
      return false;
    else {
      c.children.add(new Node(c, n));
      return true;
    }
  }

  public boolean cd(String name) {


    for (Node child : current.children) {
      if (child.name.equalsIgnoreCase(name)) {
        current = child;
        return true;
      }
    }
    return false;

  }


  public boolean cdUp() { // dont have to do ??
    if (current.parent == null)
      return false;
    else {
      current = current.parent;
      return true;
    }
  }

  public boolean rmdir(String name) {
    boolean exists = false;
    for (Node child : current.children) {
      if (child.name.equalsIgnoreCase(name)) {
        current.children.remove(child);
        exists = true;
      }
    }
    return exists;
  }

  public String ls() {
    String str = "";
    if (current.children.isEmpty())
      return str;
    for (Node child : current.children) {
      str += child.name + " ";
    }
    return str + "\n";
  }

  public String printSubTree() {
    return _printSubTree( current, 0);

  }

  private String _printSubTree( Node n, int depth) {
    String ret = "";
    for(int i = 0; i < depth; i++) {
      ret += " ";
    }
    ret += n.name + "\n";
    for(Node child: n.children) {
      ret += _printSubTree( child, depth + 1);
    }
    return ret;
  }

  public String pwd() {
    ArrayList<String> list = new ArrayList<>();
    _pwd(current, list);
    Collections.reverse(list);
    String str = "";
    for (String c : list) {
      if (c.equalsIgnoreCase(""))
        continue;
      str += "/" + c;
    }
    return str;
  }

  private void _pwd(Node c, ArrayList<String> list) {
    if (c == null)
      return;
    list.add(c.name);
    _pwd(c.parent, list);
  }

  public int numNodes() {
    int sum = 0;

    return 1 + _numNodes(current, sum);
  }

  private int _numNodes(Node c, int s) {

    if (c.children.isEmpty())
      return 0;

    for (Node child : c.children) {
      s += _numNodes(child, s) + 1;

    }
    return s;
  }

}


