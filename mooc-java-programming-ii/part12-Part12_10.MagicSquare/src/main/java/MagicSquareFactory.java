
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        // implement the creation of a magic square with the Siamese method algorithm here
        int totalSquares = square.getHeight() * square.getWidth();
        int row = 0;
        int col = square.getWidth() / 2;

        for (int i = 1; i <= totalSquares; i++) {
//            System.out.println("row: " + row + " col: " + col + " i: " + i);
            square.placeValue(row, col, i);

            int oldRow = row;
            int oldCol = col;

            int check = square.readValue(row - 1, col + 1);
            if (check == -1) {
                if (row - 1 < 0) {
                    row = square.getHeight() - 1;
                } else {
                    row--;
                }
                if (col + 1 > square.getWidth() - 1) {
                    col = 0;
                } else {
                    col++;
                }
                if (square.readValue(row, col) > 0) {
                    row = oldRow;
                    col = oldCol;
                    row++;
                }
            }

            if (check > 0) {
                row = oldRow;
                col = oldCol;
                if (row + 1 > square.getHeight()) {
                    row = 0;
                } else
                row++;
            }

            if (check == 0) {
                row--;
                col++;
            }

        }

        return square;
    }

    public boolean isOccupied(int x, int y, MagicSquare square) {
        return square.readValue(x, y) > 0;
    }

}
