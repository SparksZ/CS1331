
/**
 * Card class represents the card payment method it has two attributes:
 * ownerName and balance.
 * @author Zack Sparks
 * @version 1.0
 */
public abstract class Card implements PaymentMethod {
    private String ownerName;
    protected double balance;

    /**
     * Creates a new card with an owner name and balance of the card.
     * @param ownerName this is the String representation of the owner's name.
     * @param balance   this is the double representation of the balance
     *  avaliable
     */
    public Card(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    /**
     * Pays the given amount if possible, throws a PaymentFailedException if
     * something goes wrong.
     * @param  amount                 Amount of money to pay.
     * @throws PaymentFailedException Thrown if something goes wrong.
     */
    public void pay(double amount) throws PaymentFailedException {

        if (amount > this.balance) {
            throw new NotEnoughFundsException("Insufficient funds!");
        }

        this.balance -= amount;
    }
}
