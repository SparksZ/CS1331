import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents the Zone Object, which holds cards.
 *
 * @author Zack Sparks
 * @version 1.0
 */
public class Zone implements Iterable<Card> {
    private ArrayList<Card> deck;

    /**
     * Constructs a Zone object.
     */
    public Zone() {
        deck = new ArrayList<Card>();
    }

    /**
     * Adds a card to the Zone
     *
     * @param aCard the card to be added to the particular Zone.
     */
    public void add(Card aCard) {
        deck.add(aCard);
    }

    /**
     * Method to determine if there is a copy of the card passed into it
     *
     * @param aCard the card to query the zone with.
     * @return whether the deck contains the card
     */
    public boolean contains(Card aCard) {
        return deck.contains(aCard);
    }

    /**
     * Method to determine if there is a copy of the card passed into it
     *
     * @param idx The index of the card to be removed.
     * @return the removed card
     */
    public Card remove(int idx) {
        Card temp = deck.get(idx);
        deck.remove(idx);
        return temp;
    }

    /**
     * Removes a copy of the card from the Zone
     *
     * @param aCard the card to remove from the zone
     */
    public void remove(Card aCard) {
        deck.remove(aCard);
    }

    /**
     * Display the card located at the index passed.
     *
     * @param idx the index of the card that you want to display
     */
    public void display(int idx) {
        System.out.println(deck.get(idx).toString());
    }

    /**
     * Returns the card at the specific index passed into the method.
     * @param idx the index of the card to be gotten.
     * @return the card at the Zone's index
     */
    public Card get(int idx) {
        return deck.get(idx);
    }

    /**
     * Shuffle that deck
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Implements the interator method in Iterable.
     *
     * @return an iterable object that iterates over the cards in the Zone.
     */
    @Override public Iterator<Card> iterator() {
        return deck.iterator();
    }

    /**
     * Moves all of the cards in this zone to another zone
     *
     * @param aZone the zone to move all the cards to.
     */
    public void moveCardsTo(Zone aZone) {

        Iterator it = deck.iterator();

        while (it.hasNext()) {
            Card temp = (Card) it.next();
            aZone.add(temp);
            it.remove();
        }
    }

    /**
     * Discards all cards in the zone
     *
     * @return the cards in the zone!
     */
    public ArrayList<Card> discardAll() {
        ArrayList<Card> temp = deck;
        deck.clear();
        return temp;
    }

    /**
     * @return the number of cards in the Zone.
     */
    public int size() {
        return deck.size();
    }

    /**
     * @return number of scoreable cards in the Zone!
     */
    public int numGnomes() {
        int result = 0;
        Iterator<Card> it = this.iterator();

        while (it.hasNext()) {
            if (it.next().isScorable()) {
                result++;
            }
        }

        return result;
    }

    /**
     * String representation of the zone.
     *
     * @return the cards numbered and their name.
     */
    @Override public String toString() {
        Iterator it = deck.iterator();
        String result = "";
        int count = 0;

        while (it.hasNext()) {
            result += count + ": " + it.next() + "\n";
            count++;
        }

        return result;
    }
}
