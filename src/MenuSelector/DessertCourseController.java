package MenuSelector;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

        // Parent root = FXMLLoader.load(getClass().getResource("MainCourseScreen.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CheckoutScreen.fxml"));
        Parent root = loader.load();
        CheckoutController b2 = loader.getController();
        b2.finalPassInfo(lblTblNo.getText(),getTotalPrice(), getFoodCount(), getTotalCals(), getObList());
        //m2.setTblNo(txtTableID.getText());
        Stage window = (Stage) lblTotal.getScene().getWindow();
        window.setTitle("Choose Main Course");
        window.setScene(new Scene(root, 600, 400));
        System.out.println(totalCals);
        //updateTotals(totalCals);
        window.show();


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
