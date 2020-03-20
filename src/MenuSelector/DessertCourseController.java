package MenuSelector;

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
