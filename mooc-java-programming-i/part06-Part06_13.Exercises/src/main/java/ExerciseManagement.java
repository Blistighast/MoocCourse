
import java.util.ArrayList;

public class ExerciseManagement {

    private ArrayList<Exercise> exercises;

    public ExerciseManagement() {
        this.exercises = new ArrayList<>();
    }

    public ArrayList<String> exerciseList() {
        ArrayList<String> list = new ArrayList<>();
        for (Exercise exercise: exercises) {
            list.add(exercise.getName());
        }
        return list;
    }

    public void add(String exercise) {
        this.exercises.add(new Exercise(exercise));
    }
    
    public void markAsCompleted(String completedExercise) {
        for (Exercise exercise: exercises) {
            if (exercise.getName().equals(completedExercise)) {
                exercise.setCompleted(true);
            }
        }
        
    }
    
    public boolean isCompleted(String checkExercise) {
        for (Exercise exercise: exercises) {
            if (exercise.getName().equals(checkExercise)) {
                return exercise.isCompleted();
            }
        }
        
        return false;
    }
}
