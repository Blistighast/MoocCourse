
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int highestAge = 0;
        String name = "";

        while (true) {
            String string = scanner.nextLine();
            
            if (string.isEmpty()) {
                break;
            }
            
            
            String[] split = string.split(",");
            if (Integer.valueOf(split[1]) > highestAge) {
                highestAge = Integer.valueOf(split[1]);
                name = split[0];
            }}
        System.out.println("Name of the oldest: " + name);
    }
       
}
