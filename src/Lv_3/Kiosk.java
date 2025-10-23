package Lv_3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Kiosk: 프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    //속
    private List<MenuItem> list = new ArrayList<>();
    //생
    Kiosk(List<MenuItem> list) {
        this.list = list;
    }
    //기
    public void start() {
        Scanner sc = new Scanner(System.in);
        String menuTemplate = setMenuTerminal(list);

        while(true){
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println(menuTemplate);
            try{
                int input = sc.nextInt();
                switch(input) {
                    case 1 :
                        System.out.println(list.get(input-1).name.toString()+" (이/가) 주문 되었습니다");
                        break;
                    case 2 :
                        System.out.println(list.get(input-1).name.toString()+" (이/가) 주문 되었습니다");
                        break;
                    case 3 :
                        System.out.println(list.get(input-1).name.toString()+" (이/가) 주문 되었습니다");
                        break;
                    case 4 :
                        System.out.println(list.get(input-1).name.toString()+" (이/가) 주문 되었습니다");
                        break;
                    case 0 :
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("주문번호만 정확히 입력해주세요.");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("주문번호만 입력해주세요");
                sc.nextLine();
            }
        }
    }

    // 메뉴명이 일관되게 왼쪽정렬 할 수 있게 만드는 메소드
    private String setMenuTerminal(List<MenuItem> list) {
        String menuTemplate = "";
        for(int i = 0; i<list.size(); i++) {
            String prdName = "";
            String blank ="";
            int blankArea = 15 - list.get(i).name.toString().length();
            for(int j = 0;j<blankArea;j++){
                blank += " ";
                prdName = list.get(i).name.toString()+blank;
            }
            menuTemplate += (i+1)+". "+prdName+"|"+" W"+list.get(i).price+" | "+list.get(i).description+"\n";
        }
        menuTemplate += " 0. 종료      | 종료 ";
        return menuTemplate;
    }

}
