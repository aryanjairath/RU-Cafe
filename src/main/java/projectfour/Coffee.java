package projectfour;

import java.util.ArrayList;

public class Coffee extends MenuItem{
    String cupsize;
    ArrayList<String> addIns;

    public Coffee(String cupsize){
        this.cupsize = cupsize;
        addIns = new ArrayList<>();
    }

    public String getCupSize(){
        return cupsize;
    }

    public void setCupsize(String cupsize){
        this.cupsize = cupsize;
    }
    public void addaddIn(String addIn){
        addIns.add(addIn);
    }

    public void removeaddIn(String addIn){
        addIns.remove(addIn);
    }

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
