/**
 * This interface is for sprites that have health
 * @author Zack Sparks
 * @version 1.0
 */

public interface HasHealth {

    /**
     * Deducts hit points from this HasHealth object
     * @param strikeAgainst the amount of hit points to be deducted
     */
    void takeDamage(int strikeAgainst);

    /**
     * Gives hit points to this HasHealth object
     * @param healthBack the amount of hit points to be given
     */
    void replenishHealth(int healthBack);

    /**
     * @return whether the HasHealth object is still alive or not
     */
    boolean isAlive();

    /**
     * @return this HasHealth object's max health
     */
    int getMaxHealth();

    /**
     * @return this HasHealth's current health
     */
    int getHitPoints();

    /**
     * @return this HasHealth's defense rating
     */
    int getDefense();

    /**
     * Sets the HasHealth's max health
     * @param maxHealth the new max health
     */
    void setMaxHealth(int maxHealth);

    /**
     * Sets the HasHealth's current health
     * @param hitPoints the new hitPoints setting
     */
    void setHitPoints(int hitPoints);

    /**
     * Sets the HasHealth's defense
     * @param defense the new defense
     */
    void setDefense(int defense);
}
