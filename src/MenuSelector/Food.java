package MenuSelector;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.Locale;


public class Food {
    // We need to use SimpleStringProperty here since this is for observable types which go with observable lists
    private SimpleStringProperty item;
    private SimpleIntegerProperty calories;
    private SimpleDoubleProperty price;


    public Food(String item, Integer calories, Double price) {
        this.item = new SimpleStringProperty(item);
        this.calories = new SimpleIntegerProperty(calories);
        this.price = new SimpleDoubleProperty(price);
    }

    @Override
    public String toString() {
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        return "" + this.getItem();
    }

    public String getItem() {
        return item.get();
    }


    public Integer getCalories() {
        return calories.get();
    }

    public SimpleStringProperty itemProperty() {
        return item;
    }

    public SimpleIntegerProperty caloriesProperty() {
        return calories;
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }


    public Double getPrice() {
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        return price.get();
    }



}