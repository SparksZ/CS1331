/**
 * WrongStoreError gets thrown by the device a competing store makes a
 * CheckoutMachine object.
 *
 * @author Zack Sparks
 * @version 1.0
 */

public class WrongStoreError extends Error {
    /**
     * Creates a new WrongStoreError with given message.
     * @param msg Message to be displayed when thrown.
     */
    public WrongStoreError(String msg) {
        super(msg);
    }

    /**
     * Creates a new WrongStoreError.
     */
    public WrongStoreError() {
    }
}
