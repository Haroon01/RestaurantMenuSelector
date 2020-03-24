package MenuSelector;


import javafx.collections.ObservableList;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CheckoutController extends Main {

    public void initialize() {

        initCols();
        obInitCheckout();

        setTotal(getTotalPrice());

    }

    void setTotal(Double total){
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        totalPrice =+ total;
        lblTotal.setText("Total prioe to pay: "+ cf.format(total));
    }
    public void dataReceiverFinal(ObservableList<Food> list){
        System.out.println("data received");
        //this.obSelection = list;
        tblFoodCart.setItems(list);

    }

}
