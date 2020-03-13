package MenuSelector;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.text.NumberFormatter;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class StarterCourseController implements Initializable {
    @FXML
    private Label labelCount;
    @FXML
    private TableView<Food> tblFoodCart;
    @FXML
    private TableColumn<Food, String> colItem;
    @FXML
    private TableColumn<Food, Integer> colCals;
    @FXML
    private TableColumn<Food, Double> colPrice;
    @FXML
    private ObservableList<String> obSelection = FXCollections.observableArrayList();
    @FXML
    private ListView<String> lstCart;
    @FXML
    private Button btnAddToCart;
    @FXML
    private Button btnRemove;
    @FXML
    private Label lblCount;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblCals;
    @FXML
    private Label lblTblNo;
    @FXML




    // Counts for all the labels (Price, calories, amount of food)
    private int foodCount = 0;
    private Double totalPrice = 0.00;
    private int totalCals = 0;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        obSelection.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
            }
        }
        );

        lstCart.setItems(obSelection);


        System.out.println("initialise method has been executed."); // debugging check to see if this method is being executed


        // Linking the columns with the constructors in food.java so we can add the correct info in the correct columns
        colItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        colCals.setCellValueFactory(new PropertyValueFactory<>("calories"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));


        // Add all items from Observable list to the tableView
        tblFoodCart.setItems(foodList);

        updateLabels();
    }





    public void addToCart(ActionEvent event){
        Locale locale = new Locale("en","UK");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        if(tblFoodCart.getSelectionModel().getSelectedIndex() == -1){
            Alert error = new Alert(Alert.AlertType.ERROR, "Select an item to add!", ButtonType.OK);
            error.showAndWait();
        }
        else{
            Food food = tblFoodCart.getSelectionModel().getSelectedItem();
            System.out.println(food.getItem());
            obSelection.add(food.getItem());
            foodCount++;
            totalPrice += food.getPrice();
            totalCals += food.getCalories();
            updateLabels();
        }
    }

    public void removeFromCart(ActionEvent event) {
        if (lstCart.getSelectionModel().getSelectedIndex() == -1) {
            Alert error1 = new Alert(Alert.AlertType.ERROR, "Select an item to remove!", ButtonType.OK);
            error1.showAndWait();
        } else {
            Food food = lstCart.getSelectionModel().getSelectedIndex(); // FIXME: Totals not updating correctly when removing things from the cart
            obSelection.remove(food);
            foodCount--;
            totalPrice -= food.getPrice();
            totalCals -= food.getCalories();
            updateLabels();
        }
    }

    public void updateLabels(){
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        lblCount.setText("Total Items: " + foodCount);
        lblTotal.setText("Total: "+cf.format(totalPrice));
        lblCals.setText("Calories: "+totalCals);

    }


    // Observable list where all the food is stored to be displayed in the tableView
    private ObservableList<Food> foodList = FXCollections.observableArrayList(); {
        foodList.add(new Food("Kebab", 43, 53.76));
        foodList.add(new Food("Chicken",65,89.00));
    }

}