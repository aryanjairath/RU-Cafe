package projectfour;

public class Cake extends Donut{

    private static final double PRICE = 1.79;

    public Cake(String flavor) {
        super(flavor);
    }

    @Override
    public double itemPrice(){
        return PRICE;
    }
}
