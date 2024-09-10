
import java.util.ArrayList;


public class Box implements Packable{
    private double maxWeight;
    private ArrayList<Packable> box;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.box = new ArrayList<>();
    }
    
    public void add(Packable packable) {
        if (weight() + packable.weight() <= maxWeight) {
            box.add(packable);
        }
    }
    
    public double weight() {
        double weight = 0;
        for (Packable packable: box) {
            weight += packable.weight();
        }
        
        return weight;
    }
    
    public String toString() {
        return "Box: " +box.size()+ " items, total weight " +weight()+ " kg";
    }
    
}
