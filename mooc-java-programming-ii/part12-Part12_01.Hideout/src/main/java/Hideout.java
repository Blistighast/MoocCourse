
import java.util.ArrayList;


public class Hideout<T> {
    private T item;

    public Hideout() {

    }
    
    public void putIntoHideout(T toHide) {
        item = toHide;
    }
    
    public T takeFromHideout() {
        T taken = item;
        item = null;
        return taken;
    }
    
    public boolean isInHideout() {
        if (item != null) return true; 
        return false;
    }
}
