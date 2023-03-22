package projectfour;

public class Yeast extends Donut{

    private static final double PRICE = 1.59;

    public Yeast(String flavor) {
        super(flavor);
    }

    @Override
    public double itemPrice(){
        return PRICE;
    }
}
