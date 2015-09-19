/**
 * Represents the tree deck.
 *
 * @author Zack Sparks
 * @version 1.0
 */
public class Tree extends Zone {

    /**
     * Constructs a tree object.
     */
    public Tree() {
        for (int i = 0; i < 9; i++) {
            super.add(new Keeble());
        }

        super.add(new Gnome());
    }
}
