package MenuSelector;

import javafx.application.Application;
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

import java.text.NumberFormat;
import java.util.Locale;

public class Main extends Application {

    @FXML
    public TableView<Food> tblFoodCart;
    @FXML
    public TableColumn<Food, String> colItem;
    @FXML
    public TableColumn<Food, Integer> colCals;
    @FXML
    public TableColumn<Food, Double> colPrice;
    @FXML
    public ObservableList<Food> obSelection = FXCollections.observableArrayList();
    @FXML
    public ListView<Food> lstCart;
    @FXML
    public Label lblCount;
    @FXML
    public Label lblTotal;
    @FXML
    public Label lblCals;
    @FXML
    public Label lblTblNo;


    // Counts for all the labels (Price, calories, amount of food)
    int foodCount = 0;
    Double totalPrice = 0.00;
    int totalCals = 0;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("InitialScreen.fxml"));
        primaryStage.setTitle("Restaurant Menu");
        primaryStage.setScene(new Scene(root, 450, 275));
        primaryStage.show();
        primaryStage.setResizable(false);


//        Parent root2 = FXMLLoader.load(getClass().getResource("InitialScreen.fxml"));
//        primaryStage.setScene(new Scene(root2, 450, 275));
//        primaryStage.show();
    }

    // @Override
    public void initialize() {


        System.out.println("initialise method has been executed."); // debugging check to see if this method is being executed

        obSelection.addListener(new InvalidationListener() {
                                    @Override
                                    public void invalidated(Observable observable) {
                                    }
                                }
        );

        lstCart.setItems(obSelection);



        // Linking the columns with the constructors in food.java so we can add the correct info in the correct columns
        colItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        colCals.setCellValueFactory(new PropertyValueFactory<>("calories"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));


        // Add all items from Observable list to the tableView
        tblFoodCart.setItems(foodList);

        updateLabels();

    }




    public void addToCart (ActionEvent event){
        Locale locale = new Locale("en", "UK");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        if (tblFoodCart.getSelectionModel().getSelectedIndex() == -1) {
            Alert error = new Alert(Alert.AlertType.ERROR, "Select an item to add!", ButtonType.OK);
            error.showAndWait();
        } else {
            Food food = tblFoodCart.getSelectionModel().getSelectedItem();
            obSelection.add(food);
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
            Food food = lstCart.getSelectionModel().getSelectedItem();
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


    public static void main(String[] args) {
        launch(args);
    }
}
