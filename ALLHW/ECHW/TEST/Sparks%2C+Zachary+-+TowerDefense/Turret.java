import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * This class represents the Turret objects
 * @version 1.0
 * @author Zack Sparks
 */
public class Turret extends SpriteBase {
    private int offense;
    private boolean active;

    /**
     * Constructs a new Turret object
     * @param layer the Pane that the new Turret will be added to
     * @param image the Image object that will be the sprite in the game
     * @param x the center x coordinate of the Turret object
     * @param y the center y coordinate of the Turret object
     */
    public Turret(Pane layer, Image image, double x, double y) {
        super(layer, image, x, y, 0, 0);
        this.offense = Settings.TURRET_OFFENSE;
        this.active = true;
    }

    /**
     * Shoots (creates a new) Projectile object aimed at the closest Enemy of
     *  of this Turret object
     * @param layer the Pane object that the new Projectile will be added to
     * @param image the Image object that will be the sprite in the game
     * @param enemies an ArrayList of enemies in the game (finds closest and
     *  and aims at it)
     * @return a new Projectile object aimed at the closest enemy
     */
    public Projectile shoot(Pane layer, Image image, ArrayList<Enemy> enemies) {

        Enemy target = closestEnemy(enemies);

        double deltaX = Math.abs(target.getCenterX() - this.getCenterX());
        double deltaY = Math.abs(target.getCenterY() - this.getCenterY());
        double theta = Math.atan(deltaY / deltaX);
        double dx = Math.signum(target.getCenterX() - this.getCenterX())
            * Settings.PROJECTILE_SPEED * Math.cos(theta);
        double dy = Math.signum(target.getCenterY() - this.getCenterY())
            * Settings.PROJECTILE_SPEED * Math.sin(theta);

        Projectile bomb = new Projectile(layer,
            image,
            super.getCenterX() - image.getWidth() * 0.5,
            super.getCenterY() - image.getHeight() * 0.5,
            dx,
            dy,
            target);

        return bomb;
    }

    /**
     * Can't remove turrets at this point, but should implement later
     */
    public void checkRemovability() {
    }

    /**
     * @return Whether this Turret should stay on stage
     */
    public boolean isRemovable() {
        return !active;
    }

    /**
     * This finds the closest enemy to this Turret
     * @param enemies the list of enemies on the stage
     * @return the closest Enemy object to this Turret
     */
    private Enemy closestEnemy(ArrayList<Enemy> enemies) {
        int closest = 0;
        double x = super.getCenterX();
        double y = super.getCenterY();

        double dX1 = enemies.get(closest).getCenterX() - x;
        double dY1 = enemies.get(closest).getCenterY() - y;
        double shortest = Math.sqrt(dX1 * dX1 + dY1 * dY1);

        int count = 0;
        for (Enemy e : enemies) {
            double dX = e.getCenterX() - x;
            double dY = e.getCenterY() - y;
            double d = Math.sqrt(dX * dX + dY * dY);

            if (d < shortest) {
                closest = count;
            }

            count++;
        }

        return enemies.get(closest);
    }
}
