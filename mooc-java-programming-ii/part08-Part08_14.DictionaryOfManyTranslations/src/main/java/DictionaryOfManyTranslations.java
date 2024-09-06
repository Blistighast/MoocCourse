
import java.util.ArrayList;
import java.util.HashMap;


public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dictionary;

    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }
    
    public void add(String word, String translation) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, new ArrayList<>());
        }
        
        ArrayList<String> translations = dictionary.get(word);
        translations.add(translation);
    }
    
    public ArrayList<String> translate(String word) {
        return dictionary.getOrDefault(word, new ArrayList<>());
    }
    
    public void remove(String word) {
        dictionary.remove(word);
    }
}
