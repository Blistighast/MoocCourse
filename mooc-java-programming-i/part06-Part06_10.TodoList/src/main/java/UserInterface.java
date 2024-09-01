
import java.util.Scanner;


public class UserInterface {
    private TodoList list;
    private Scanner scan;

    public UserInterface(TodoList list, Scanner scan) {
        this.list = list;
        this.scan = scan;
    }
    
    public void start() {
        while (true) {
            System.out.println("Command: ");
            String command = scan.nextLine();
            
            if (command.equals("stop")) {
                break;
            }
            
            if (command.equals("add")) {
                add();
            }
            
            if (command.equals("remove")) {
                remove();
            }
            
            if (command.equals("list")) {
                list.print();
            }  
        }
    }
    
    private void add() {
        System.out.println("To add: ");
        String todo = scan.nextLine();
        
        list.add(todo);
    }
    
    private void remove() {
        System.out.println("Which one is removed?");
        int index = Integer.valueOf(scan.nextLine());
        list.remove(index);
    }
    
}
