package MenuSelector;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;


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
    private ObservableList<String> oblistItems = FXCollections.observableArrayList();
    @FXML
    private Label labelCount;
    @FXML
    private Button btnRemove;


    private int listCount = 0;


    public void initialize() {


        oblistItems.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("invalidated");
            }
        }
        );

        listItems.setItems(oblistItems);


    }

    public void addtoList1(ActionEvent event){
        addToList(btnStarter1);
    }

    public void addtoList2(ActionEvent event){
        addToList(btnStarter2);
    }
    public void addtoList3(ActionEvent event){
        addToList(btnStarter3);
    }
    public void addtoList4(ActionEvent event){
        addToList(btnStarter4);
    }

    private void addToList(Button b){

       // int listCount = 0;
       // String choices = "";

        System.out.println("button was pressed");
        listCount++;
        String choices = b.getText();

        labelCount.setText("Amount of food selected: " + listCount);
        oblistItems.add(choices);


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
