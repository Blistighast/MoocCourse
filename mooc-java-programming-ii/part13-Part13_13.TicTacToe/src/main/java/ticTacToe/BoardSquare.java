
package ticTacToe;

import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class BoardSquare {
    private Button btn;
    private int col;
    private int row;
    private Boolean clicked;
    private String squareOwner;
    
    

    public BoardSquare(int col, int row, Logic logic) {
        this.btn = new Button(" ");
        btn.setFont(Font.font("Monospaced", 40));
        this.clicked = false;
        this.col = col;
        this.row = row;
        this.btn.setOnAction(e -> {
            if (!clicked) {             
            btn.setText(logic.getPlayer());
            this.squareOwner = logic.getPlayer();
            clicked = true;
            logic.changePlayer();
            }
        });
    }

    public Button getBtn() {
        return btn;
    }

    public String getSquareOwner() {
        return squareOwner;
    }

    public Boolean getClicked() {
        return clicked;
    }
    
    public String getCoord() {
        return Integer.toString(col) + Integer.toString(row);
    }
    
    
}
