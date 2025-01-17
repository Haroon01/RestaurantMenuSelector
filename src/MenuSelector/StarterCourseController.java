package MenuSelector;

/**
 *
 * Tasks for a pass:
 * Provide a choice of 4 starters, 6 mains and 4 desserts
 * Enable 2 customers to select a 1-3 course meal
 * enable them to enter table number and amount of diners
 * submit button which simulates sending info to the kitchen
 * clear the screen for next customer
 * Display the total order with table number, calories and price
 * enable a meal to be paid in cash and display a receipt
 *
 */


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.stage.Window;
import java.io.IOException;



public class StarterCourseController extends Main{

    @Override
    public void initialize() {
        // Add all items from Observable list to the tableView
        initCols();
        obInitStarters();
        obSelectionInit();


    }





    public void nextScene(ActionEvent event) throws IOException {


        Window mainWindow = lblTotal.getScene().getWindow();


        // create an instance eof the Loader which is used to open the next screen.
        FXMLLoader loader = new FXMLLoader();
        //set the location
        loader.setLocation(getClass().getResource("MainCourseScreen.fxml"));
        // add loader to root
        Parent root = loader.load();
        //get the controller of the loader just created
        MainCourseController screen2Controller = loader.getController();
        //call method which receives data in new controller and pass it the value required.
        screen2Controller.dataReceiver(getObList());
        screen2Controller.passInfo(lblTblNo.getText(),getTotalPrice(), getFoodCount(), getTotalCals());

        setTitle("Select Mains");

        mainWindow.getScene().setRoot(root);
    }



}