/**
* InvalidItemException gets thrown by the device when the item isn't valid.
*
* @author Zack Sparks
* @version 1.0
*/

public class InvalidItemException extends Exception {

    /**
     * Creates a new NotEnoughFundsException.
     */
    public InvalidItemException() {
        super("This item is invalid.");
    }
}
