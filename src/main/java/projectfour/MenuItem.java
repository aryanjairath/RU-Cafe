package projectfour;

public abstract class MenuItem {
    /**
     * Abstract method representing the item price. To be implemented
     * in subclasses
     * @return
     */
    public abstract double itemPrice();

    private String item;
    public MenuItem(String item){
       this.item = item;
    }

}
