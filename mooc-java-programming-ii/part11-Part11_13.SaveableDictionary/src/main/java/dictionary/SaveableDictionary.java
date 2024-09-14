package dictionary;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SaveableDictionary {

    private HashMap<String, String> dictionary1;
    private HashMap<String, String> dictionary2;
    private String file;

    public SaveableDictionary() {
        this.dictionary1 = new HashMap<>();
        this.dictionary2 = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.dictionary1 = new HashMap<>();
        this.dictionary2 = new HashMap<>();
        this.file = file;
    }

    public boolean load() {
        List<String> lines = new ArrayList<>();
        try {
            Files.lines(Paths.get(file))
                    .forEach(line -> lines.add(line));
            for (String line : lines) {
                String[] parts = line.split(":");
                dictionary1.putIfAbsent(parts[0], parts[1]);
                dictionary2.putIfAbsent(parts[1], parts[0]);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean save() {
        List<String> toFormat = new ArrayList<>();

        for (String key : dictionary1.keySet()) {
            toFormat.add(key + ":" + dictionary1.get(key));
        }
        try {
            PrintWriter writer = new PrintWriter(file);
            for (String line : toFormat) {
                writer.println(line);
            }
            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public void add(String newWord, String translation) {
        dictionary1.putIfAbsent(newWord, translation);
        dictionary2.putIfAbsent(translation, newWord);
    }

    public String translate(String searchWord) {
        if (dictionary1.containsKey(searchWord)) {
            return dictionary1.get(searchWord);
        }
        if (dictionary2.containsKey(searchWord)) {
            return dictionary2.get(searchWord);
        }
        
        return null;
    }

    public void delete(String removedWord) {
        if (dictionary1.containsKey(removedWord)) {
            dictionary2.remove(dictionary1.get(removedWord));
            dictionary1.remove(removedWord);
            return;
        }
        if (dictionary2.containsKey(removedWord)) {
            dictionary1.remove(dictionary2.get(removedWord));
            dictionary2.remove(removedWord);
        }
    }
}
