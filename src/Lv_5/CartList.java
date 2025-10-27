package Lv_5;

import java.util.ArrayList;
import java.util.List;
public class CartList  {
    //속
    private String name;
    private double price;
    private String description;
    //생
    CartList(String name,double price,String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    //기
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public String toString(){
        return name;
    }

}
