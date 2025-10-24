package Lv_4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Kiosk: 프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    //속
    private List<MenuItem> list;
    private Scanner sc = new Scanner(System.in);

    //생
    Kiosk(List<MenuItem> list) {
        this.list = list;
    }

    //기
    void start() {
        String menuTemplate = setMenuTerminal(list);

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println(menuTemplate);
            try {
                int input = sc.nextInt();
                if (input > 0 && input <= list.size()) {
                    MenuItem selected = list.get(input - 1);
                    System.out.println(selected.name + " (이/가) 주문 되었습니다");
                } else if (input == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                } else {
                    System.out.println("주문번호만 정확히 입력해주세요.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("주문번호만 입력해주세요");
                sc.nextLine();
            }
        }
    }

    // 메뉴명이 일관되게 왼쪽정렬 할 수 있게 만드는 메소드
    private String setMenuTerminal(List<MenuItem> list) {
        String menuTemplate = "";
        for (int i = 0; i<list.size(); i++) {
            String prdName = "";
            String blank ="";
            MenuItem item = list.get(i);
            int blankArea = 15 - item.name.toString().length();
            for (int j = 0;j<blankArea;j++) {
                blank += " ";
                prdName = item.name.toString()+blank;
            }
            menuTemplate += (i+1)+". "+prdName+"|"+" W"+item.price+" | "+item.description+"\n";
        }
        menuTemplate += " 0. 종료      | 종료 ";
        return menuTemplate;
    }

}
