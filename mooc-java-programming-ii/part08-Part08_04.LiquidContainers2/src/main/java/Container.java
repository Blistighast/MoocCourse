
public class Container {
    public int total;

    public Container() {
        this.total = 0;
    }
    
    public int contains() {
        return total;
    }
    
    public void setTotal(int amount) {
        total = amount;
    }
    
    public void add(int amount) {
        if (amount < 0) {
            return;
        }
        if (total + amount > 100) {
                    total = 100;
                } else {
                    total += amount;
                }
        
    }
    
    public void remove(int amount) {
        if (total - amount < 0) {
                    total = 0;
                } else {
                    total -= amount;
                }
    }
    
    public String toString() {
        return contains() + "/100";
    }
    
}
