
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // implement here a program that reads user input
        // until the user enters 9999
        ArrayList<Integer> list = new ArrayList<>();
        
        while (true) {
            int num = scanner.nextInt();
            
            if (num == 9999) {
                break;
            }
            
            list.add(num);
        }
        
        int smallestValue = list.get(0);
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < smallestValue) {
                smallestValue = list.get(i);
            }
        }
        
        System.out.println("Smallest number: " +smallestValue);
        
        for (int i = 0; i <list.size(); i++) {
           if (list.get(i) == smallestValue) {
               System.out.println("Found at index: " + i);
           }
        }
        
        // after that, the program prints the smallest number
        // and its index -- the smallest number
        // might appear multiple times

        
    }
}
