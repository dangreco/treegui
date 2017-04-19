package better;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import static better.TreeGUI.getNodeDB;

/**
 * The GUI Object that connects two NodeCircles together.
 */
public class NodeLink extends Line {


    private Node parent, child;

    public NodeLink(Node parent, Node child)
    {
        super();
        NodeCircle parentTmp = TreeGUI.getNodeDB().get(parent).getThisGUI();
        NodeCircle childTmp = TreeGUI.getNodeDB().get(child).getThisGUI();

        this.setStartX(parentTmp.getLayoutX() + NodeCircle.NODEWIDTH / 2);
        this.setStartY(parentTmp.getLayoutY() + NodeCircle.NODEWIDTH);
        this.setEndX(childTmp.getLayoutX() + NodeCircle.NODEWIDTH / 2);
        this.setEndY(childTmp.getLayoutY());

    }

    public void highlight()
    {
        this.setFill(Color.ORANGE);
        this.setStroke(Color.ORANGE);
    }

    public void unhighlight()
    {
        this.setFill(Color.BLACK);
        this.setStroke(Color.BLACK);
    }


}

