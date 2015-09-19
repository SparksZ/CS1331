import java.util.Scanner;

/**
 * Represents the Feast card.
 *
 * @author Zack Sparks
 * @version 1.0
 */
public class Feast extends Card {
    /**
     * Constructs a Feast Object. It is not scorable.
     */
    public Feast() {
        super("Feast", "Play with any other card and get two GardenBread",
            "Tonight we dine on GardenBread!", false, 2);
    }

    /**
     * Overrides Card's default play method,
     *
     * @param p the plasterclash game instance.
     */
    @Override public void play(PlasterClash p) throws RuntimeException {
        super.play(p);
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        Zone playersHand = p.currentPlayer().getHand();
        int idx;

        System.out.println(playersHand);

        do {
            System.out.println("Which card # would you like to discard?");
            while (!in.hasNextInt()) {
                System.out.println("Not a valid selection!");
                in.next();
            }

            idx = in.nextInt();
        } while (idx < 0 || idx >= playersHand.size());


        playToPlayZone(p);
        playersHand.remove(idx);
        playersHand.add(new GardenBread());
        playersHand.add(new GardenBread());
    }
}
