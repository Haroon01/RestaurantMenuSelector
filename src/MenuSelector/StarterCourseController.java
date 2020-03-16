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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class StarterCourseController extends Main{








    // Observable list where all the food is stored to be displayed in the tableView
    private ObservableList<Food> foodList = FXCollections.observableArrayList(); {
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        foodList.add(new Food("Kebab", 43, 4.99));
        foodList.add(new Food("Chicken",65,8.49));
        foodList.add(new Food("Fish", 31, 7.69));
        foodList.add(new Food("Chips",82,3.25));
        foodList.add(new Food("Bread", 52, 1.09));
        foodList.add(new Food("Cheese",40,2.90));
        foodList.add(new Food("Spring Roll", 26, 10.99));
        foodList.add(new Food("Mushroom",97,14.98));
        foodList.add(new Food("Sausage", 74, 4.00));
        foodList.add(new Food("Salad",15,2.75));
    }

    public void setTblNo(String message){
        lblTblNo.setText(message);
    }

    public void nextScene(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MainCourseScreen.fxml"));
        //Scene scene = new Scene(root);
        Stage window = (Stage) lblTotal.getScene().getWindow();
        window.setTitle("Choose Main Course");
        window.setScene(new Scene(root, 600, 400));
        window.show();
//        window.setResizable(false);

//        root = FXMLLoader.load(getClass().getResource("authentication.fxml"));
//        window.initStyle(StageStyle.UNDECORATED);
//        window.setTitle("Markalyzer");
//        window.setScene(new Scene(root));
//        window.show();


        }


    }