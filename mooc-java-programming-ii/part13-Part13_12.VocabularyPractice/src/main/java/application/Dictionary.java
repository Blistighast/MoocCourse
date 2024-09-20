
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Dictionary {
    private ArrayList<String> words;
    private HashMap<String, String> translations;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();
        
        add("sana", "word");
    }
    
    public String get(String word) {
        return translations.get(word);
    }
    
    public void add(String word, String translation) {
        if (!translations.containsKey(word)) {
            words.add(word);
        }
        
        translations.put(word, translation);
    }

    public String getRandomWord() {
        Random random = new Random();
        
        return words.get(random.nextInt(words.size()));
    }
    
    
}
