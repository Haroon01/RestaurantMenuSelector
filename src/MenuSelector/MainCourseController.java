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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainCourseController extends Main {

//    private void initCount() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("StarterCourseScreen.fxml"));
//        Parent root = loader.load();
//        StarterCourseController c = loader.getController();
//        totalCals2 =+ c.totalCals;
//
//    }
//    // Counts for all the labels (Price, calories, amount of food)
//    private int foodCount = 0;
//    private Double totalPrice = 0.00;
//    private int totalCals2;

    //private int totalCals2 = c.totalCals;

    @Override
    public void initialize() {
        initCols();
        updateLabels();
        obInitMains();
        obSelectionInit();

    }




    public void setTblNo(String message){
        lblTblNo.setText(message);
    }


}
