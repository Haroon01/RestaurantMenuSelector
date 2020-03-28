package MenuSelector;

import MenuSelector.Food;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainCourseController extends Main {

    @Override
    public void initialize() {
        initCols();
        obInitMains();
        obSelectionInit();
        setTotal(getTotalPrice());
        //updateTotals(totalCals);
    }

    public void nextScene(ActionEvent event) throws IOException {

        Window mainWindow = lblTotal.getScene().getWindow();

        // create an instance eof the Loader which is used to open the next screen.
        FXMLLoader loader = new FXMLLoader();
        //set the location
        loader.setLocation(getClass().getResource("DessertCourseScreen.fxml"));
        // add loader to root
        Parent root = loader.load();
        //get the controller of the loader just created
        DessertCourseController screen2Controller = loader.getController();
        //call method which receives data in new controller and pass it the value required.
        screen2Controller.dataReceiver(getObList());
        screen2Controller.passInfo(lblTblNo.getText(),getTotalPrice(), getFoodCount(), getTotalCals());

        setTitle("Select Dessert");
        mainWindow.getScene().setRoot(root);

    }




    void setTotal(Double total){
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        totalPrice =+ total;
        lblTotal.setText("Total: "+ cf.format(total));
    }






}
