package MenuSelector;

import javafx.collections.ObservableList;

public class PaidController extends Main {

    public void initialize() {
        initCols();
        obInitCheckout();
        tblFoodCart.setItems(getObList());
    }

    public void dataReceiverFinal(ObservableList<Food> list) {
        System.out.println("data received");
        //this.obSelection = list;
        tblFoodCart.setItems(list);

    }
}

