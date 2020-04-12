package MenuSelector;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Window;

import java.io.IOException;

public class PaidController extends Main {

    public void initialize() {
        initCols();
        obInitCheckout();
        tblFoodCart.setItems(getObList());
    }

    public void dataReceiverFinal(ObservableList<Food> list) {
        tblFoodCart.setItems(list);

    }

    public void nextScene(ActionEvent event) throws IOException {

        Window mainWindow = lblTotal.getScene().getWindow();

        // create an instance eof the Loader which is used to open the next screen.
        FXMLLoader loader = new FXMLLoader();
        //set the location
        loader.setLocation(getClass().getResource("InitialScreen.fxml"));
        // add loader to root
        Parent root = loader.load();
        //get the controller of the loader just created
        InitialScreenController screen2Controller = loader.getController();
        //call method which receives data in new controller and pass it the value required.
        setTitle("Restaurant Menu");
        mainWindow.setHeight(290);
        mainWindow.setWidth(470);

        mainWindow.getScene().setRoot(root);


    }
}

