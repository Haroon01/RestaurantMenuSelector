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

import java.net.URL;
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

    int foodCount = 0;
    Double totalPrice = 0.00;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        obSelection.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("invalidated");
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
    }





    public void addToCart(ActionEvent event){
        if(tblFoodCart.getSelectionModel().getSelectedIndex() == -1){
            Alert error = new Alert(Alert.AlertType.ERROR, "Select an item to add!", ButtonType.OK);
        }
        else{
            Food food = tblFoodCart.getSelectionModel().getSelectedItem();
            System.out.println(food.getItem());
            obSelection.add(food.getItem());
            foodCount++;
            lblCount.setText("Total Items:"+foodCount);
            totalPrice += food.getPrice();
            lblTotal.setText("Total: £"+totalPrice);


        }
    }

    public void removeFromCart(ActionEvent event){
        if(lstCart.getSelectionModel().getSelectedIndex() == -1){
            Alert error1 = new Alert(Alert.AlertType.ERROR, "Select an item to remove!", ButtonType.OK);//FIXME: Error not showing
        }
        else{
            Food food = tblFoodCart.getSelectionModel().getSelectedItem();
            obSelection.remove(lstCart.getSelectionModel().getSelectedItem());
            foodCount--;
            lblCount.setText("Total Items:" + foodCount);
            totalPrice += food.getPrice();
            lblTotal.setText("Total: £"+totalPrice);
        }

    }

    // Observable list where all the food is stored to be displayed in the tableView
    private ObservableList<Food> foodList = FXCollections.observableArrayList(); {
        foodList.add(new Food("Kebab", 43, 53.76));
        foodList.add(new Food("Chicken",65,89.00));
    }

}