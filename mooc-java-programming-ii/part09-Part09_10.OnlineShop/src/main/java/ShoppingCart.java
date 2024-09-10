
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    public void add(String product, int price) {
        if (cart.containsKey(product)) {
            Item updatedProduct = cart.get(product);
            updatedProduct.increaseQuantity();
            cart.put(product, updatedProduct);
        } else {
            cart.put(product, new Item(product, 1, price));
        }
    }
    
    public int price() {
        int totalPrice = 0;
        for (Item item: cart.values()) {
            totalPrice += item.price();
        }
        return totalPrice;
    }
    
    public void print() {
        for (Item item: cart.values()) {
            System.out.println(item);
        }
    }

}
