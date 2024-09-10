
public class CD implements Packable{
    private String artist;
    private String name;
    private int publication;
    private double weight;

    public CD(String artist, String name, int publication) {
        this.artist = artist;
        this.name = name;
        this.publication = publication;
        this.weight = 0.1;
    }



    public double weight() {
        return weight;
    }
    
    @Override
    public String toString() {
        return artist+ ": " +name+ " (" +publication+ ")";
    }
}
