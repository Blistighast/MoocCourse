
import java.util.ArrayList;


public class Room {
    private ArrayList<Person> room;
    
    public Room() {
        this.room = new ArrayList<>();
    }
    
    public void add(Person person) {
        room.add(person);
    }
    
    public boolean isEmpty() {
        return room.isEmpty();
    }
    
    public ArrayList<Person> getPersons() {
        return room;
    }
    
    public Person shortest() {
        if (this.isEmpty()) {
            return null;
        }
        Person shortest = room.get(0);
        
        for (Person person: room) {
            if (shortest.getHeight() > person.getHeight()) shortest = person;
        }
        
        return shortest;
    }
    
    public Person take() {
        if (this.isEmpty()) {
            return null;
        }
        
        Person shortest = this.shortest();
        
        room.remove(shortest);
        
        return shortest;
    }
}
