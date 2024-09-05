
import java.util.Scanner;


public class UserInterface {
    private Scanner scan;
    private TodoList list;

    public UserInterface(TodoList list, Scanner scan) {
        this.scan = scan;
        this.list = list;
    }
  
    public void start() {
        while (true) {
            System.out.println("Command: ");
            String command = scan.nextLine();
            
            if (command.equals("stop")) {
                break;
            }
            
            if (command.equals("add")) {
                System.out.println("To add: ");
                String toAdd = scan.nextLine();
                list.add(toAdd);
            }
            
            if (command.equals("list")) {
                list.print();
            }
            
            if (command.equals("remove")) {
                System.out.println("Which one is removed? ");
                int toRemove = Integer.valueOf(scan.nextLine());
                
                list.remove(toRemove);
            }
            
        }
    }
}
