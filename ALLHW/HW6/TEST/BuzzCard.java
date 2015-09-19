/**
 * BuzzCard class represents the BuzzCard card payment method it has two
 * attributes: ownerName, balance.
 * @author Zack Sparks
 * @version 1.0
 */
public class BuzzCard extends Card {
    /**
     * Constructs a new BuzzCard with owner name and card balance.
     * @param ownerName the name of the card's owner.
     * @param balance   the balance available to be spent.
     */
    public BuzzCard(String ownerName, double balance) {
        super(ownerName, balance);
    }
}
