package projectfour;

public class Donut extends MenuItem{
    String flavor;

    /**
     * Constructor for Donut. Takes a string represetning the flavor.
     * @param flavor a String containing the flavor type.
     */
    public Donut(String flavor){
        super(flavor);
        this.flavor=flavor;
    }

    /**
     *
     * @return
     */
    @Override
    public double itemPrice() {
        return 0;
    }

    public String getFlavor(){
        return this.flavor;
    }
}
