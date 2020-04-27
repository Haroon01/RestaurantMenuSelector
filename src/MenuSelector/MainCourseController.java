package MenuSelector;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Window;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;


public class MainCourseController extends Main {

    @Override
    public void initialize() {
        initCols();
        obInitMains();
        obSelectionInit();
        setTotal(getTotalPrice());

    }

    public void nextScene(ActionEvent event) throws IOException {

        Window mainWindow = lblTotal.getScene().getWindow();

        // create an instance of the Loader which is used to open the next screen.
        FXMLLoader loader = new FXMLLoader();
        //set the location
        loader.setLocation(getClass().getResource("DessertCourseScreen.fxml"));
        // add loader to root
        Parent root = loader.load();
        //get the controller of the loader just created
        DessertCourseController screen2Controller = loader.getController();
        //call method which receives data in new controller and pass it the value required.
        screen2Controller.dataReceiver(getObList());
        screen2Controller.passInfo(lblTblNo.getText(),getTotalPrice(), getFoodCount(), getTotalCals());

        setTitle("Select Dessert");
        mainWindow.getScene().setRoot(root);

    }




    void setTotal(Double total){
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        totalPrice =+ total;
        lblTotal.setText("Total: "+ cf.format(total));
    }






}
