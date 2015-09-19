import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


/**
 * This is the Projectile that the Turrets shoot
 * @version 1.0
 * @author Zack Sparks
 */
public class Projectile extends SpriteBase implements CanStrike {
    private int offense;
    private double speed;
    private double range;
    private boolean active;
    private Enemy target;
    private double initialX;
    private double initialY;


    /**
     * Constructs a new Projectile object
     * @param layer the Pane that the new Projectile will be added to
     * @param image the Image object that will be the sprite in the game
     * @param x the center x coordinate of the Projectile object
     * @param y the center y coordinate of the Projectile object
     * @param dx the x velocity of the projectile
     * @param dy the y velocity of the projectile
     * @param target the Enemy with which this Projectile has a beef with
     */
    public Projectile(Pane layer, Image image, double x, double y, double dx,
        double dy, Enemy target) {

        super(layer, image, x, y, dx, dy);
        this.offense = Settings.PROJECTILE_OFFENSE;
        this.speed = Settings.PROJECTILE_SPEED;
        this.range = Settings.PROJECTILE_RANGE;
        this.active = true;
        this.target = target;
        this.initialX = x;
        this.initialY = y;
    }

    /**
     * This strikes the target when it is within 32 pixels of it and then
     *  removes the Projectile from the Stage
     */
    public void strike() {
        if (target.getDistance(this) <= 32) {
            target.takeDamage(Settings.PROJECTILE_OFFENSE);
            super.setRemovable(true);
        }
    }

    /**
     * @return the Projectile's offense setting
     */
    public int getOffense() {
        return offense;
    }

    /**
     * Sets a new offense for this Projectile object
     * @param offense the new offense setting for this Projectile
     */
    public void setOffense(int offense) {
        this.offense = offense;
    }

    /**
     * Flags whether or not the Projectile should stay on the stage
     * @param active true if should stay, false if should be removed
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Checks to see if the projectile is out of range
     */
    public void checkRemovability() {
        if (getDistanceFromOrigin() > Settings.PROJECTILE_RANGE) {
            active = false;
        }
    }

    /**
     * @return Whether this projectile should stay on stage
     */
    public boolean isRemovable() {
        return !active;
    }

    /**
     * @return the distance in pixels that the Projectile is from it's start
     */
    public double getDistanceFromOrigin() {

        double dX1 = this.getCenterX() - initialX;
        double dY1 = this.getCenterY() - initialY;

        return Math.sqrt(dX1 * dX1 + dY1 * dY1);
    }
}
