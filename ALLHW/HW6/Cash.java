
/**
 * Cash class represents the Cash payment method it has one attribute:
 * cashOnHand.
 * @author Zack Sparks
 * @version 1.0
 */
public class Cash implements PaymentMethod {
    private double cashOnHand;

    /**
     * Constructs a new cash instance with amount of cash on hand.
     * @param cashOnHand amount of cashOnHand
     */
    public Cash(double cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    /**
     * Pays the given amount if possible, throws a PaymentFailedException if
     * something goes wrong.
     * @param  amount                  Amount of money to pay.
     * @throws NotEnoughFundsException Thrown if something goes wrong.
     */
    public void pay(double amount) throws NotEnoughFundsException {

        System.out.println(cashOnHand);

        if (amount > this.cashOnHand) {
            throw new NotEnoughFundsException("Not enough cash!");
        }

        this.cashOnHand -= amount;
    }
}
