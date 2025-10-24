package Lv_4;

// Lv_1.Main : 시작 지점이 되는 클래스, public static void main(String[] args)
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 ### Lv 4. 객체 지향 설계를 적용해 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기

 - [ ]  **`Menu` 클래스 생성하기**
 - [ ]  설명 : MenuItem 클래스를 관리하는 클래스입니다.
 예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 `MenuItem`을 포함합니다.
 - [ ]  `List<MenuItem>` 은 `Kiosk` 클래스가 관리하기에 적절하지 않으므로 Menu 클래스가 관리하도록 변경합니다.
 - [ ]  여러 버거들을 포함하는 상위 개념 ‘버거’ 같은 `카테고리 이름` 필드를 갖습니다.
 - [ ]  메뉴 카테고리 이름을 반환하는 메서드가 구현되어야 합니다.
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