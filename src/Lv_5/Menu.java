package Lv_5;

import java.util.List;

// Menu: MenuItem 클래스를 관리하는 클래스
// 예시 : 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
public class Menu {
    //속
    private List<MenuItem> list;
    private String categoryName;
    //생
    Menu(List<MenuItem> list, String categoryName) {
        this.list = list;
        this.categoryName = categoryName;
    }

    //기

    public List<MenuItem> getMenuItemList() {
        return list;
    }
    public String getMainCategoryName() {
        return categoryName;
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
    public int getMenuSize() {
        return list.size();
    }

    public String printAllMenuItems() {
        String menuTemplate = "[ " + getMainCategoryName() + " ]"+ "\n" ;
        for(int j = 0;j < getMenuSize(); j++) {

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
        menuTemplate += "0. 뒤로가기";
        return menuTemplate;
    }

    String formatText(int index, String name,double price, String description, String blank ){
        String menuTamplate = "";
        menuTamplate += (index + 1) + ". " + name + blank + "|"+" W "+price+" | "+description+"\n";
        return menuTamplate;
    }

}


