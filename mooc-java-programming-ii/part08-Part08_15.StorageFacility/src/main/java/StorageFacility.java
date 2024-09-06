
import java.util.HashMap;
import java.util.ArrayList;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> facility;

    public StorageFacility() {
        this.facility = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        if (!facility.containsKey(unit)) {
            facility.put(unit, new ArrayList<>());
        }
        
        ArrayList<String> contents = facility.get(unit);
        contents.add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        return facility.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String unit, String item) {
        ArrayList<String> contents = facility.get(unit);
        contents.remove(item);
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> nonEmptyUnits = new ArrayList<>();
        
        for (String unit: facility.keySet()) {
            ArrayList<String> contents = facility.get(unit);
            if (!contents.isEmpty()) {
                nonEmptyUnits.add(unit);
            }
        }
        
        return nonEmptyUnits;
    }
    
}
