
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        int highestAge = 0;

        while (true) {
            String string = scanner.nextLine();
            
            if (string.isEmpty()) {
                break;
            }
            
            
            String[] split = string.split(",");
            if (Integer.valueOf(split[1]) > highestAge) {
                highestAge = Integer.valueOf(split[1]);
            }
        }
        
        System.out.println("Age of the oldest is " + highestAge);
        
        
    }
}
