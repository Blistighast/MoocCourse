
import java.util.HashMap;

public class Abbreviations {

    HashMap<String, String> map;

    public Abbreviations() {
        this.map = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        if (!hasAbbreviation(abbreviation)) {
            map.put(abbreviation, explanation);
        }
    }

    public boolean hasAbbreviation(String abbreviation) {
        return map.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation) {
        return map.get(abbreviation);
    }

}
