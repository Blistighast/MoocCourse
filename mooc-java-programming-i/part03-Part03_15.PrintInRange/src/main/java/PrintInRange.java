
import java.util.ArrayList;

public class PrintInRange {

    public static void main(String[] args) {
        // Try your method here
    }
    
    public static void printNumbersInRange(ArrayList<Integer> numbers, int lowerLimit, int upperLimit) {
        
        for (int value: numbers) {
            if (value >= lowerLimit && value <= upperLimit) {
                System.out.println(value);
            }
        }
    }
    
}
