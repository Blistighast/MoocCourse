
public class HealthStation {
    private int weightCounter;

    public HealthStation() {
        this.weightCounter = 0;
    }


    public int weigh(Person person) {
        weightCounter++;
        return person.getWeight();
    }
    
    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }
    
    public int weighings() {
        return weightCounter;
    }

}
