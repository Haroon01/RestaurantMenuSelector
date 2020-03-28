package MenuSelector;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Window;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CheckoutController extends Main {

    public void initialize() {

        initCols();
        //obInitCheckout();

        setTotal(getTotalPrice());

    }

    void setTotal(Double total){
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        totalPrice =+ total;
        lblTotal.setText("Total prioe to pay: "+ cf.format(total));
    }
    public void dataReceiverFinal(ObservableList<Food> list){
        System.out.println("data received");
        //this.obSelection = list;
        obSelection.setAll(list);
        tblFoodCart.setItems(list);

    }

    public void payWithCash(ActionEvent e) throws IOException {
        Window mainWindow = lblTotal.getScene().getWindow();
        // create an instance eof the Loader which is used to open the next screen.
        FXMLLoader loader = new FXMLLoader();
        //set the location
        loader.setLocation(getClass().getResource("PayCashScreen.fxml"));
        // add loader to root
        Parent root = loader.load();
        //get the controller of the loader just created
        PayCashController screen2Controller = loader.getController();
        //call method which receives data in new controller and pass it the value required.


        mainWindow.getScene().setRoot(root);
    }


    public void nextScene(ActionEvent event) throws IOException {


        Window mainWindow = lblTotal.getScene().getWindow();

        // create an instance eof the Loader which is used to open the next screen.
        FXMLLoader loader = new FXMLLoader();
        //set the location
        loader.setLocation(getClass().getResource("PaidScreen.fxml"));
        // add loader to root
        Parent root = loader.load();
        //get the controller of the loader just created
        PaidController screen2Controller = loader.getController();
        //call method which receives data in new controller and pass it the value required.
        screen2Controller.dataReceiverFinal(getObList());
        screen2Controller.finalPassInfo(lblTblNo.getText(),getTotalPrice(), getFoodCount(), getTotalCals());
        System.out.println("getObList" + getObList());
        System.out.println("obselection" + obSelection);
        mainWindow.setHeight(626);
        mainWindow.setWidth(405);
        setTitle("Order Successful");
        mainWindow.getScene().setRoot(root);



    }

    public void dataReceiverChck(String newDetails){
        //this.message = passedMessage;
        lblTotal.setText(newDetails);

    }

}
