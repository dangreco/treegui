package better;

import java.util.ArrayList;

/**
 * The actual Node class (As in the data struct; for the GUI version, see NodeCircle
 */

public class Node {

    public int val;
    private Node root;
    private ArrayList<Node> children;

    public Node(int val, Node root)
    {
        this.val = val;
        this.root = root;
        children = new ArrayList<Node>();
    }

    public Node(int val)
    {
        this(val, null);
    }

    public ArrayList<Node> getChildren()
    {
        return children;
    }

    public void addChild(int val)
    {
        this.children.add(new Node(val, this));
    }

    public Node getRoot()
    {
        return root;
    }

    public void setRoot(Node root)
    {
        this.root = root;
    }

    @Override
    public String toString()
    {
        return Integer.toString(this.val);
    }


    public boolean hasRoot()
    {
        return this.getRoot() != null;
    }

    public boolean hasChildren(){ return this.getChildren() != null; }



}
