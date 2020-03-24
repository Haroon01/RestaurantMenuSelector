package MenuSelector;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class DessertCourseController extends Main {

    @Override
    public void initialize() {
        initCols();
        obInitDessert();
        obSelectionInit();
        setTotal(getTotalPrice());
        //updateTotals(totalCals);
    }

    public void nextScene(ActionEvent event) throws IOException {

        Window mainWindow = lblTotal.getScene().getWindow();

        // create an instance eof the Loader which is used to open the next screen.
        FXMLLoader loader = new FXMLLoader();
        //set the location
        loader.setLocation(getClass().getResource("CheckoutScreen.fxml"));
        // add loader to root
        Parent root = loader.load();
        //get the controller of the loader just created
        CheckoutController screen2Controller = loader.getController();
        //call method which receives data in new controller and pass it the value required.
        screen2Controller.dataReceiverFinal(getObList());
        screen2Controller.finalPassInfo(lblTblNo.getText(),getTotalPrice(), getFoodCount(), getTotalCals());

        mainWindow.getScene().setRoot(root);
//
//        // Parent root = FXMLLoader.load(getClass().getResource("MainCourseScreen.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("CheckoutScreen.fxml"));
//        Parent root = loader.load();
//        CheckoutController c = loader.getController();
//        c.finalPassInfo(lblTblNo.getText(),getTotalPrice(), getFoodCount(), getTotalCals(), getObList());
//        //m2.setTblNo(txtTableID.getText());
//        Stage window = (Stage) lblTotal.getScene().getWindow();
//        window.setTitle("Choose Main Course");
//        window.setScene(new Scene(root, 600, 400));
//        System.out.println(totalCals);
//        //updateTotals(totalCals);
//        window.show();


    }




    public void setTblNo(String message){
        lblTblNo.setText(message);
    }

    void setTotal(Double total){
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        totalPrice =+ total;
        lblTotal.setText("Total: "+ cf.format(total));
    }



}
