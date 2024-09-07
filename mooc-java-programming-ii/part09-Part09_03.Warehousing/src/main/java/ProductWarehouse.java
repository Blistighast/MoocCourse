
public class ProductWarehouse extends Warehouse{
    private String name;

    public ProductWarehouse(String name, double capacity) {
        super(capacity);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    @Override
    public String toString() {
        return name + ": " + super.toString();
    }
}
