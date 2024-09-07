
import java.util.ArrayList;


public class ChangeHistory {
    private ArrayList<Double> list;

    public ChangeHistory() {
        this.list = new ArrayList<>();
    }
    
    public void add(double status) {
        list.add(status);
    }
    
    public void clear() {
        list.clear();
    }
    
    public double maxValue() {
        double max = 0.0;
        
        for (double value: list) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    
    public double minValue() {
        double min = Double.MAX_VALUE;
        if (list.isEmpty()) {
            return 0.0;
        }
        for (double value: list) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
    
    public double average() {
        double sum = 0.0;
        int count = 0;
        
        for (double value: list) {
            sum += value;
            count++;
        }
        
        return sum / count;
    }
    
    @Override
    public String toString() {
        return list.toString();
    }
}
