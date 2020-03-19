package MenuSelector;

/**
 *
 * Tasks for a pass:
 * Provide a choice of 4 starters, 6 mains and 4 desserts
 * Enable 2 customers to select a 1-3 course meal
 * enable them to enter table number and amount of diners
 * submit button which simulates sending info to the kitchen
 * clear the screen for next customer
 * Display the total order with table number, calories and price
 * enable a meal to be paid in cash and display a receipt
 *
 */

import MenuSelector.Food;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class StarterCourseController extends Main{




    @Override
    public void initialize() {
        // Add all items from Observable list to the tableView
        initCols();
        obInitStarters();
        obSelectionInit();



    }





    public void nextScene(ActionEvent event) throws IOException {

        // Parent root = FXMLLoader.load(getClass().getResource("MainCourseScreen.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainCourseScreen.fxml"));
        Parent root = loader.load();
        MainCourseController m2 = loader.getController();
        m2.passInfo(lblTblNo.getText(),getTotalPrice(), getFoodCount(), getTotalCals());
        //m2.setTblNo(txtTableID.getText());
        Stage window = (Stage) lblTotal.getScene().getWindow();
        window.setTitle("Choose Main Course");
        window.setScene(new Scene(root, 600, 400));
        System.out.println(totalCals);
        //updateTotals(totalCals);
        window.show();



    }

    public void pressed(MouseEvent e){
        lstCart.setVisible(false);
    }




//    void setTblNo(String message){
//        lblTblNo.setText(message);
//    }

//    void setTotal(Double total){
//        Locale locale = new Locale("en", "GB");
//        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
//        totalPrice =+ total;
//        lblTotal.setText("Total: "+ cf.format(total));
//    }



}