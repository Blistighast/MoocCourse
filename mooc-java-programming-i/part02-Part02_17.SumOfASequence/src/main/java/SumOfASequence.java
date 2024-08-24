
import java.util.Scanner;

public class SumOfASequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Last number?");
        
        int result = 0;
        int num = scanner.nextInt();
        
        for (int i = 1; i <=num; i++) {
            result += i;
        }

        System.out.println("the sum is " +result);
    }
}
