
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        int longestNameCount = 0;
        String longestName = "";

        while (true) {
            String string = scanner.nextLine();

            if (string.isEmpty()) {
                break;
            }

            String[] split = string.split(",");
            if (split[0].length() > longestNameCount) {
                longestNameCount = split[0].length();
                longestName = split[0];
            }
            
            sum += Integer.valueOf(split[1]);
            count++;
        }
        
        double average = (1.0 * sum)/count;
        
        System.out.println("Longest name: " +longestName);
        System.out.println("Average of the birth years: " + average);

    }
}
