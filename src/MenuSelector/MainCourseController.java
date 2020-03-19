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

        // Parent root = FXMLLoader.load(getClass().getResource("MainCourseScreen.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DessertCourseScreen.fxml"));
        Parent root = loader.load();
        DessertCourseController c2 = loader.getController();
        c2.passInfo(lblTblNo.getText(),getTotalPrice(), getFoodCount(), getTotalCals());
        //m2.setTblNo(txtTableID.getText());
        Stage window = (Stage) lblTotal.getScene().getWindow();
        window.setTitle("Choose Main Course");
        window.setScene(new Scene(root, 600, 400));
        System.out.println(totalCals);
        //updateTotals(totalCals);
        window.show();


    }




    public void setTblNo(String message){
        lblTblNo.setText(message);
    }

    void setTotal(Double total){
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        totalPrice =+ total;
        lblTotal.setText("Total: "+ cf.format(total));
    }



}
