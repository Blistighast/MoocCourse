
import java.util.Scanner;


public class UserInterface {
    private Scanner scan;

    public UserInterface(Scanner scan) {
        this.scan = scan;
    }
    
    public void start() {
        BirdsBase birds = new BirdsBase();
        
        while(true) {
            System.out.println("?");
            String command = scan.nextLine();
            
            if (command.equals("Quit") || command.equals("quit")) {
                break;
            }
            
            if (command.equals("Add") || command.equals("add")) {
                System.out.println("Name: ");
                String name = scan.nextLine();
                System.out.println("Name in Latin: ");
                String latinName = scan.nextLine();
                birds.add(name, latinName);
            }
            
            if (command.equals("Observation") || command.equals("observation")) {
                System.out.println("Bird? ");
                String name = scan.nextLine();
                birds.observe(name);
            }
            
            if (command.equals("All") || command.equals("all")) {
                birds.all();
            }
            
            if (command.equals("One") || command.equals("one")) {
                System.out.println("Bird? ");
                String name = scan.nextLine();
                birds.printOne(name);
            }
            
        }
    }
}
