package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {
    public static int WIDTH = 600;
    public static int HEIGHT = 400;

    @Override
    public void start(Stage window) throws Exception {
        //create window
        Pane pane = new Pane();
        pane.setPrefSize(600, 400);

        //create and place ship
        Ship ship = new Ship(300, 200);
        pane.getChildren().add(ship.getCharacter());
        
        //create and place asteroids
        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random rdm = new Random();
            Asteroid asteroid = new Asteroid(rdm.nextInt(100), rdm.nextInt(100));
            asteroids.add(asteroid);
        }
        
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));

        //add window to application
        Scene view = new Scene(pane);
        window.setTitle("Asteroids!");
        window.setScene(view);
        window.show();

        //give ship rotation
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        view.setOnKeyPressed(e -> {
            pressedKeys.put(e.getCode(), Boolean.TRUE);
        });
        view.setOnKeyReleased(e -> {
            pressedKeys.put(e.getCode(), Boolean.FALSE);
        });
        
        //allows smoother movement
        new AnimationTimer() {
            
            @Override
            public void handle(long now) {
                //rotation
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                //acceleration
                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }            
                });
            }
        }.start();
    }

    public static void main(String[] args) {
        launch(AsteroidsApplication.class);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 0;
    }

}
