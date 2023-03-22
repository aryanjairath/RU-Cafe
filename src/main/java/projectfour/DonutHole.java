package projectfour;

public class DonutHole extends Donut{

    private static final double PRICE = 0.39;

    public DonutHole(String flavor) {
        super(flavor);
    }

    @Override
    public double itemPrice(){
        return PRICE;
    }
}
