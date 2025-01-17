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
import java.util.*;

//TODO: implement a universal switch scene method which all classes can use

public class Main extends Application {
    @FXML
    public TextField txtCustomers;
    @FXML
    public TextField txtTableID;
    @FXML
    public Button btnNext;
    @FXML
    public TableView<Food> tblFoodCart;
    @FXML
    public TableColumn<Food, String> colItem;
    @FXML
    public TableColumn<Food, Integer> colCals;
    @FXML
    public TableColumn<Food, Double> colPrice;
    @FXML
    public ObservableList<Food> foodList = FXCollections.observableArrayList();
    @FXML
    public ObservableList<Food> obSelection = FXCollections.observableArrayList();
    @FXML
    public ArrayList<Food> finalFoodList = new ArrayList<>();//FIXME: This works but resets after every scene switch
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
    @FXML
    public Button btnCheckout;




    // Counts for all the labels (Price, calories, amount of food)
    int foodCount = 0;
    Double totalPrice = 0.00;
    int totalCals = 0;


    public int getFoodCount() {
        return foodCount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public int getTotalCals() {
        return totalCals;
    }


    public ObservableList<Food> getItemsAsOList(){
        return FXCollections.observableArrayList(finalFoodList);
    }
    public ObservableList<Food> getObList(){
        return obSelection;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // This shows the initial welcome screen
        Parent root = FXMLLoader.load(getClass().getResource("InitialScreen.fxml"));
        primaryStage.setTitle("Restaurant Menu");
        primaryStage.setScene(new Scene(root, 450, 275));
        primaryStage.show();
        primaryStage.setResizable(false);

    }


    public void initialize(){
    }




    void obInitStarters(){
        // initialises the list of food with all the starters
        foodList.add(new Food("Kebab", 43, 4.99));
        foodList.add(new Food("Chicken",65,8.49));
        foodList.add(new Food("Fish", 31, 7.69));
        foodList.add(new Food("Chips",82,3.25));
        foodList.add(new Food("Bread", 52, 1.09));
        foodList.add(new Food("Cheese",40,2.97));
        foodList.add(new Food("Spring Roll", 26, 10.99));
        foodList.add(new Food("Mushroom",97,14.98));
        foodList.add(new Food("Sausage", 74, 4.45));
        foodList.add(new Food("Salad",15,2.75));
        tblFoodCart.setItems(foodList);
    }

    void obInitMains(){
        // initialises food list with all the mains
        foodList.add(new Food("Soup", 60, 5.99));
        foodList.add(new Food("Lasanga", 137, 7.95));
        foodList.add(new Food("Rice n Chicken", 283, 6.45));
        foodList.add(new Food("Turkey", 391, 19.99));
        foodList.add(new Food("Shephards Pie", 179, 5.35));
        foodList.add(new Food("Pasta", 679, 6.49));
        foodList.add(new Food("Parmesan Chicken", 923, 7.89));
        foodList.add(new Food("Roast Chicken", 182, 29.99));
        foodList.add(new Food("Baked Potato", 164, 2.89));
        tblFoodCart.setItems(foodList);
    }

    void obInitDessert(){
        // initialises list with all the desserts
        foodList.add(new Food("Cheesecake", 435, 6.15));
        foodList.add(new Food("Cake & Custard", 263, 3.56));
        foodList.add(new Food("Vanilla Ice cream", 837, 4.86));
        foodList.add(new Food("Banoffee Pie", 182, 9.59));
        foodList.add(new Food("Waffle", 473, 10.49));
        foodList.add(new Food("Cookie Dough", 205, 6.25));
        foodList.add(new Food("Crêpes", 486, 7.39));
        tblFoodCart.setItems(foodList);
    }

    void obInitCheckout(){
        // initialise the observable list for the checkout screen
        // adds current selected items for the tableview
        tblFoodCart.setItems(obSelection);

    }


    void obSelectionInit(){
        obSelection.addListener(new InvalidationListener() {
                                    @Override
                                    public void invalidated(Observable observable) {
                                    }
                                }
        );
        lstCart.setItems(obSelection);



    }


    void initCols(){
        // Linking the columns with the constructors in food.java so we can add the correct info in the correct columns
        colItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        colCals.setCellValueFactory(new PropertyValueFactory<>("calories"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));


    }

    public void addToCart (ActionEvent event){
        Locale locale = new Locale("en", "UK");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);

        //Error catching
        if (tblFoodCart.getSelectionModel().getSelectedIndex() == -1) {
            Alert error = new Alert(Alert.AlertType.ERROR, "Select an item to add!", ButtonType.OK);
            error.showAndWait();
        } else {
            Food food = tblFoodCart.getSelectionModel().getSelectedItem();
            obSelection.add(food);
            finalFoodList.add(food);
            foodCount++;
            totalPrice += food.getPrice();
            totalCals += food.getCalories();
            updateLabels();
            System.out.println(obSelection);
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

    void updateLabels(){
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        lblCount.setText("Total Items: " + foodCount);
        lblTotal.setText("Total: "+cf.format(totalPrice));
        lblCals.setText("Calories: "+ totalCals);

    }

    void passInfo(String tblMsg, Double total, int count, int calories){
        System.out.println("passinfo");
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        lblTblNo.setText(tblMsg);
        totalPrice =+ total;
        totalCals =+ calories;
        foodCount =+ count;
        lblTotal.setText("Total: " + cf.format(total));
        lblCals.setText("Calories: " + calories);
        lblCount.setText("Total Food: " + count);



    }

    void finalPassInfo(String tblMsg, Double total, int count, int calories){
        //passes info to checkout screen
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        lblTblNo.setText(tblMsg);
        totalPrice =+ total;
        totalCals =+ calories;
        foodCount =+ count;
        lblTotal.setText("Total due: " + cf.format(total));
        lblCount.setText("Total Items: " + count);
        lblCals.setText("Total Calories: " + calories);
    }
    void finalPassInfo2(String tblMsg, Double total, int count, int calories){
        //passes info to final order completed screen
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        lblTblNo.setText(tblMsg);
        totalPrice =+ total;
        totalCals =+ calories;
        foodCount =+ count;
        lblTotal.setText("Total paid: " + cf.format(total));
        lblCount.setText("Total Items: " + count);
        lblCals.setText("Total Calories: " + calories);
    }



    public void dataReceiver(ObservableList<Food> list){
        //used to pass info between scenes
        obSelection.addAll(list);

    }

    public void setTitle(String name){
        Stage stage = (Stage) lblTotal.getScene().getWindow();
        stage.setTitle(name);
    }




    public static void main(String[] args) {
        launch(args);
    }
}
