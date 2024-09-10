
import java.util.ArrayList;

public class Herd implements Movable{
    private ArrayList<Movable> herd;

    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        herd.add(movable);
    }
    
    public void move(int dx, int dy) {
        for (Movable movable: herd) {
            movable.move(dx, dy);
        }
    }
    
    public String toString() {
        String read = "";
        for (Movable movable: herd) {
             read = read + movable.toString() + "\n";
        }
        return read;
    }
    
    
}
