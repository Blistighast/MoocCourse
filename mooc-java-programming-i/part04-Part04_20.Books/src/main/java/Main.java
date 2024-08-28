import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // implement here the program that allows the user to enter 
        // book information and to examine them
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Name: ");
            String name = scanner.nextLine();
            
            if (name.isEmpty()) {
                break;
            }
            
            System.out.println("Pages: ");
            int pages = Integer.valueOf(scanner.nextLine());
            System.out.println("Publication year: ");
            int pubYear = Integer.valueOf(scanner.nextLine());
            
            books.add(new Book(name, pages, pubYear));
        }
        
        System.out.println("What information will be printed?");
        String search = scanner.nextLine();
        
        for (Book book: books) {
            if (search.contains("everything")) {
                System.out.println(book.toString());
            }
            
            if (search.contains("name")) {
                System.out.println(book.getName());
            }
            
        }
        
    }
}
