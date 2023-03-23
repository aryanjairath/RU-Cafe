package projectfour;

public class Cake extends Donut{

    private static final double PRICE = 1.79;

    /**
     * Constructor for the Cake donut class, inherits from donut.
     * @param flavor a string containing the flavor.
     */
    public Cake(String flavor) {
        super(flavor);
    }

    /**
     * Returns the price of each donut.
     * @return a double containing the price.
     */
    @Override
    public double itemPrice(){
        return PRICE;
    }
}
