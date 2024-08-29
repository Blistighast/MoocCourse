
public class Timer {
    private ClockHand seconds;
    private ClockHand hundreths;
    
    public Timer() {
        this.seconds = new ClockHand(60);
        this.hundreths = new ClockHand(100);
    }
    
    public void advance() {
        hundreths.advance();
        
        if (hundreths.value() == 0) {
            seconds.advance();
        }
    }
    
    public String toString() {
        return seconds+ ":" +hundreths;
    }
}
