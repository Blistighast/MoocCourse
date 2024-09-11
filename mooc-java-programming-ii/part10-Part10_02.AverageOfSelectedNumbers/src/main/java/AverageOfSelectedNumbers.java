
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        // Write your program here
        
        while (true) {
            System.out.println("Input numbers, type \"end\" to stop.");
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            
            list.add(input);
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String choice = scanner.nextLine();
        
        if (choice.equals("p")) {
            double posAvg = list.stream()
                    .mapToInt(n -> Integer.valueOf(n))
                    .filter(n -> n >= 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the positive numbers: " +posAvg);
        } else {
            double negAvg = list.stream()
                    .mapToInt(n -> Integer.valueOf(n))
                    .filter(n -> n <= 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: " +negAvg);
        }
    }
}
