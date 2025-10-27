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

    public List<MenuItem> getList() {
        return list;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public String getMainCategoryName(int i) {
        return i+1+". "+categoryName+"\n";
    }
    public String getMenusOrder(int i) {
            return list.get(i).getName()+list.get(i).getPrice()+list.get(i).getDescription();
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


