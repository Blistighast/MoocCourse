package ticTacToe;

import javafx.scene.control.Label;

public class Logic {

    private String player;
    private Label turn;
    private GameBoard board;

    public Logic(Label turn, GameBoard board) {
        this.board = board;
        this.player = "X";
        this.turn = turn;
        turn.setText("Turn: " + player);
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Label getTurn() {
        return turn;
    }

    public void setTurn(Label turn) {
        this.turn = turn;
    }
    

    public void changePlayer() {
        if (board.checkWin()) {
            turn.setText("The end!");
            return;
        }
        if (getPlayer().equals("X")) {
            setPlayer("O");
        } else {
            setPlayer("X");
        }
        turn.setText("Turn: " + player);
    }
}
