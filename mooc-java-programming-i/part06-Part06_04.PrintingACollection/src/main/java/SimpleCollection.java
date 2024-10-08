
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    public String toString() {

        if (elements.isEmpty()) {
            return "The collection " + name + " is empty.";
        }

        String elementInElements = "";

        for (String element : elements) {
            elementInElements = (elements.size() > 1)
                    ? (elementInElements + element + "\n")
                    : (elementInElements + element);
        }

        String multiple = (elements.size() > 1) ? "elements" : "element";

        String header = "The collection " + name + " has " + elements.size()
                + " " + multiple + ":\n";

        return header + elementInElements;
    }

}
