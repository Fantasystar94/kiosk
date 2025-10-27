package Lv_5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Kiosk: 프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    //속
    private Scanner sc = new Scanner(System.in);
    private List<Menu> list;
    private int firstInput;
    private int secondInput;
    private int thirdInput;
    //생
    Kiosk(List<Menu> list) {
        this.list = list;
    }
    //기
    public int getFirstInput() {
        return firstInput;
    }

    public void setFirstInput(int firstInput) {
        this.firstInput = firstInput;
    }

    public int getSecondInput() {
        return secondInput;
    }

    public void setSecondInput(int secondInput) {
        this.secondInput = secondInput;
    }

    public int getThirdInput() {
        return thirdInput;
    }

    public void setThirdInput(int thirdInput) {
        this.thirdInput = thirdInput;
    }


    void start() {
        boolean firstDepthExit = true;
        while (true) {
            System.out.println("[ MAIN MENU ]");
            String category = "";
            for(int i=0;i<list.size();i++) {
                category += list.get(i).getMainCategoryName(i);
            }
            System.out.print(category);
            System.out.println("0. 종료     | 종료");
            firstDepthExit = firstDepth();
            if(!firstDepthExit) {
                break;
            }
            secondDepth();
        }
    }
    boolean firstDepth() {
        boolean flag = true;
        setFirstInput(sc.nextInt());
        while (flag) {
            try{
                int realInput = firstInput-1;
                if(firstInput >= 1 && firstInput<=list.size()) {
                    System.out.println(list.get(realInput).getMainCategoryName(realInput));
                    flag = false;
                }
                else if(firstInput < 0){
                    System.out.println("올바른 번호를 입력해주세요");
                }
                else{
                    System.out.println("종료합니다.");
                    return false;
                }
            }
            catch(InputMismatchException e){
                System.out.println("주문번호만 입력해주세요");
                sc.nextLine();
            }
        }
        return true;
    }

    void secondDepth() {
        boolean flag = true;

        switch (getFirstInput()) {
            case 1 :
                System.out.println("[ BURGERS MENU ]");
                break;
            case 2 :
                System.out.println("[ Drink MENU ]");
                break;
            case 3 :
                System.out.println("[ Dessert MENU ]");
                break;
        }
        while(flag) {

            for(int j=0;j<list.get(getFirstInput()-1).getList().size();j++) {

                String blank = "";
                String menuTemplate = "";
                int blankArea = 15 - list.get(getFirstInput() - 1).getName(j).length();

                for (int k = 0; k < blankArea; k++) {
                    blank += " ";
                }

                String name = list.get(getFirstInput() - 1).getList().get(j).getName();
                double price = list.get(getFirstInput() - 1).getPrice(j);
                String description = list.get(getFirstInput() - 1).getDescription(j);

                menuTemplate = formatText(j, name, price, description, blank);

                System.out.println(menuTemplate);
            }
            System.out.println("0. 뒤로가기 ");
            setSecondInput(sc.nextInt());

                try{
                    int realInput = secondInput-1;
                    if (secondInput >= 1 && secondInput<=list.get(getFirstInput()-1).getList().size()) {

                        String menuName = list.get(getFirstInput()-1).getList().get(realInput).getName();
                        double price = list.get(getFirstInput()-1).getList().get(realInput).getPrice();
                        String description = list.get(getFirstInput()-1).getList().get(realInput).getDescription();

                        System.out.println( "선택한 메뉴:"+" "+ menuName +" | "+" W "+ price +" | "+ description );
                        thirdDepth();
                    }
                    else if (secondInput == 0) {
                        flag = false;
                    }
                    else {
                        System.out.println("올바른 번호를 입력해주세요");
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("주문번호만 입력해주세요");
                    sc.nextLine();
                }
            flag = false;
        }
    }
    // 규칙 만들자.
    void thirdDepth() {
        boolean flag = true;
        while (flag) {
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인     | 2. 취소     ");
            setThirdInput(sc.nextInt());
            try{
              if (getThirdInput() == 1) {
                 String select = list.get(getFirstInput()-1).getList().get(getSecondInput()-1).getName();
                  System.out.println(select+" 이/가 장바구니에 추가되었습니다.");
                  flag = false;
              }
            }
            catch (InputMismatchException e) {

            }
        }
    }


    String formatText(int index, String name,double price, String description,String blank ){
        String menuTamplate = "";
        menuTamplate += (index + 1) + ". " + name + blank + "|"+" W "+price+" | "+description;
        return menuTamplate;
    }
}
