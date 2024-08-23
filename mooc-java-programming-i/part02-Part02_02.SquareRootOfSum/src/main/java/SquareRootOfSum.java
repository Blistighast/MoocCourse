
import java.util.Scanner;

public class SquareRootOfSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        
        double sqrt = Math.sqrt((number1 + number2));
        
        System.out.println(sqrt);
        
        
    }
}
