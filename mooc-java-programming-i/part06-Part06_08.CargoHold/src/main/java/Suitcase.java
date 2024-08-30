
import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Item> suitcase;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.suitcase = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public void addItem(Item item) {
        if (totalWeight() + item.getWeight() <= maxWeight) {
            suitcase.add(item);
        }
    }

    public int totalWeight() {
        int total = 0;
        
        for (Item item: suitcase) {
            total += item.getWeight();
        }
        
        return total;
    }
    
    public Item heaviestItem() {
        if (suitcase.size() == 0) {
            return null;
        }
        
        Item heaviest = suitcase.get(0);
        
        for (Item item: suitcase) {
            if (heaviest.getWeight() < item.getWeight()) heaviest = item;
        }
        
        return heaviest;
    }
    
    public void printItems() {
        String itemsInCase = "";
        
        for (Item item: suitcase) {
            itemsInCase = itemsInCase + item.getName()+ " (" +item.getWeight()+ " kg)\n";
        }
        
        System.out.println(itemsInCase);
    }
    
    public String toString() {      
        String multiple = (suitcase.size() > 1) ? "items" : "item"; 

        String format = suitcase.size() == 0 ? 
                "no items (0 kg)" :
                suitcase.size()+ " " +multiple+ " (" +totalWeight()+ " kg)\n";

        
        return format;
    }
}
