package MenuSelector;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Food {
    private SimpleStringProperty item;
    private SimpleIntegerProperty calories;
    private SimpleDoubleProperty price;


    public Food(String item, Integer calories, Double price) {
        this.item = new SimpleStringProperty(item);
        this.calories = new SimpleIntegerProperty(calories);
        this.price = new SimpleDoubleProperty(price);
    }

    public String getItem() {
        return item.get();
    }


    public Integer getCalories() {
        return calories.get();
    }

    public Double getPrice() {
        return price.get();
    }



}