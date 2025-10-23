package Lv_3;

// Lv_1.Main : 시작 지점이 되는 클래스, public static void main(String[] args)
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 ### Lv 3. 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기

 - [ ]  **요구사항이 가지는 의도**
 - [ ]  객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익힙니다.
 - [ ]  `main` 함수에서 관리하던 전체 순서 제어를 `Kiosk` 클래스를 통해 관리합니다.
 - [ ]  **`Kiosk` 클래스 생성하기**
 - [ ]  **설명**: 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스입니다.
 - [ ]  `MenuItem`을 관리하는 리스트가 필드로 존재합니다.
 - [ ]  `main` 함수에서 관리하던 입력과 반복문 로직은 이제 `start` 함수를 만들어 관리합니다.
 - [ ]  `List<MenuItem> menuItems` 는 `Kiosk` 클래스 생성자를 통해 값을 할당합니다.
 - [ ]  `Kiosk` 객체를 생성하고 사용하는 `main` 함수에서 객체를 생성할 때 값을 넘겨줍니다.
 - [ ]  요구사항에 부합하는지 검토
 - [ ]  키오스크 프로그램을 시작하는 메서드가 구현되어야 합니다.
 - [ ]  콘솔에 햄버거 메뉴를 출력합니다.
 - [ ]  사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료합니다.
 - [ ]  유효하지 않은 입력에 대해 오류 메시지를 출력합니다.
 - [ ]  `0`을 입력하면 프로그램이 ‘뒤로가기’되거나 ‘종료’됩니다.
 * */

public class Main {
    public static void main(String[] args) {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("Shack Burger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        list.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        list.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        list.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        Kiosk kiosk = new Kiosk(list);
        kiosk.start();
    }
}