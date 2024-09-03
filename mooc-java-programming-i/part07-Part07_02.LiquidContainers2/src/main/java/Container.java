
public class Container {

    private int contains;

    public Container() {
        this.contains = 0;
    }

    public int contains() {
        return contains;
    }

    public void add(int amount) {
        if (amount < 0) {
            return;
        }
        if (contains + amount > 100) {
            contains = 100;
        } else {
            contains += amount;
        }
    }

    public void remove(int amount) {
        if (amount < 0) {
            return;
        }
        if (contains - amount < 0) {
            contains = 0;
        } else {
            contains -= amount;
        }
    }
    
    public String toString() {
        return contains+ "/100";
    }
}
