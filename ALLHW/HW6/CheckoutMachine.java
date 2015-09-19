import java.util.ArrayList;

/**
 * CheckoutMachine represents a single checkout machine at TechConvenience
 * @author Zack Sparks
 * @version 1.0
 */
public class CheckoutMachine {
    private String storeName;
    private ArrayList<Item> cart = new ArrayList<Item>();
    private boolean validStoreName;
    private boolean flag = true;
    private double totalPrice = 0;

    /**
     * Constructs a new CheckoutMachine object
     * @param storeName this is the name of the Store, must be "TechConvenience"
     */
    public CheckoutMachine(String storeName) {

        this.storeName = storeName;

        while (this.flag) {
            try {
                cart = Server.getValidItems();
                this.flag = false;
            } catch (ServerException e) {
                System.out.println(e.getMessage());
            }
        }

        this.flag = true;

        while (this.flag) {
            try {
                validStoreName = Server.isStoreNameValid(this.storeName);
                this.flag = false;
            } catch (ServerException e) {
                System.out.println(e.getMessage());
            }
        }

        if (!validStoreName) {
            throw new WrongStoreError("Dirty Pirates Can't Steal Software!");
        }
    }

    /**
     * Scans an item into the cart
     * @param item item to be scanned
     */
    public void scan(Item item) throws InvalidItemException {
        flag = false;
        for (Item that : cart) {
            if (that.equals(item)) {
                totalPrice += that.getPrice();
                flag = true;
            }
        }

        if (!flag) {
            throw new InvalidItemException();
        }
    }

    /**
     * @return the total price of the items in the cart
     */
    public double getTotal() {
        return this.totalPrice;
    }

    /**
     * Pays for the cart
     * @param payWith the PaymentMethod to pay the cart with
     */
    public void payForCart(PaymentMethod payWith) throws
        PaymentFailedException {
        payWith.pay(this.totalPrice);
    }
}
