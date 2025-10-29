package Lv_5;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Cart {
    //속
    private Map<MenuItem, Integer> list = new HashMap<MenuItem, Integer>();

    //생
    public void addItem(MenuItem item, int quantity) {
        if (list.containsKey(item)) {
            int currentQ = list.get(item);
            System.out.println(currentQ);
            currentQ += quantity;
            list.put(item, currentQ);
        } else {
            list.put(item, quantity);
        }

    }

    public int getCartSize() {
        return list.size();
    }


    public String printAllCartItems() {
        String orderListPrint = "";
        for (MenuItem item : list.keySet()) {
            orderListPrint += item.getName() + " | " + " W " + item.getPrice() + " | " + item.getDescription() + " | " + list.get(item) + "개 " + "\n";
        }
        return orderListPrint;
    }

    public String printTotalPrice() {
        double calcul = 0;
        for (MenuItem item : list.keySet()) {
            calcul += item.getPrice() * list.get(item);
        }
        String totalPrice = String.format("[ Total ] \n W %.1f",calcul);
        return totalPrice;
    }

    public double calculateDiscountedPrice(int discount) {
        double calculatedPrice = 0;
        for (MenuItem item : list.keySet()) {
            calculatedPrice += item.getPrice() * list.get(item);
        }
        switch (discount) {
            case 1 :
                calculatedPrice = calculatedPrice - calculatedPrice * 0.1;
                break;
            case 2 :
                calculatedPrice = calculatedPrice - calculatedPrice * 0.05;
                break;
            case 3 :
                calculatedPrice = calculatedPrice - calculatedPrice * 0.03;
                break;
            case 4 :
                calculatedPrice = calculatedPrice;
                break;
            default :
                calculatedPrice = calculatedPrice;
        }
        return calculatedPrice;
    }

    public void removeItem() {
        list.clear();
    }


}
