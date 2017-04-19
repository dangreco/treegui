package better;

/**
 * Created by dan on 4/17/17.
 */
public class Tests {


    public static void main(String[] args) {
        Tree x = new Tree();
        x.root = new Node(5);
        x.root.addChild(2);
        x.root.addChild(4);
        x.root.addChild(7);
        x.root.getChildren().get(0).addChild(8);

        TreeGUI xG = new TreeGUI(x);



    }


}
