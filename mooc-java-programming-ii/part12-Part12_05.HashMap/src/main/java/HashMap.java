
import java.util.ArrayList;


public class HashMap<K, V> {
    private ArrayList<ArrayList<Pair<K, V>>> values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new ArrayList<>();
        this.firstFreeIndex = 0;
    }

    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % values.size());
        if (values.get(hashValue) == null) {
            return null;
        }
        
        ArrayList<Pair<K, V>> valuesAtIndex = values.get(hashValue);
        
        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.get(i).getKey().equals(key)) {
                return valuesAtIndex.get(i).getValue();
            }
        }
        
        return null;
    }
    
    public void add(K key, V value) {
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        
        int index = getIndexOfKey(valuesAtIndex, key);
        
        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }
    }
    
    public V remove(K key) {
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }
        
        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }
        
        Pair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }
    
    private ArrayList<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % values.size());
        if (values.get(hashValue).isEmpty()) {
            values.add(hashValue, new ArrayList<>());
        }
        
        return values.get(hashValue);
    }
    
    private int getIndexOfKey(ArrayList<Pair<K, V>> myList, K key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }
}


