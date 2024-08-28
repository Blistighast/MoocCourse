
public class Book {
    private String name;
    private int pages;
    private int publicationYear;
    
    public Book(String name, int pages, int pubYear) {
        this.name = name;
        this.pages = pages;
        this.publicationYear = pubYear;
    }
    
    public String toString() {
        return name+ ", " +pages+ " pages, " +publicationYear;
    }
    
    public String getName() {
        return name;
    }
}
