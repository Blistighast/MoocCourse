
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Statistics statSum = new Statistics();
        Statistics statEven = new Statistics();
        Statistics statOdd = new Statistics();
        
        // you can write test code here
        // however, remove all unnecessary code when doing the final parts of the exercise

        // In order for the tests to work, the objects must be created in the
        // correct order in the main program. First the object that tracks the total
        // sum, secondly the object that tracks the sum of even numbers, 
        // and lastly the one that tracks the sum of odd numbers!
        System.out.println("Enter numbers: ");
        
        while (true) {
            int number = scanner.nextInt();
            if (number == -1) {
                break;
            }
            
            statSum.addNumber(number);
            
            if (number % 2 == 0) {
                statEven.addNumber(number);
            } else {
                statOdd.addNumber(number);
            }
        }
        
        System.out.println("Sum: " +statSum.sum());
        System.out.println("Sum of even numbers: " +statEven.sum());
        System.out.println("Sum of odd numbers: " +statOdd.sum());
    }
}
