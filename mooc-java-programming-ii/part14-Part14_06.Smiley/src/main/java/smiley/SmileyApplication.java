package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {
    
    @Override
    public void start(Stage window) {
        //create layout
        Canvas canvas = new Canvas(640, 480);
        GraphicsContext painter = canvas.getGraphicsContext2D();
        
        BorderPane layout = new BorderPane();
        layout.setCenter(canvas);

        
        painter.setFill(Color.BLACK);
        painter.fillRect(180, 100, 50, 50);
        painter.fillRect(360, 100, 50, 50);
        painter.fillRect(130, 250, 50, 50);
        painter.fillRect(420, 250, 50, 50);
        painter.fillRect(180, 300, 240, 50);
        
        
        //display window
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
