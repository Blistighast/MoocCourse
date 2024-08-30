
import java.util.ArrayList;


public class Hold {
    private ArrayList<Suitcase> hold; 
    private int maxWeight;

    public Hold(int maxWeight) {
        this.hold = new ArrayList<>();
        this.maxWeight = maxWeight;
    }
    
    public void addSuitcase(Suitcase suitcase) {
         if (totalWeight() + suitcase.totalWeight() <= maxWeight) {
            hold.add(suitcase);
        }
    }

    public int totalWeight() {
        int total = 0;
        
        for (Suitcase suitcase: hold) {
            total += suitcase.totalWeight();
        }
        
        return total;
    }
    
    public void printItems() {
        String itemsInCase = "";
        
        for (Suitcase suitcase: hold) {
            suitcase.printItems();
        }
        
        System.out.println(itemsInCase);
    }
    
    public String toString() {      
        String multiple = (hold.size() > 1) ? "suitcases" : "suitcase"; 

        String format = hold.size() == 0 ? 
                "no suitcases (0 kg)" :
                hold.size()+ " " +multiple+ " (" +totalWeight()+ " kg)\n";

        
        return format;
    }
}
