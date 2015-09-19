/**
 * PaymentFailedException gets thrown by the device when payment fails.
 *
 * @author Zack Sparks
 * @version 1.0
 */
public class PaymentFailedException extends Exception {
    /**
     * Creates a new PaymentFailedException with the given message.
     * @param  msg The message of the exception.
     */
    public PaymentFailedException(String msg) {
        super(msg);
    }

    /**
     * Creates a new ServerException.
     */
    public PaymentFailedException() {
        super();
    }
}
