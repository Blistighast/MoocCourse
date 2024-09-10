
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Warehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Warehouse() {
        this.prices = new HashMap<>();
        this.stocks = new HashMap<>();
    }
    
    public void addProduct(String name, int price, int stock) {
        prices.put(name, price);
        stocks.put(name, stock);
    }
    
    public int price(String findProduct) {
        for (String product: prices.keySet()) {
            if (product.equals(findProduct)) {
                return prices.get(product);
            }
        }
        return -99;
    }
    
    public int stock(String findProduct) {
        for (String product: stocks.keySet()) {
            if (product.equals(findProduct)) {
                return stocks.get(product);
            }
        }
        return 0;
    }
    
    public boolean take(String findProduct) {
        for (String product: stocks.keySet()) {
            if (product.equals(findProduct) && stocks.get(product) > 0) {
                    stocks.put(product, stocks.get(product) - 1);
                    return true;
            }
        }
        return false;
    }
    
    public Set<String> products() {
        Set<String> list = new HashSet<>();
        for (String product: prices.keySet()) {
            list.add(product);
        }
        return list;
    }
    
    public String toString() {
        String read = "";
        for (String product: prices.keySet()) {
            read = read + (product+ ": " +prices.get(product) +"\n");
        }
        
        return read;
    }
    
}
