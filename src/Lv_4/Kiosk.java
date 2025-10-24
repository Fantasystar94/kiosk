package Lv_4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Kiosk: 프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    //속
    private Scanner sc = new Scanner(System.in);
    private List<Menu> list;


    //생
    Kiosk(List<Menu> list) {
        this.list = list;
    }
    //기
    void start() {
        boolean flag = true;
        while (true) {
            System.out.println("[ MAIN MENU ]");
            String category = "";
            for(int i=0;i<list.size();i++) {
                category += list.get(i).getMainCategoryName(i);
            }
            System.out.print(category);
            System.out.println("0. 종료     | 종료");
            int b = firstDepth();
            if(b==0) {
                System.out.println("종료합니다.");
                flag = false;
                break;
            }
            secondDepth(b);
        }
    }
    int firstDepth(){
        boolean flag = true;
        int input = sc.nextInt();
        while (flag) {
            try{
                int realInput = input-1;
                if(input >= 1 && input<=list.size()) {
                    System.out.println(list.get(realInput).getMainCategoryName(realInput));
                    flag = false;
                }
                else if(input < 0){
                    System.out.println("올바른 번호를 입력해주세요");
                }
                else{
                    return 0;
                }
            }
            catch(InputMismatchException e){
                System.out.println("주문번호만 입력해주세요");
                sc.nextLine();
            }
        }
        return input;
    }

    void secondDepth(int input){
        boolean flag = true;
        int input2 = 0;
        switch (input) {
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

            for(int j=0;j<list.get(input-1).getList().size();j++) {

                String blank = "";
                String menuTemplate = "";
                int blankArea = 15 - list.get(input - 1).getName(j).length();

                for (int k = 0; k < blankArea; k++) {
                    blank += " ";
                }
                double price = list.get(input - 1).getPrice(j);
                String description = list.get(input - 1).getDescription(j);
                menuTemplate += (j + 1) + ". " + list.get(input - 1).getList().get(j).getName() + blank + "|"+" W "+price+" | "+description;
                System.out.println(menuTemplate);
            }
            System.out.println("0. 뒤로가기 ");
            input2 = sc.nextInt();
                try{
                    int realInput = input2-1;
                    if(input2 >= 1 && input2<=list.get(input-1).getList().size()) {

                        String menuName= list.get(input-1).getList().get(realInput).getName();
                        double price = list.get(input-1).getList().get(realInput).getPrice();
                        String description = list.get(input-1).getList().get(realInput).getDescription();

                        System.out.println("선택한 메뉴:"+" "+menuName+" | "+" W "+price+" | "+description);
                    }
                    else if(input2 == 0){
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


}
