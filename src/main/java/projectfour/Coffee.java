package projectfour;

import java.util.ArrayList;

public class Coffee {
    int cupsize;
    ArrayList<String> addIns;

    public Coffee(int cupsize){
        this.cupsize = cupsize;
        addIns = new ArrayList<>();
    }

    public int getCupSize(){
        return cupsize;
    }

    public void setCupsize(int cupsize){
        this.cupsize = cupsize;
    }
    public void addaddIn(String addIn){
        addIns.add(addIn);
    }

    public void removeaddIn(String addIn){
        addIns.remove(addIn);
    }

}
