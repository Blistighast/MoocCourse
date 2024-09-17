
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        Random random = new Random();
        // the method containsNumber is probably useful
        int amount = 0;
        while (amount < 7) {
            int randomNum = random.nextInt(40) + 1;
            if (containsNumber(randomNum)) continue;
            numbers.add(randomNum);
            amount++;
        }
    }

    public boolean containsNumber(int newNumber) {
        // Check here whether the number is among the drawn numbers
        for (int number: numbers) {
            if (newNumber == number) return true;
        }
        return false;
    }
}

