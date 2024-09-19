package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application{
    
    @Override
    public void start(Stage window) {
        Label instruction = new Label("enter your name and start.");
        TextField input = new TextField("");
        Button button = new Button("Start");
        Label welcome = new Label();
        
        GridPane inputLayout = new GridPane();
        inputLayout.add(instruction, 0, 0);
        inputLayout.add(input, 0, 1);
        inputLayout.add(button, 0, 2);
        
        inputLayout.setPrefSize(300, 180);
        inputLayout.setAlignment(Pos.CENTER);
        inputLayout.setVgap(10);
        inputLayout.setHgap(10);
        inputLayout.setPadding(new Insets(20, 20, 20, 20));
        
        StackPane welcomeLayout = new StackPane();
        welcomeLayout.getChildren().add(welcome);
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.setAlignment(Pos.CENTER);
        
        Scene inputScene = new Scene(inputLayout);
        Scene welcomeScene = new Scene(welcomeLayout);
        
        input.textProperty().addListener((change, oldVal, newVal) -> {
            welcome.setText("Welcome " +newVal+"!");
        });
        
        button.setOnAction(e -> {
            window.setScene(welcomeScene);
                    });
        
        
        window.setScene(inputScene);
        window.show();
        
        
    }


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
