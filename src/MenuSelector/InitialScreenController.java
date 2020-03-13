package MenuSelector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;

public class InitialScreenController {

    @FXML
    private TextField txtCustomer;
    @FXML
    private TextField txtTableID;
    @FXML
    private Button btnNext;

    public TextField getTxtCustomer() {
        return txtCustomer;
    }

    public TextField getTxtTableID() {
        return txtTableID;
    }

    public void nextScene(ActionEvent event) throws IOException{

        // This method will replace InitialScreen Scene with StarterCourseScreen Scene.

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("StarterCourseScreen.fxml"));



        Scene scene = new Scene(root);

        Stage window = (Stage) btnNext.getScene().getWindow(); // use any button/label etc to grab info about current scene

        window.setScene(scene);

        window.show();

        window.setTitle("Select Starter");
        window.setHeight(400);
        window.setWidth(600);


    }

    private void getInfo(){
        //TODO: Get table number and pass to StarterCourseController.java
        // Gets Table Number and amount of customers
        String tblNo = txtTableID.getText();
        String NoOfCust = txtCustomer.getText();


    }





}
