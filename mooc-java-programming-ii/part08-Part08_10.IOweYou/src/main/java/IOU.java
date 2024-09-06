
import java.util.HashMap;


public class IOU {
    private HashMap<String, Double> map;

    public IOU() {
        this.map = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        double sum = map.getOrDefault(toWhom, 0.0);
        sum += amount;
        map.put(toWhom, sum);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return map.getOrDefault(toWhom, 0.0);
    }
    
    
}
