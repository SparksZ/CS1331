import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 * DemoDriver Demonstrates all  facets of the CheckoutMachine
 * @author Zack Sparks
 * @version 1.0
 */
public class DemoDriver {
    /**
     * Main method of demo
     * @param args command-line arguments....
     */
    public static void main(String[] args) {
        cashExample(3.50);
        cashExample(1000.00);
        creditCardExample(LocalDate.of(2017, Month.JANUARY, 1), 1000);
        creditCardExample(LocalDate.of(2014, Month.JANUARY, 1), 1000);
        creditCardExample(LocalDate.of(2014, Month.JANUARY, 1), 3.50);
        buzzCardExample(3.50);
        buzzCardExample(1000);
        pirateStoreExample();
    }

    /**
     * Implements a cash payment method
     * @param cashMoney amount of cash in wallet
     */
    public static void cashExample(double cashMoney) {
        Cash money = new Cash(cashMoney);
        CheckoutMachine techConven = scanStuff();
        pay(techConven, money);
    }

    /**
     * Implements a credit card payment method
     * @param expiry the LocalDate representation of expiry date
     * @param funds the available funding for the card
     */
    public static void creditCardExample(LocalDate expiry, double funds) {
        CreditCard money = new CreditCard("George P. Burdell", 1000000, expiry);

        CheckoutMachine techConven = scanStuff();
        pay(techConven, money);
    }

    /**
     * Implements a buzzCard payment method
     * @param funds the available funding for the card
     */
    public static void buzzCardExample(double funds) {
        BuzzCard money = new BuzzCard("George P. Burdell", 1000000);

        CheckoutMachine techConven = scanStuff();
        pay(techConven, money);
    }

    /**
     * Shows a bunch of scally-wag pirates trying to steal our software what's
     * up
     */
    public static void pirateStoreExample() {

        CheckoutMachine techConven = new CheckoutMachine("JJ's Butcher Shop");
    }

    /**
     * Scans stuff into a cart
     * @return a CheckoutMachine with a bunch of stuff in the cart
     */
    public static CheckoutMachine scanStuff() {
        CheckoutMachine techConven = new CheckoutMachine("TechConvenience");

        System.out.println("Welcome to TechConvenience!");

        try {
            techConven.scan(new Item(961.05, 9220570L));
            System.out.println("*Beep*");
        } catch (InvalidItemException e) {
            System.out.println(e.getMessage());
        }
        try {
            techConven.scan(new Item(75.84, 12L));
            System.out.println("*Beep*");
        } catch (InvalidItemException e) {
            System.out.println(e.getMessage());
        }
        try {
            techConven.scan(new Item(1028.80, 9237204L));
            System.out.println("*Beep*");
        } catch (InvalidItemException e) {
            System.out.println(e.getMessage());
        }
        try {
            techConven.scan(new Item(1028, 9237204L));
            System.out.println("*Beep*");
        } catch (InvalidItemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nYour total is $" + techConven.getTotal());

        return techConven;
    }

    /**
     * Scans stuff into a cart
     * @param techConven a CheckoutMachine Object with items in the cart
     * @param money a payment method to pay for the items in the cart
     */
    public static void pay(CheckoutMachine techConven, PaymentMethod money) {
        boolean cancelCart = false;
        Scanner in = new Scanner(System.in);

        while (!cancelCart) {
            try {
                techConven.payForCart(money);
                System.out.println("Payment Accepted!");
                cancelCart = true;
            } catch (PaymentFailedException e) {
                System.out.println(e.getMessage());
                System.out.print("\nWould you like to try another payment"
                    + "method? (y/n)");
                char response = in.next().charAt(0);
                System.out.println();

                if (response == 'n') {
                    cancelCart = true;
                }
            }
        }

        System.out.println("Thanks for using TechConvenience!\n\n");
    }
}
