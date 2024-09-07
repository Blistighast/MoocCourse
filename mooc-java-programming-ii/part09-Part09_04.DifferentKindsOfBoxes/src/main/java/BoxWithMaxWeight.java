
import java.util.ArrayList;


public class BoxWithMaxWeight extends Box{
    private int capacity;
    private ArrayList<Item> box;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.box = new ArrayList<>();
    }
    
    public int totalWeight() {
        int sum = 0;
        
        for (Item item: box) {
            sum += item.getWeight();
        }
        
        return sum;
    }
    
    @Override
    public void add(Item item) {
        if (totalWeight() + item.getWeight() <= capacity) {
            box.add(item);
        }
    }
    
    @Override
    public boolean isInBox(Item item) {
        return box.contains(item);
    }
}
