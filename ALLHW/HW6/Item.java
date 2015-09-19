/**
 * Item class represents an item, having name, weight, price, and barcode.
 * @author Alex Epifano & Thomas Shields
 * @version 1.0
 */
public class Item {

    private String name;
    private double weight;
    private double price;
    private long barcode;

    /**
     * Creates a new item with the specified weight and barcode. Initializes
     * name as null and price as 0.0.
     * @param  weight  The weight in grams of the item.
     * @param  barcode The barcode of the item.
     */
    public Item(double weight, long barcode) {
        this.name = null;
        this.price = 0.0;
        this.weight = weight;
        this.barcode = barcode;
    }

    /**
     * Create new item with the specified properties.
     * @param  name    The name of the item.
     * @param  weight  The weight of the item in grams.
     * @param  price   The price of the item in USD.
     * @param  barcode The barcode of the item.
     */
    public Item(String name, double weight, double price, long barcode) {
        this(weight, barcode);

        this.price = price;
        this.name = name;
    }

    /**
     * @return the price of the instance item.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @return the weight of the instance item.
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * @return the name of the instance item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the barcode of the instance item.
     */
    public long getBarcode() {
        return this.barcode;
    }

    /**
     * Equals method based soley on weight and barcode
     * @param o any instance of an object.
     */
    @Override public boolean equals(Object o) {
        if (null == o) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item u = (Item) o;
        return this.weight == u.getWeight() && this.barcode == u.getBarcode();
    }
}
