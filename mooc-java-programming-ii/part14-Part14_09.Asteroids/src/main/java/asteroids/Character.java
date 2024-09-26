
package asteroids;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public abstract class Character {
    private Polygon character;
    private Point2D movement;
    private boolean isAlive;
    
    public Character (Polygon polygon, int x, int y) {
        this.character = polygon;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        this.isAlive = true;
        
        this.movement = new Point2D(0, 0);
    }

    public Polygon getCharacter() {
        return character;
    }
    
    public void turnLeft() {
        character.setRotate(character.getRotate() - 5);
    }
    
    public void turnRight() {
        character.setRotate(character.getRotate() + 5);
    }
    
    public void move() {
        character.setTranslateX(character.getTranslateX() + movement.getX());
        character.setTranslateY(character.getTranslateY() + movement.getY());
        
        if (character.getTranslateX() < 0) {
            character.setTranslateX(character.getTranslateX() + AsteroidsApplication.WIDTH);
        }
        if (character.getTranslateX() > AsteroidsApplication.WIDTH) {
            character.setTranslateX(character.getTranslateX() % AsteroidsApplication.WIDTH);
        }
        if (character.getTranslateY() < 0) {
            character.setTranslateY(character.getTranslateY() + AsteroidsApplication.HEIGHT);
        }
        if (character.getTranslateY() > AsteroidsApplication.HEIGHT) {
            character.setTranslateY(character.getTranslateY() % AsteroidsApplication.HEIGHT);
        }
    }

    public void setMovement(Point2D movement) {
        this.movement = movement;
    }

    public Point2D getMovement() {
        return movement;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
   public boolean isAlive() {
       return this.isAlive;
   }
    
    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(character.getRotate()));
        double changeY = Math.sin(Math.toRadians(character.getRotate()));
        
        //slower acceleration
        changeX *= 0.05;
        changeY *= 0.05;
        
        movement = movement.add(changeX, changeY);
    }
    
    public Boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }
}
