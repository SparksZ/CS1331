import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the Map of cards and their inventory in the card shop.
 *
 * @author Zack Sparks
 * @version 1.0
 */
public class Field {
    private HashMap<Card, Integer> purchaseable;

    private GardenBread garden = new GardenBread();
    private Gnome gnome = new Gnome();
    private Feast feast = new Feast();

    /**
     * Constructs a Field object
     */
    public Field() {
        purchaseable = new HashMap<Card, Integer>();
        purchaseable.put(garden, 1);
        purchaseable.put(gnome, 10);
        purchaseable.put(feast, 5);
    }

    /**
     * Decrements the gnomes and the feast cards when being bought
     *
     * @param aCard the card that is bought.
     */
    public void buyCard(Card aCard) {
        purchaseable.get(aCard);

        if (!(aCard instanceof GardenBread)) {
            purchaseable.put(aCard, purchaseable.get(aCard) - 1);

            if (purchaseable.get(aCard) == 0) {
                purchaseable.remove(aCard);
            }
        }
    }

    /**
     * @return the purchaseable cards
     */
    public ArrayList<Card> cards() {
        return new ArrayList<Card>(purchaseable.keySet());
    }
}
