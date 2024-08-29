
public class Apartment {

    private int rooms;
    private int squares;
    private int pricePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }
    
    public boolean largerThan(Apartment compared) {
        if (squares > compared.squares) {
            return true;
        }
        return false;
    }
    
    public int priceDifference(Apartment compared) {
        return Math.abs((squares * pricePerSquare) - (compared.squares * compared.pricePerSquare));
    }
    
    public boolean moreExpensiveThan(Apartment compared){
        if (((squares * pricePerSquare) - (compared.squares * compared.pricePerSquare)) > 0) {
        return true;
    }
        return false;
    }

}
