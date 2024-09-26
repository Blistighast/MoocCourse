package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {

    public static int WIDTH = 600;
    public static int HEIGHT = 400;

    @Override
    public void start(Stage window) throws Exception {
        //create window
        Pane pane = new Pane();
        pane.setPrefSize(600, 400);

        //create points graphic
        Text pointsText = new Text(10, 20, "Points: 0");
        pane.getChildren().add(pointsText);

        AtomicInteger points = new AtomicInteger();

        //create and place ship
        Ship ship = new Ship(300, 200);
        pane.getChildren().add(ship.getCharacter());

        List<Projectile> projectiles = new ArrayList<>();

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
                //shoot projectile
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile(
                            (int) ship.getCharacter().getTranslateX(),
                            (int) ship.getCharacter().getTranslateY()
                    );
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);

                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    pane.getChildren().add(projectile.getCharacter());
                }

                //creates the actual movement
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());

                //collision with other objects
                //asteroid to ship
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });

                //projectile to asteroid
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setIsAlive(false);
                            asteroid.setIsAlive(false);
                        }
                    });
                    //add points
                    if (!projectile.isAlive()) {
                        pointsText.setText("Points: " + points.addAndGet(1000));
                    }
                });

                projectiles.stream().filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                projectiles.removeAll(projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .collect(Collectors.toList())
                );
                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                asteroids.removeAll(asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .collect(Collectors.toList())
                );
                
                //add more asteroids over time
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        launch(AsteroidsApplication.class);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

}
