/**
 * This interface is for sprites that can strike another sprite
 * @author Zack Sparks
 * @version 1.0
 */

public interface CanStrike {
    /**
     * Strikes the HasHealth object specified in the construction
     */
    void strike();
    /**
     * @return the offense setting for the CanStrike object
     */
    int getOffense();
    /**
     * Updates the offense setting for this CanStrike object
     * @param offense the new offense setting
     */
    void setOffense(int offense);
}
