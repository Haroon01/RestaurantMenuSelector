package MenuSelector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;

public class InitialScreenController extends Main {

    @FXML
    private TextField txtCustomers;
    @FXML
    public TextField txtTableID;
    @FXML
    private Button btnNext;

    public void nextScene(ActionEvent event) throws IOException{
            if (txtTableID.getText().isEmpty() || txtCustomers.getText().isEmpty()){
                Alert error = new Alert(Alert.AlertType.ERROR, "Error: Missing Table Number or Amount of Customers.", ButtonType.OK);
                error.showAndWait();
            }
            else{

                FXMLLoader loader = new FXMLLoader(getClass().getResource("StarterCourseScreen.fxml"));
                Parent root = loader.load();


                Scene scene = new Scene(root);

                Stage window = (Stage) btnNext.getScene().getWindow(); // use any button/label etc to grab info about current scene

                window.setScene(scene);

                window.show();

                window.setTitle("Select Starter");
                window.setHeight(400);
                window.setWidth(600);

                StarterCourseController c2 = loader.getController();//INFO: These 2 lines send userinput from txtTableID to lblTblNo in StarterCourseController class

                c2.setTblNo("Table Number: " + txtTableID.getText());

            }

    }

}
