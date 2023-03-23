package projectfour;

import java.util.ArrayList;

public class Coffee extends MenuItem{
    String cupsize;
    ArrayList<String> addIns;

    /**
     * Constructor for the coffee class,
     * @param cupsize a String representing the size of the cup.
     */
    public Coffee(String cupsize){
        this.cupsize = cupsize;
        addIns = new ArrayList<>();
    }

    /**
     * Returns the cup size to the user.
     * @return a string representing the cup size.
     */
    public String getCupSize(){
        return cupsize;
    }

    /**
     * Sets the size of the coffee, based on an input string.
     * @param cupsize a string representing the size of the cup.
     */
    public void setCupsize(String cupsize){
        this.cupsize = cupsize;
    }

    /***
     * Adds a particular add in for this coffee.
     * @param addIn a string representing an add in.
     */

    public void addaddIn(String addIn){
        addIns.add(addIn);
    }

    /**
     * Attempts to remove an addin from the addin list.
     * Returns false if it is not present.
     * @param addIn a String representing an addin in quesiton.
     * @return a boolean representing if the operation was successful.
     */

    public boolean removeaddIn(String addIn){

        if(!addIns.remove(addIn)){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Returns the item price for the given coffee based on
     * @return a double representing the price.
     */
    @Override
    public double itemPrice() {
        double balance = 0;
        if(this.cupsize.equals("Short")){
            balance += 1.89 + addIns.size() * 0.30;
        }else if(this.cupsize.equals("Tall")){
            balance += 2.29 + addIns.size() * 0.30;
        }else if(this.cupsize.equals("Grande")){
            balance += 2.69 + addIns.size() * 0.30;
        }else if(this.cupsize.equals("Venti")){
            balance += 3.09 + addIns.size() * 0.30;
        }
        return balance;
    }
}
