/**
 * This class represents the House that is the bane of every enemy's existence
 * @author Zack Sparks
 * @version 1.0
 */
public class House implements HasHealth {
    private int maxHealth;
    private int hitPoints;
    private boolean lifeForce;
    private int defense;
    private boolean alive;

    /**
     * Constructs a new house object
     */
    public House() {
        this.maxHealth = Settings.HOUSE_MAX_HEALTH;
        this.defense = Settings.HOUSE_DEFENSE;
        this.hitPoints = maxHealth;
        this.alive = true;
    }

    /**
     * Deducts hit points from this House object
     * @param attackStrength the amount of hit points to be deducted
     */
    public void takeDamage(int attackStrength) {
        hitPoints -= attackStrength;
        alive = hitPoints >= 0;
    }

    /**
     * Gives hit points to this House object
     * @param healthBack the amount of hit points to be given
     */
    public void replenishHealth(int healthBack) {
        hitPoints = (hitPoints + healthBack <= maxHealth)
            ? hitPoints + healthBack : maxHealth;
    }

    /**
     * @return whether the House object is still alive or not
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @return this House's max health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * @return this House's current health
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * @return this House's current defense setting
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Sets the House's max health
     * @param maxHealth the new max health
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Sets the House's current health
     * @param hitPoints the new hitPoints setting
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * Sets the House's defense
     * @param defense the new defense
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }
}
