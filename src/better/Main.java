package better;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private Tree main;
    private TreeGUI mainGUI;
    private double orgX, orgY, mouseOrgX, mouseOrgY;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        main = new Tree();
        // SAMPLE TREE:

        main.root = new Node(5);
        main.root.addChild(2);
        main.root.addChild(4);
        main.root.addChild(7);
        main.root.getChildren().get(0).addChild(8);
        main.root.getChildren().get(2).addChild(10);
        main.root.getChildren().get(0).getChildren().get(0).addChild(11);
        main.root.getChildren().get(0).getChildren().get(0).addChild(17);
        main.root.getChildren().get(0).getChildren().get(0).addChild(6);

        mainGUI = new TreeGUI(main);

        Scene mainScene = new Scene(mainGUI, TreeGUI.PANEWIDTH, TreeGUI.PANEHEIGHT);
        mainScene.setFill(Color.GRAY);

        mainScene.setOnMousePressed(mouseEvent -> {
            orgX = mainGUI.getLayoutX();
            orgY = mainGUI.getLayoutY();
            mouseOrgX = mouseEvent.getX();
            mouseOrgY = mouseEvent.getY();
            mainScene.setCursor(Cursor.CLOSED_HAND);
        });

        mainScene.setOnMouseReleased(mouseEvent -> mainScene.setCursor(Cursor.DEFAULT));

        mainScene.setOnMouseDragged(mouseDragEvent -> {
            double transformedX = orgX - (mouseOrgX - mouseDragEvent.getX());
            double transformedY = orgY - (mouseOrgY - mouseDragEvent.getY());
            mainGUI.setLayoutX(transformedX);
            mainGUI.setLayoutY(transformedY);
        });

        mainScene.setOnScroll(scrollEvent -> {

            int delta = (int)scrollEvent.getDeltaY() / 40;
            mainGUI.setScaleX(mainGUI.getScaleX() + (delta * .2));
            mainGUI.setScaleY(mainGUI.getScaleY() + (delta * .2));

        });

        primaryStage.setScene(mainScene);
        primaryStage.show();

    }
}
