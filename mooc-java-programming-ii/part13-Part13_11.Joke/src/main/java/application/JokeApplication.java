package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {
    
    @Override
    public void start(Stage window) {
        
        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        Button joke = new Button("Joke");
        Button answer = new Button("Answer");
        Button explanation = new Button("Explanation");
        
        StackPane jokePane = createPane("What do you call a bear with no teeth?");
        StackPane answerPane = createPane("A gummy bear.");
        StackPane explanationPane = createPane("Cuz gummy as in gums, get it?");
        
        menu.getChildren().addAll(joke, answer, explanation);
        layout.setTop(menu);
        
        joke.setOnAction(e -> layout.setCenter(jokePane));
        answer.setOnAction(e -> layout.setCenter(answerPane));
        explanation.setOnAction(e -> layout.setCenter(explanationPane));
        
        layout.setCenter(jokePane);
        
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
    
    private StackPane createPane(String text) {
        
        StackPane pane = new StackPane();
        pane.getChildren().add(new Label(text));
        pane.setPrefSize(300, 180);
        pane.setAlignment(Pos.CENTER);
        
        return pane;
    }
}
