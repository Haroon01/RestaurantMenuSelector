package MenuSelector;

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
    private Button btnStarter1;
    @FXML
    private Button btnStarter2;
    @FXML
    private Button btnStarter3;
    @FXML
    private Button btnStarter4;
    @FXML
    private ListView<String> listItems;
    @FXML
    private Label labelCount;
    @FXML
    private Button btnRemove;
    @FXML
    private TableView<Food> tblFoodCart;
    @FXML
    private TableColumn<Food, String> colItem;
    @FXML
    private TableColumn<Food, Integer> colCals;
    @FXML
    private TableColumn<Food, Double> colPrice;

    private int listCount = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialise method has been executed.");

//        TableColumn<Food, String> colItem = new TableColumn<>("item");
//        TableColumn<Food, Integer> colCals = new TableColumn<>("calories");
//        TableColumn<Food, Double> colPrice = new TableColumn<>("Price");

        colItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        colCals.setCellValueFactory(new PropertyValueFactory<>("calories"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tblFoodCart.setItems(getFood());
        System.out.println(getFood());
    }

    public ObservableList<Food> getFood() {
        ObservableList<Food> foodList = FXCollections.observableArrayList();
        foodList.add(new Food("Kebab", 43, 53.76));
        return foodList;
    }

//    public ObservableList<Food>  getFood()
//    {
//        ObservableList<Food> oblist = FXCollections.observableArrayList();
//        oblist.add(new Food("Mr.",78,43.56));
//
//        return oblist;
//    }


    public void addtoList1(ActionEvent event) {
        addToList();

    }

    public void addtoList2(ActionEvent event) {
        addToList();
    }

    public void addtoList3(ActionEvent event) {
        addToList();
    }

    public void addtoList4(ActionEvent event) {
        addToList();
    }

    private void addToList() {

    }



//        System.out.println("button was pressed");
//        listCount++;
//        //String choices = b.getText();
//
//        labelCount.setText("Amount of food selected: " + listCount);
//        Food starter1 = new Food("Kebab", 350, 4.50);
//        Food starter2 = new Food("Fish", 203, 5.60);
//        Food starter3 = new Food("Chicken",612, 43.10);
//        Food starter4 = new Food("Popadoms", 43, 0.80);
//        oblistItems.add(starter1);
//        tblFoodCart.setItems(oblistItems);




    public void removeFromList(ActionEvent event) {
//        if (listItems.getSelectionModel().getSelectedIndex() == -1){
//            Alert alert = new Alert(Alert.AlertType.ERROR, "Select an item to remove!", ButtonType.CLOSE);
//            alert.showAndWait();
//        }
//        else{
//            oblistItems.remove(listItems.getSelectionModel().getSelectedItem());
//            listCount --;
//            labelCount.setText("Amount of food selected: " + listCount);
//
    }
}