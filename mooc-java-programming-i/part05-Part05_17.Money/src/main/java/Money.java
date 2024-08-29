
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }
    
    public Money plus(Money addition) {
        int newEuros = 0;
        int newCents = 0;
        
        if (cents + addition.cents() > 99) {
            newEuros = euros +addition.euros() + (cents + addition.cents()) / 100;
            newCents = (cents + addition.cents()) % 100;
        } else {
            newEuros = euros +addition.euros();
            newCents = (cents + addition.cents());
        }
        
        return new Money(newEuros, newCents);
    }
    
    public boolean lessThan(Money compared) {
        if (euros == compared.euros() && cents < compared.cents()) {
            return true;
        } else if (euros < compared.euros()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Money minus(Money decreaser){
        int newEuros = 0;
        int newCents = 0;
        
        if (cents - decreaser.cents() < 0) {
            newEuros = euros - decreaser.euros() - 1;
            newCents = 100 + cents - decreaser.cents();
        } else {
            newEuros = euros - decreaser.euros();
            newCents = (cents - decreaser.cents());
        }
        
        if (newEuros < 0) {
            newEuros = 0;
            newCents = 0;
        }
        
        return new Money(newEuros, newCents);
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

}
