package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        Label letters = new Label("Letters: 0" );
        Label words = new Label("Words: 0");
        Label longest = new Label("The longest word is: ");
        TextArea text = new TextArea("");

        layout.setCenter(text);
        
        text.textProperty().addListener((change, oldVal, newVal) -> {
            letters.setText("Letters: " +newVal.length());
            String[] parts = newVal.split(" ");
            words.setText("Words: " +parts.length);
            String longestWord = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            longest.setText("The longest word is: " +longestWord);
        });

        HBox bottomText = new HBox();
        bottomText.setSpacing(10);
        bottomText.getChildren().add(letters);
        bottomText.getChildren().add(words);
        bottomText.getChildren().add(longest);

        layout.setBottom(bottomText);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
