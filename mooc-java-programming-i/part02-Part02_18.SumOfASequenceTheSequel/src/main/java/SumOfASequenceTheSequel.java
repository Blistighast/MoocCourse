
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int result = 0;
        
        System.out.println("First number?");
        int first = scanner.nextInt();
        System.out.println("Last number?");
        int last = scanner.nextInt();
        
        for (int i = first; i <=last; i++) {
            result += i;
        }

        System.out.println("the sum is " +result);

    }
}
