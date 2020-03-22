package MenuSelector;


import java.text.NumberFormat;
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

}
