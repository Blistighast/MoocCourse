
import java.util.ArrayList;
import java.util.Collections;


public class Hand implements Comparable<Hand>{
    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }
    
    public void add(Card card) {
        hand.add(card);
    }
    
    public void sort() {
        Collections.sort(hand);
    }
    
    public void sortBySuit() {
        Collections.sort(hand, new BySuitInValueOrder());
    }
    
    public void print() {
        hand.stream()
                .forEach(card -> System.out.println(card));
    }
    
    public int handTotalValue() {
        int sum = hand.stream()
                .map(card -> card.getValue())
                .reduce(0, (prev, value) -> prev + value);
        return sum;
    }
    
    public int compareTo(Hand compHand) {
        return this.handTotalValue() - compHand.handTotalValue();
    }
    
}
