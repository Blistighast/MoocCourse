
public class List<T> {
    private T[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }
    
    private void grow() {
        int newSize = values.length + values.length / 2;
        T[] newValues = (T[]) new Object[newSize];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }
    
    public void add(T value) {
        if (firstFreeIndex == values.length) grow();
        
        values[firstFreeIndex] = value;
        firstFreeIndex++;
    }
    
    public boolean contains(T value) {
        return indexOfValue(value) >= 0;
    }
    
    public int indexOfValue(T value) {
        for (int i = 0; i < firstFreeIndex; i++) {
            if (values[i].equals(value)) return i;
        }
        return -1;
    }
    
    private void moveToLeft(int fromIndex) {
        for (int i = fromIndex; i < firstFreeIndex; i++) {
            values[i] = values[i + 1];
        }
    }
    
    public void remove(T value) {
        int indexOfValue = indexOfValue(value);
        for (int i = 0; i < firstFreeIndex; i++) {
            if (indexOfValue < 0) {
                return;
            } 
            moveToLeft(indexOfValue);
            firstFreeIndex--;
        }
    }
    
    
}
