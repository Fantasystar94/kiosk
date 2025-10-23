package Lv_3;

// Lv_1.Main : 시작 지점이 되는 클래스, public static void main(String[] args)
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 ### Lv 2. 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기

 - [ ]  **요구사항이 가지는 의도**
 - [ ]  객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익힙니다.
 - [ ]  햄버거 메뉴를 `MenuItem` 클래스와 `List`를 통해 관리합니다.

 ---

 - [ ]  **`MenuItem` 클래스 생성하기**
 - [ ]  설명 : 개별 음식 항목을 관리하는 클래스입니다. 현재는 햄버거만 관리합니다.
 - [ ]  클래스는 `이름`, `가격`, `설명` 필드를 갖습니다.
 - [ ]  `main` 함수에서 `MenuItem` 클래스를 활용하여 햄버거 메뉴를 출력합니다.
 - [ ]  `MenuItem` 객체 생성을 통해 `이름`, `가격`, `설명`을 세팅합니다.
 - [ ]  키워드: `new`
 - [ ]  `List`를 선언하여 여러 `MenuItem`을 추가합니다.
 - [ ]  `List<MenuItem> menuItems = new ArrayList<>();`
 - [ ]  반복문을 활용해 `menuItems`를 탐색하면서 하나씩 접근합니다.
 * */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("Shack Burger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        list.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        list.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        list.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
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
        menuTemplate += "0. 종료      | 종료";
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
}