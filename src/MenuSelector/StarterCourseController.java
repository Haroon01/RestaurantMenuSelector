package MenuSelector;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;

import javax.security.auth.callback.Callback;


public class StarterCourseController {
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
    private ObservableList<Food> oblistItems = FXCollections.observableArrayList();
    @FXML
    private Label labelCount;
    @FXML
    private Button btnRemove;
    @FXML
    private TableView<Food> tblFoodCart = new TableView<Food>();
    @FXML
    private TableColumn<Food,String> colItem;
    @FXML
    private TableColumn<Food,Integer> colCals;
    @FXML
    private TableColumn<Food,Double> colPrice;

    private int listCount = 0;


    public void initialize() {


        oblistItems.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("invalidated");
            }
        }
        );

        tblFoodCart.setItems(oblistItems);


    }



    public void addtoList1(ActionEvent event){
        addToList();

    }

//    public void addtoList2(ActionEvent event){
//        addToList(btnStarter2);
//    }
//    public void addtoList3(ActionEvent event){
//        addToList(btnStarter3);
//    }
//    public void addtoList4(ActionEvent event){
//        addToList(btnStarter4);
//    }

    private void addToList(){


        System.out.println("button was pressed");
        listCount++;
        //String choices = b.getText();

        labelCount.setText("Amount of food selected: " + listCount);
        Food starter1 = new Food("Kebab", 350, 4.50);
        Food starter2 = new Food("Fish", 203, 5.60);
        Food starter3 = new Food("Chicken",612, 43.10);
        Food starter4 = new Food("Popadoms", 43, 0.80);
        oblistItems.add(starter1);
        tblFoodCart.setItems(oblistItems);


    }

    public void removeFromList(ActionEvent event){
        if (listItems.getSelectionModel().getSelectedIndex() == -1){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Select an item to remove!", ButtonType.CLOSE);
            alert.showAndWait();
        }
        else{
            oblistItems.remove(listItems.getSelectionModel().getSelectedItem());
            listCount --;
            labelCount.setText("Amount of food selected: " + listCount);
        }
    }


    public void foodList(){

    }
}



//        if (chkStarter2.isSelected()) {
//            listCount++;
//            choices = chkStarter2.getText();
//        }
//        if (chkStarter3.isSelected()) {
//            listCount++;
//            choices = chkStarter3.getText();
//        }
//        if (chkStarter4.isSelected()) {
//            listCount++;
//            choices = chkStarter4.getText();
//        }
