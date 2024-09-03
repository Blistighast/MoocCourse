
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;

        while (true) {

            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] inputParts = input.split(" ");
            String command = inputParts[0];
            int amount = Integer.valueOf(inputParts[1]);

            if (command.equals("add")) {
                if (amount < 0) {
                    continue;
                }

                if (first + amount > 100) {
                    System.out.println("over 100");
                    first = 100;
                } else {
                    System.out.println("adding amount");
                    first += amount;
                    System.out.println(first);
                }
            }
            
            if (command.equals("move")) {
                if (first - amount < 0) {
                    if (second + first > 100) {
                        second = 100;
                    } else {
                        second += first;
                    }
                    first = 0;
                } else {
                    if (second + amount > 100) {
                        second = 100;
                    } else {
                        second += amount;
                    }
                    first -= amount;
                }
            }
            
            if (command.equals("remove")) {
                if (second - amount < 0) {
                    second = 0;
                } else {
                    second -= amount;
                }
            }

        }
    }

}
