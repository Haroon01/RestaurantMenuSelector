package MenuSelector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.IOException;

import static java.lang.Double.parseDouble;

public class PayCashController extends Main{
    @FXML
    public TextField txtfldCash;
    @FXML
    public Button btnCashSubmit;


    public void initialize(){

    }

    public void handler(ActionEvent e) throws IOException{
        paid();
        returnToCheckout();
    }

    private String paid(){
        String strCashPaid = txtfldCash.getText();
        Double cashPaid = parseDouble(strCashPaid);
        Double change = (cashPaid - getTotalPrice());
        System.out.println(getTotalPrice());
        return "Total Cash Paid: " + cashPaid + " | Total Change Due: " + change;

    }

    private void returnToCheckout() throws IOException {
        Window mainWindow = btnCashSubmit.getScene().getWindow();

        // create an instance eof the Loader which is used to open the next screen.
        FXMLLoader loader = new FXMLLoader();
        //set the location
        loader.setLocation(getClass().getResource("CheckoutScreen.fxml"));
        // add loader to root
        Parent root = loader.load();
        //get the controller of the loader just created
        CheckoutController screen2Controller = loader.getController();
        //call method which receives data in new controller and pass it the value required.
        screen2Controller.dataReceiverChck(paid());
        mainWindow.getScene().setRoot(root);
    }

}
