public class Checker {
    public boolean isDayOfWeek(String string) {
        String regex = "mon|tue|wed|thu|fri|sat|sun";
        return string.matches(regex);
    }
    
    public boolean allVowels(String string) {
        String regex = "(a|e|i|o|u)*";
        return string.matches(regex);
    }
    
    public boolean timeOfDay(String string) {
        String regexFormat = "[0-2][0-9]:[0-5][0-9]:[0-5][0-9]";
        if (string.matches("^[3-9]")) {
            return false;
        } else if (string.matches("^2[5-9]")) {
            return false;
        } else if (string.matches("24:[^0][^0]:[^0][^0]")){
            return false;
        } else if (string.matches(regexFormat)) {
            return true;
        } else {
            return false;
        }
        
    }
}
