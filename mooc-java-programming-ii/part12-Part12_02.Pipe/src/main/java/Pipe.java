
import java.util.ArrayList;


public class Pipe<T> {
    private ArrayList<T> pipe;

    public Pipe() {
        this.pipe = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        pipe.add(value);
    }
    
    public T takeFromPipe() {
        if (pipe.isEmpty()) return null;
        T item = pipe.remove(0);
        return item;
    }
    
    public boolean isInPipe() {
        if (pipe.isEmpty()) return false;
        return true;
    }
}
