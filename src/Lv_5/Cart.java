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
        String totalPrice = "[ Total ] \n";
        double calcul = 0;
        for (MenuItem item : list.keySet()) {
            calcul += item.getPrice() * list.get(item);
        }
        totalPrice += " W " + calcul;
        return totalPrice;
    }

//    public HashMap<MenuItem, Integer> getCart() {
//        return list;
//    }

    public void removeItem(){
        list.clear();
    }


}
