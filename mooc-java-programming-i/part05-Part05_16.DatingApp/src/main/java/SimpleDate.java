
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
    
    public void advance() {
        advance(1);
    }
    
    public void advance(int howManyDays) {
        if (day + howManyDays > 30 && month == 12) {
            year++;
            day = (day + howManyDays) - 30;
            month = 1;
        } else if (day + howManyDays > 30) {
            day = (day + howManyDays) - 30;
            month++;
        } else {
            day += howManyDays;
        }
    }
    
    public SimpleDate afterNumberOfDays(int days){
        int newYear = year;
        int newMonth = month; 
        int newDay = day;
        
        if (day + days > 30 && month == 12) {
            newYear++;
            newDay = (day + days) - 30;
            newMonth = 1;
        } else if (day + days > 30) {
            newDay = (day + days) - 30;
            newMonth++;
        } else {
            newDay += days;
        }
        
        
        return new SimpleDate(newDay, newMonth, newYear);
    }

    public boolean before(SimpleDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month &&
                 this.day < compared.day) {
            return true;
        }

        return false;
    }

}
