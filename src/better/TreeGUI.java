package better;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The jumbo class for managing the whole Tree GUI.
 */

public class TreeGUI extends Pane {

    public static int PANEWIDTH = 1080;
    public static int PANEHEIGHT = 720;

    private Tree main;

    private static HashMap<Node, NodeInfo> nodeDB;
    private HashMap<Integer, ArrayList<Node>> layers;
    private ArrayList<Node> allNodes;

    public TreeGUI(Tree main)
    {
        super();
        this.main = main;
        this.nodeDB = new HashMap<>();
        this.layers = new HashMap<>();
        this.allNodes = new ArrayList<>();
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));

        ArrayList<Node> rootAL = new ArrayList<>();
        rootAL.add(main.root);

        separateTreeIntoLayers(0, rootAL);
        organizeTreeNodes(null, main.root);
        addGUIItemsToNodes();
        positionNodeCircles();
        addGUILinksToNodes();



    }

    public static void highlightNodePath(Node n)
    {

        NodeInfo i = nodeDB.get(n);
        if (i.getTop() != null)
            i.getTop().highlight();

        i.getThisGUI().highlight();

        if (n.hasRoot())
            highlightNodePath(n.getRoot());

    }

    public static void unhighlightNodePath(Node n)
    {

        NodeInfo i = nodeDB.get(n);
        if (i.getTop() != null)
            i.getTop().unhighlight();

        i.getThisGUI().unhighlight();

        if (n.hasRoot())
            unhighlightNodePath(n.getRoot());

    }

    public void separateTreeIntoLayers(int layer, ArrayList<Node> children)
    {
        // Reset so it doesn't keep adding same things every call
        if (layer == 0)
            layers = new HashMap<>();
        // If layer is already present
        if (! this.layers.containsKey(layer) )
            this.layers.put(layer, children);
         else
            this.layers.get(layer).addAll(children);
        // Add children of bottom ones
        for (Node c : children)
            separateTreeIntoLayers(layer + 1, c.getChildren());
    }

    public void organizeTreeNodes(Node root, Node current)
    {
        allNodes.add(current);
        nodeDB.put(current, new NodeInfo(root));
        nodeDB.get(current).setChildren(current.getChildren());

        for (Node c : current.getChildren())
            organizeTreeNodes(current, c);

    }

    public void addGUIItemsToNodes()
    {
        for(Node n : allNodes){
            NodeInfo ni = nodeDB.get(n);
            ni.setNodeCircle(new NodeCircle(n));
        }
    }
    
    public void positionNodeCircles()
    {

        for (int i = 0; i< layers.size(); ++i){
            int lebensraum = layers.get(i).size() * NodeCircle.NODEWIDTH * 2;
            int start = PANEWIDTH / 2 - lebensraum / 2;
            for (int j = 0; j < layers.get(i).size(); ++j){

                Coord tmp = new Coord(start + NodeCircle.NODEWIDTH * 2 * j, 80 + NodeCircle.NODEWIDTH * 2 * i);
                this.getChildren().add(nodeDB.get(layers.get(i).get(j)).getThisGUI());
                nodeDB.get(layers.get(i).get(j)).getThisGUI().setLayoutX(tmp.x);
                nodeDB.get(layers.get(i).get(j)).getThisGUI().setLayoutY(tmp.y);

            }
        }

    }

    public void addGUILinksToNodes()
    {
        for (Node c : allNodes){
            if (c.hasRoot()){
                nodeDB.get(c).setNodeLink(new NodeLink(c.getRoot(), c));
                this.getChildren().add(nodeDB.get(c).getTop());
            }
        }
    }

    public static HashMap<Node, NodeInfo> getNodeDB(){
        return nodeDB;
    }
}
