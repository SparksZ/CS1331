/**
 * NotEnoughFundsException gets thrown by the device when the customer is broke.
 *
 * @author Zack Sparks
 * @version 1.0
 */

public class NotEnoughFundsException extends PaymentFailedException {
    /**
     * Creates a new NotEnoughFundsException with the given message.
     * @param  msg The message of the exception.
     */
    public NotEnoughFundsException(String msg) {
        super(msg);
    }

    /**
     * Creates a new NotEnoughFundsException.
     */
    public NotEnoughFundsException() {
        super();
    }
}
