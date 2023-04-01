package projectfour;

import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderMenuController {

    @FXML
    private ListView resultView;

    @FXML
    private TextField runningTotal;

    private static int SIZEINDEX = 1;

    private ObservableList<String> orderList;

    private static int BEGININDEX = 0;

    private static int ENDINDEX = 1;

    @FXML
    public void showAllOrders(){

        ArrayList<Order> orderList = AllOrders.allStoreOrders();
        System.out.println(orderList);
        if(orderList.size() != 0){
            ArrayList<String> list = orderList.get(orderList.size() - SIZEINDEX).getMenuItems();
            this.orderList = FXCollections.observableArrayList();

            for(int i = 0; i < orderList.size(); i++){
                this.orderList.add(orderList.get(i).toString());
            }
        }else{
            ArrayList<String> list = new ArrayList<String>();
        }
        this.resultView.setItems(this.orderList);
    }

    /**
     * Rounds a given decimal to two decimal places
     * @param amount a double representing a price.
     * @return a rounded price.
     */

    private double round(double amount){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        amount = Double.parseDouble(df.format(amount));
        return amount;
    }


    /**
     * Removes an item from the ordering list, given access to various element from the UI.
     */

    @FXML
    private void removeItem(){
        int orderNumber = Integer.parseInt(((String) this.resultView.getSelectionModel()
                .getSelectedItem()).substring(BEGININDEX,ENDINDEX)) - ENDINDEX;
        String order = ((String) this.resultView.getSelectionModel()
                .getSelectedItem()).substring(BEGININDEX,ENDINDEX);
        AllOrders.removeOrderedItem(orderNumber);
        this.orderList.remove(orderNumber);
        System.out.println(this.orderList);
        this.resultView.setItems(this.orderList);
    }


    /**
     * Writes orders to a text file.
     * @throws IOException, if the file is not found.
     */


    @FXML
    public void exportToTextFile() throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        for(String str: this.orderList) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }






}
