package projectfour;

import java.util.ArrayList;

public class AllOrders {
    public static ArrayList<Order> allOrder = new ArrayList<>();
    public static ArrayList<Order> storeOrders = new ArrayList<>();

    public static int uniqueNumber = 1;
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
        Order orderToAdd = allOrder.get(allOrder.size()-1);
        orderToAdd.setOrderNumber(AllOrders.getUniqueNumber());
        storeOrders.add(orderToAdd);
        for(int i = 0; i < storeOrders.size(); i++) {
            System.out.println(storeOrders.get(i).getPrice());
            System.out.println(storeOrders.get(i).getMenuItems());
            System.out.println(storeOrders.get(i).getOrderNumber());
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

    public static ArrayList<Order> allStoreOrders(){
        return storeOrders;
    }

    public static void removeOrderedItem(int index){
        storeOrders.remove(index);
    }

    public void removeOrder(Order order){
        allOrder.remove(order);
    }

}
