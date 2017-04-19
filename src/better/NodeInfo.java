package better;

import java.util.ArrayList;

/**
 * Class to store information about a node object for easier access of related objects.
 */

public class NodeInfo {

    private Node parent;
    private ArrayList<Node> children;
    private NodeCircle thisGUI;
    private NodeLink top;

    public NodeInfo(Node parent)
    {
        this.parent = parent;
        this.children = null;
        this.thisGUI = null;
        this.top = null;
    }

    public void setChildren(ArrayList<Node> children)
    {
        this.children = children;
    }

    public void setNodeCircle(NodeCircle x)
    {
        this.thisGUI = x;
    }

    public void setNodeLink(NodeLink x)
    {
        this.top = x;
    }

    public Node getParent()
    {
        return this.parent;
    }

    public ArrayList<Node> getChildren()
    {
        return this.children;
    }

    public NodeCircle getThisGUI()
    {
        return this.thisGUI;
    }

    public NodeLink getTop()
    {
        return this.top;
    }

    public void setTop(NodeLink x) {
        this.top = x;
    }

    @Override
    public String toString()
    {
        return "Root: " + parent +
                "\nChildren: " + children +
                "\nGUI: " + thisGUI +
                "\nTop Line: " + top;
    }


}
