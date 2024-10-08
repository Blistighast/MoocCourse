package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


// END SOLUTION
public class VocabularyPracticeApplication extends Application {
    
    private Dictionary dictionary;
    
    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }
    
    @Override
    public void start(Stage window) throws Exception {
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);
        
        BorderPane layout = new BorderPane();
        
        HBox menu = new HBox();
        Button inputButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");
        
        //formating
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        menu.getChildren().addAll(inputButton, practiceButton);
        layout.setTop(menu);
        
        inputButton.setOnAction(e -> layout.setCenter(inputView.getView()));
        practiceButton.setOnAction(e -> layout.setCenter(practiceView.getView()));
        
        layout.setCenter(inputView.getView());
        
        Scene view = new Scene(layout, 400, 300);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
