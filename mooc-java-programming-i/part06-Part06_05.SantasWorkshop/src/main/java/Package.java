import java.util.ArrayList;

public class Package {
    private ArrayList<Gift> packageList;

    public Package() {
        this.packageList = new ArrayList<>();
    }
    
    public void addGift(Gift gift) {
        packageList.add(gift);
    }
    
    public int totalWeight() {
        int total = 0;
        
        for (Gift gift: packageList) {
            total += gift.getWeight();
        }
        
        return total;
    }
    
    
}
