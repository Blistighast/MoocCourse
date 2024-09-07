
public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, Double initialBalance) {
        super(productName, capacity);
        this.history = new ChangeHistory();
        this.history.add(initialBalance);
    }

    public String history() {
        return history.toString();
    }
    
    
}
