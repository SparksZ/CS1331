/**
 * Represents the gnome card.
 *
 * @author Zack Sparks
 * @version 1.0
 */
public class Gnome extends Card {
    /**
     * Constructs a Gnome Object. It is scorable.
     */
    public Gnome() {
        super("Gnome", "Worth a Victory Point! Makes other players discard a"
            + " random card", "Smarmy little man in a red cap.",
                true, 3);
    }

    /**
     * Overrides Card's default play method. Gnome is destroyed after played.
     * Gnome causes all other opponents to discard a random card
     *
     * @param p The game PlasterClash Instance
     */
    @Override public void play(PlasterClash p) {
        p.incGnomeCount();
        p.currentPlayer().getHand().remove(this);

        for (Player joe : p.opponents()) {
            joe.discardRandom();
        }
    }
}
