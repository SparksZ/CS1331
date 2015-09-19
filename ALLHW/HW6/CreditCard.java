import java.time.LocalDate;
/**
 * Credit Card class represents the credit card payment method it has three
 * attributes: ownerName, balance, expiry date.
 * @author Zack Sparks
 * @version 1.0
 */
public class CreditCard extends Card {
    private LocalDate expiryDate;

    /**
     * Constructs a new credit card instance.
     * @param ownerName the name of the owner of the card.
     * @param balance   the balance available on the card.
     * @param expiry    the expiry date of the card.
     */
    public CreditCard(String ownerName, double balance, LocalDate expiry) {
        super(ownerName, balance);
        this.expiryDate = expiry;
    }

    /**
     * Pays the given amount if possible, throws a PaymentFailedException if
     * something goes wrong.
     * @param  amount                  Amount of money to pay.
     * @throws NotEnoughFundsException Thrown if something goes wrong.
     * @throws CardExpiredException    Thrown if the card is expired.
     */
    @Override public void pay(double amount) throws NotEnoughFundsException,
        CardExpiredException {

        if (amount > this.balance) {
            throw new NotEnoughFundsException("Insufficient funds!");
        } else if (LocalDate.now().compareTo(this.expiryDate) > 0) {
            throw new CardExpiredException(expiryDate);
        }

        this.balance -= amount;
    }
}
