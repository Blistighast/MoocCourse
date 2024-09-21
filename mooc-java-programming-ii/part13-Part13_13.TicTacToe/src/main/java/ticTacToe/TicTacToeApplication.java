package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;


public class TicTacToeApplication extends Application {
    
    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        Label turn = new Label();
        turn.setFont(Font.font(40));
        
        GameBoard board = new GameBoard();
        Logic logic = new Logic(turn, board);
        
        layout.setTop(turn);
        layout.setCenter(board.createGameBoard(logic));
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
