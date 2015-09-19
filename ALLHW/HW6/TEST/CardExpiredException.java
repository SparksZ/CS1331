import java.time.LocalDate;

/**
 * CardExpiredException gets thrown by the device when payment is expired.
 *
 * @author Zack Sparks
 * @version 1.0
 */
public class CardExpiredException extends PaymentFailedException {
    /**
     * Creates a new CardExpiredException with the given message.
     * @param date the date of expiry.
     */
    public CardExpiredException(LocalDate date) {
        super("This card expired on " + date);
    }

    /**
     * Creates a new CardExpiredException.
     */
    public CardExpiredException() {
        super();
    }
}
