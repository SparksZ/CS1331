import javafx.scene.layout.Pane;
import javafx.scene.image.Image;

/**
 * This is the Enemy class
 * @author Zack Sparks
 * @version 1.0
 */

public class Enemy extends SpriteBase implements HasHealth, CanStrike {

    private int maxHealth;
    private int hitPoints;
    private int offense;
    private int defense;
    private boolean alive;
    private double speed;
    private int pathSegment;
    private House house;

    /**
     * Constructs a new Enemy object
     * @param layer the Pane that the new Enemy will be added to
     * @param image the Image object that will be the sprite in the game
     * @param x the center x coordinate of the Enemy object
     * @param y the center y coordinate of the Enemy object
     * @param dx the x velocity of the Enemy
     * @param dy the y velocity of the Enemy
     * @param house the house object that is the bane of every enemy's existence
     */
    public Enemy(Pane layer, Image image, double x, double y, double dx,
        double dy, House house) {
        super(layer, image, x, y, dx, dy);
        this.hitPoints = Settings.ENEMY_MAX_HEALTH;
        this.offense = Settings.ENEMY_OFFENSE;
        this.defense = Settings.ENEMY_DEFENSE;
        this.alive = true;
        this.speed = Settings.ENEMY_SPEED;
        this.pathSegment = 1;
        this.house = house;
    }

    /**
     * Deducts hit points from this enemy object
     * @param attackStrength the amount of hit points to be deducted
     */
    public void takeDamage(int attackStrength) {
        hitPoints -= attackStrength;
        if (hitPoints < 0) {
            super.setRemovable(true);
        }
    }

    /**
     * Gives hit points to this enemy object
     * @param healthBack the amount of hit points to be given
     */
    public void replenishHealth(int healthBack) {
        hitPoints = (hitPoints + healthBack <= maxHealth)
            ? hitPoints + healthBack : maxHealth;
    }

    /**
     * Deducts hit points from the House if close enough
     */
    public void strike() {
        if (getDistanceFromHouse() <= 32) {
            house.takeDamage(offense);
        }
    }

    /**
     * @return whether the enemy is still alive or not
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @return this enemy's max health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * @return this enemy's current health
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * @return this enemy's offense rating
     */
    public int getOffense() {
        return offense;
    }

    /**
     * @return this enemy's defense rating
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Sets the enemy's max health
     * @param maxHealth the new max health
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Sets the enemy's current health
     * @param hitPoints the new hitPoints setting
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * Sets the enemy's offense
     * @param offense the new offense
     */
    public void setOffense(int offense) {
        this.offense = offense;
    }

    /**
     * Sets the enemy's defense
     * @param defense the new defense
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Checks this enemy's life state (alive/dead)
     */
    public void checkRemovability() {
        if (hitPoints < 0) {
            alive = false;
        }
    }

    /**
     * @return Whether this Enemy should stay on stage
     */
    public boolean isRemovable() {
        return !alive;
    }

    /**
     * Returns the distance this enemy is from the sprite passed into the method
     * @param sprite the sprite to measure the distance from
     * @return the distance in pixels that the sprite passed is from this enemy
     */
    public double getDistance(SpriteBase sprite) {
        double x = super.getCenterX();
        double y = super.getCenterY();

        double dX1 = sprite.getCenterX() - x;
        double dY1 = sprite.getCenterY() - y;

        return Math.sqrt(dX1 * dX1 + dY1 * dY1);
    }

    /**
     * @return the distance this enemy is from the house
     */
    public double getDistanceFromHouse() {
        double x = super.getCenterX();
        double y = super.getCenterY();

        double dX1 = 1120 - x;
        double dY1 = 223 - y;

        return Math.sqrt(dX1 * dX1 + dY1 * dY1);
    }

    /**
     * Moves the object on frame based on dx and dy
     */
    public void move() {
        super.move();
        checkBounds();
    }

    /**
     * Changes the direction of the enemy based on its position on the map
     */
    public void checkBounds() {
        switch (pathSegment) {
        case 1:
            if (Double.compare(super.getX(), 75) > 0) {
                super.setDX(0);
                super.setDY(-speed);
                pathSegment += 1;
            }
            break;
        case 2:
            if (Double.compare(super.getY(), 83) < 0) {
                super.setDX(speed);
                super.setDY(0);
                pathSegment += 1;
            }
            break;
        case 3:
            if (Double.compare(super.getX(), 269) > 0) {
                super.setDX(0);
                super.setDY(speed);
                pathSegment += 1;
            }
            break;
        case 4:
            if (Double.compare(super.getY(), 701) > 0) {
                super.setDX(speed);
                super.setDY(0);
                pathSegment += 1;
            }
            break;
        case 5:
            if (Double.compare(super.getX(), 350) > 0) {
                super.setDX(0);
                super.setDY(-speed);
                pathSegment += 1;
            }
            break;
        case 6:
            if (Double.compare(super.getY(), 600) < 0) {
                super.setDX(speed);
                super.setDY(0);
                pathSegment += 1;
            }
            break;
        case 7:
            if (Double.compare(super.getX(), 800) > 0) {
                super.setDX(0);
                super.setDY(-speed);
                pathSegment += 1;
            }
            break;
        case 8:
            if (Double.compare(super.getY(), 425) < 0) {
                super.setDX(speed);
                super.setDY(0);
                pathSegment += 1;
            }
            break;
        case 9:
            if (Double.compare(super.getX(), 1115) > 0) {
                super.setDX(0);
                super.setDY(-speed);
                pathSegment += 1;
            }
            break;
        case 10:
            if (Double.compare(super.getY(), 235) < 0) {
                super.setDX(0);
                super.setDY(0);
            }
            break;
        default:
            super.setDX(0);
            super.setDY(0);
        }
    }
}
