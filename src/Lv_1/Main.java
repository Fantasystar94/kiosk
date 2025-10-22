package Lv_1;

// Lv_1.Main : 시작 지점이 되는 클래스, public static void main(String[] args)
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  Lv 1. 기본적인 키오스크를 프로그래밍해보자
 * - [ ]  **요구사항이 가지는 의도**
 *     - [ ]  입력 처리와 간단한 흐름 제어를 복습합니다. (프로그래밍 검증**)**
 *     - [ ]  `Scanner` 활용법, 조건문, 반복문을 재확인하며 입력 데이터를 처리하는 방법 강화
 * ---
 * - [ ]  **햄버거 메뉴 출력 및 선택하기**
 *     - [ ]  `Scanner`를 사용하여 여러 햄버거 메뉴를 입렵받고 출력합니다.
 *     - [ ]  제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드를 작성합니다.
 *     - [ ]  반복문을 이용해서 특정 번호가 입력되면 프로그램을 종료합니다.
 * */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("" +
                    "[ SHAKESHACK MENU ]\n" +
                    "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                    "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                    "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                    "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n"+
                    "0. 종료      | 종료");
            try{
                int input = sc.nextInt();
                switch(input) {
                    case 1 :
                        System.out.println("ShackBurger (이/가) 주문 되었습니다");
                        break;
                    case 2 :
                        System.out.println("SmokeShack (이/가) 주문 되었습니다");
                        break;
                    case 3 :
                        System.out.println("Cheeseburger (이/가) 주문 되었습니다");
                        break;
                    case 4 :
                        System.out.println("Hamburger (이/가) 주문 되었습니다");
                        break;
                    case 0 :
                        System.out.println("프로그램을 종료합니다.");
                        sc.close();
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