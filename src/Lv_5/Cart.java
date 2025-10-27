package Lv_5;

import java.util.List;

public class Cart implements ItemContainer{
    //속
    private List<CartList> list;

    //생
    Cart(List<CartList> list) {
        this.list = list;
    }
    public void addItem(CartList cartlist){
        list.add(cartlist);
    }

    public String printAllMenuItems(int index) {
        String menuTemplate = "";
        for(int j=0;j<getList().size();j++) {

            String blank = "";
            int blankArea = 15 - getName(j).length();

            for (int k = 0; k < blankArea; k++) {
                blank += " ";
            }

            String name = getName(j);
            double price = getPrice(j);
            String description = getDescription(j);
            menuTemplate += formatText(j, name, price, description, blank);
        }
        return menuTemplate;
    }

    String formatText(int index, String name,double price, String description,String blank ){
        String menuTamplate = "";
        menuTamplate += (index + 1) + ". " + name + blank + "|"+" W "+price+" | "+description+"\n";
        return menuTamplate;
    }

    public List<CartList> getList() {
        return list;
    }
    public String getName(int i) {
        return list.get(i).getName();
    }
    public double getPrice(int i) {
        return list.get(i).getPrice();
    }
    public String getDescription(int i) {
        return list.get(i).getDescription();
    }

}
