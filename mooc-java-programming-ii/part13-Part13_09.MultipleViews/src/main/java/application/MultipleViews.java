package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    
    @Override
    public void start(Stage window) {

        BorderPane view1 = new BorderPane();
        Button button1 = new Button("To the second view!");
        view1.setTop(new Label("First view!"));
        view1.setCenter(button1);
        
        VBox view2 = new VBox();
        Button button2 = new Button("To the third view!");
        view2.getChildren().add(button2);
        view2.getChildren().add(new Label("Second view!"));
        
        GridPane view3 = new GridPane();
        Button button3 = new Button("To the first view!");
        view3.add(new Label("Third view!"), 0, 0);
        view3.add(button3, 1,1);
        
        Scene scene1 = new Scene(view1);
        Scene scene2 = new Scene(view2);
        Scene scene3 = new Scene(view3);
        
        button1.setOnAction(e -> {
            window.setScene(scene2);
        });
        
        button2.setOnAction(e -> window.setScene(scene3));
        button3.setOnAction(e -> window.setScene(scene1));
        
        window.setScene(scene1);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
