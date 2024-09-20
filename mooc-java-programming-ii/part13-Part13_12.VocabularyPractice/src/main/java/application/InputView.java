
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
    private Dictionary dictionary;

    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    
    public Parent getView() {
        GridPane layout = new GridPane();
        Label wordInstruction = new Label("Word");
        TextField wordField = new TextField();
        Label translateInstruction = new Label("Translation");
        TextField translationField = new TextField();
        Button submit = new Button("Add a word pair");
        
        //formatting
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10));
        
        layout.add(wordInstruction, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(translateInstruction, 0, 2);
        layout.add(translationField, 0, 3);
        layout.add(submit, 0, 4);
        
        submit.setOnAction(e -> {
            String word = wordField.getText();
            String translation = translationField.getText();
            
            dictionary.add(word, translation);
            
            wordField.clear();
            translationField.clear();
        });

        return layout;
    }

}
