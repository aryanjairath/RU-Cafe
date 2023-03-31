package projectfour;

import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderMenuController {

    @FXML
    private ListView resultView;

    @FXML
    private TextField runningTotal;

    private static int SIZEINDEX = 1;

    private ObservableList<String> orderList;
    public OrderMenuController(){
        ArrayList<Order> orderList = AllOrders.allOrderR();
        System.out.println(orderList);
        System.out.println(orderList.size());
        ArrayList<String> list = orderList.get(orderList.size() - SIZEINDEX).getMenuItems();
        this.orderList = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++){
            this.orderList.add(list.get(i));
        }

        this.resultView.setItems(this.orderList);
    }


    @FXML
    public void showAllOrders(){


    }


    private double round(double amount){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        amount = Double.parseDouble(df.format(amount));
        return amount;
    }









}
