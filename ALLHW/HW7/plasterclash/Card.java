/**
 * Represents card.
 *
 * @author Zack Sparks
 * @version 1.0
 */
public abstract class Card {
    private final String name;
    private final int keebleCost;
    private final boolean scorable;
    private final String description;
    private final String flavorText;

    /**
     * Constructs a Card object.
     * @param name This is the name of the card
     * @param description this is a description what the card's function is
     * @param flavorText this is some colorful language about the card
     * @param scorable this specifies whether or not the card counts towards
     * this conspiracy meter
     * @param keebleCost how many keebles this card costs in the buy phase
     */
    public Card(String name, String description, String flavorText,
        boolean scorable, int keebleCost) {
        this.name = name;
        this.description = description;
        this.flavorText = flavorText;
        this.scorable = scorable;
        this.keebleCost = keebleCost;
    }

    /**
     * The card class's default play method.  Simply removes the card from the
     * player's hand
     * @param p this is the instance of the PlasterClash game
     */
    public void play(PlasterClash p) {
        p.currentPlayer().getHand().remove(this);
    }

    /**
     * Takes the instance Card and add's a copy to the playZone of PlasterClash
     * @param p this is the instance of the PlasterClash game
     */
    public void playToPlayZone(PlasterClash p) {
        p.getPlayZone().add(this);
    }

    /**
     * @return Whether or not the Card is scoreable
     */
    public boolean isScorable() {
        return this.scorable;
    }

    /**
     * @return the name of the Card instance.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return how much this card costs in keebels.
     */
    public int getCost() {
        return this.keebleCost;
    }

    /**
     * @return the description of the Card.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return the colorful language of the tasty flavor text.
     */
    public String getFlavorText() {
        return this.flavorText;
    }

    /**
     * Card's equals method simply compares the name of the card
     * @return Whether or not the passed object is equal to the instance Card.
     */
    @Override public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }

        Card that = (Card) o;

        return this.name.equals(that.getName());
    }

    /**
     * @return the instance Card's hashCode (based off it's name)
     */
    @Override public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * The string representation of the Card object
     * @return a String containing the name and cost of the card.
     */
    @Override public String toString() {
        return this.name + " (" + this.keebleCost + ")";
    }
}
