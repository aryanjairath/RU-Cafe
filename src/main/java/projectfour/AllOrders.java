package projectfour;

import java.util.ArrayList;

public class AllOrders {
    public static ArrayList<Order> allOrder = new ArrayList<>();
    public static ArrayList<Order> storeOrders = new ArrayList<>();

    public static int uniqueNumber = 0;
    public static void addOrder(Order order, int index){
        if(allOrder.size() == index) {
            allOrder.add(order);
        }else {
            ArrayList<String> list = allOrder.get(index).getMenuItems();
            ArrayList<String> list2 = order.getMenuItems();
            for(int i = 0; i < list2.size(); i++){
                list.add(list2.get(i));
            }
            Order ord = new Order(index);
            for(int i = 0; i < list.size(); i++){
                ord.addItem(list.get(i));
            }
            ord.setPrice(order.getPrice());
            allOrder.set(index, ord);
            }
    }

    public static void addStoreOrder(int index){
        storeOrders.add(allOrder.get(allOrder.size()-1));
        for(int i = 0; i < storeOrders.size(); i++) {
            System.out.print(storeOrders.get(i).getPrice());
            System.out.println(storeOrders.get(i).getMenuItems());
        }
        System.out.println();
    }
    public static ArrayList<Order> allOrderR(){
        return allOrder;
    }
    public static int getUniqueNumber(){
        return uniqueNumber;
    }
    public static void incrementUnique(){
        uniqueNumber++;
    }

    public void removeOrder(Order order){
        allOrder.remove(order);
    }

}
