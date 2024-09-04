import java.util.ArrayList;

public class BirdsBase {
    private ArrayList<Bird> birds;

    public BirdsBase() {
        this.birds = new ArrayList<>();
    }
    
    public void add(String name, String latinName) {
        birds.add(new Bird(name, latinName));
    }
    
    public void observe(String name) {
        for (Bird bird: birds) {
            if (bird.getName().equals(name) || bird.getLatinName().equals(name)) {
                bird.observed();
            }
        }
    }
    
    public void all() {
        for (Bird bird: birds) {
            System.out.println(bird.toString());
        }
    }
    
    public void printOne(String name) {
        for (Bird bird: birds) {
            if (bird.getName().equals(name) || bird.getLatinName().equals(name)) {
                System.out.println(bird.toString());
            } else {
                System.out.println("Not a bird!");
            }
        }
    }
    
    
}
