package better;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * The GUI representation of a Node. For the actual Node, see class Node.
 */

public class NodeCircle extends StackPane {

    private static NodeCircle selectedNode;
    public static int NODEWIDTH = 80;
    private Circle casing;
    private Text value;
    private Node me;

    public NodeCircle(Node me)
    {
        super();

        // GUI Objects set up

        casing = new Circle();
        casing.setFill(Color.WHITE);
        casing.setStroke(Color.BLACK);
        casing.setStrokeWidth(2.0);
        casing.setRadius(NODEWIDTH/2);
        this.me = me;
        this.value = new Text();
        this.value.setText(Double.toString(me.val));

        this.getChildren().addAll(casing, this.value);

        // Event Handlers

        this.setOnMouseEntered(mouseEvent ->{
            TreeGUI.highlightNodePath(me);
        });

        // TODO: Create selected NodeGUI persistence

        this.setOnMouseExited(mouseEvent -> {
            if (this != NodeCircle.getSelectedNode())
                TreeGUI.unhighlightNodePath(me);
        });

    }

    public void highlight()
    {
        this.casing.setFill(Color.ORANGE);
    }

    public void unhighlight()
    {
        this.casing.setFill(Color.WHITE);
    }

    public static NodeCircle getSelectedNode() { return selectedNode; }


}
