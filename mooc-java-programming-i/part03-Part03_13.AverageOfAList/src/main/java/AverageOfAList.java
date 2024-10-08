
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfAList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // implement here a program, that first reads user input
        // adding them on a list until user gives -1.
        ArrayList<Integer> list = new ArrayList();
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) {
                break;
            }
            
            list.add(num);
        }
        
        // Then it computes the average of the numbers on the list
        // and prints it.
        int sum = 0;
        for (int num: list) {
            sum += num;
        }
        
        double avg = (1.0 * sum)/(list.size());
        
        System.out.println("Average: " +avg);
        
    }
}
