package better;


/**
 * Created by dan on 4/24/17.
 */
public class RandomTree extends Tree {

    private int generations;

    public RandomTree()
    {
        super(new Node(0));
        generations = 4;
        fillTree(this.root, 0 );
    }


    public void fillTree(Node root, int generation)
    {
        if (generation > generations)
            return;
        int children = 2;
        for (int i = 0; i < children; ++i){
            root.addChild((int)(Math.random() * 100));
            fillTree(root.getChildren().get(i), generation + 1);
        }
    }

}
