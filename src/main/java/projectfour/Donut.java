package projectfour;

public class Donut extends MenuItem{
    String flavor;

    public Donut(String flavor){
        this.flavor = flavor;

    }
    @Override
    public double itemPrice() {
        return 0;
    }
}
