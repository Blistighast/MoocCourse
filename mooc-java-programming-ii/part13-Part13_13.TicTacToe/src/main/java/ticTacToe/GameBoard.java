package ticTacToe;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class GameBoard {
    private ArrayList<BoardSquare> gameList;
    private int movesLeft;

    public GameBoard() {
        this.gameList = new ArrayList<>();
        this.movesLeft = 9;
    }

    public GridPane createGameBoard(Logic logic) {
        GridPane gameBoard = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                BoardSquare square = new BoardSquare(i, j, logic);
                gameBoard.add(square.getBtn(), i, j);
                gameList.add(square);
            }
        }

        gameBoard.setPadding(new Insets(10));
        gameBoard.setVgap(5);
        gameBoard.setHgap(5);

        return gameBoard;
    }

    public boolean checkWin() {
        if (DiagWin()) return true;
        if (horzWin()) return true;
        if (vertWin()) return true;
        if (outOfMoves()) return true;
        


        return false;
    }

    private boolean DiagWin() {
        ArrayList<String> leftDiag = new ArrayList<>();
        ArrayList<String> rightDiag = new ArrayList<>();

        for (BoardSquare square : gameList) {
            if (square.getCoord().equals("00") || square.getCoord().equals("11") || square.getCoord().equals("22")) {
                leftDiag.add(square.getSquareOwner());
            }
            if (square.getCoord().equals("02") || square.getCoord().equals("11") || square.getCoord().equals("20")) {
                rightDiag.add(square.getSquareOwner());
            }
        }

        if (leftDiag.size() == 3) {
            if (leftDiag.get(0) == leftDiag.get(1) && leftDiag.get(0) == leftDiag.get(2) && leftDiag.get(0) != null) {
                return true;
            }
        }
        if (rightDiag.size() == 3) {
            if (rightDiag.get(0) == rightDiag.get(1) && rightDiag.get(0) == rightDiag.get(2) && rightDiag.get(0) != null) {
                return true;
            }
        }

        return false;
    }
    
    private boolean horzWin() {
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> middle = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        
        for (BoardSquare square: gameList) {
            if (square.getCoord().equals("00") || square.getCoord().equals("10") || square.getCoord().equals("20")) {
                left.add(square.getSquareOwner());
            }
            if (square.getCoord().equals("01") || square.getCoord().equals("11") || square.getCoord().equals("21")) {
                middle.add(square.getSquareOwner());
            }
            if (square.getCoord().equals("02") || square.getCoord().equals("12") || square.getCoord().equals("22")) {
                right.add(square.getSquareOwner());
            }
        }
        
        if (left.size() == 3) {
            if (left.get(0) == left.get(1) && left.get(0) == left.get(2) && left.get(0) != null) {
                return true;
            }
        }
        if (middle.size() == 3) {
            if (middle.get(0) == right.get(1) && middle.get(0) == middle.get(2) && middle.get(0) != null) {
                return true;
            }
        }
        if (right.size() == 3) {
            if (right.get(0) == right.get(1) && right.get(0) == right.get(2) && right.get(0) != null) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean vertWin() {
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> middle = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        
        for (BoardSquare square: gameList) {
            if (square.getCoord().equals("00") || square.getCoord().equals("01") || square.getCoord().equals("02")) {
                left.add(square.getSquareOwner());
            }
            if (square.getCoord().equals("10") || square.getCoord().equals("11") || square.getCoord().equals("12")) {
                middle.add(square.getSquareOwner());
            }
            if (square.getCoord().equals("20") || square.getCoord().equals("21") || square.getCoord().equals("22")) {
                right.add(square.getSquareOwner());
            }
        }
        
        if (left.size() == 3) {
            if (left.get(0) == left.get(1) && left.get(0) == left.get(2) && left.get(0) != null) {
                return true;
            }
        }
        if (middle.size() == 3) {
            if (middle.get(0) == right.get(1) && middle.get(0) == middle.get(2) && middle.get(0) != null) {
                return true;
            }
        }
        if (right.size() == 3) {
            if (right.get(0) == right.get(1) && right.get(0) == right.get(2) && right.get(0) != null) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean outOfMoves() {
        movesLeft--;
        if (movesLeft <= 0) {
            return true;
        }
        
        return false;
    }
}
