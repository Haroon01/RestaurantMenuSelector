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


}
