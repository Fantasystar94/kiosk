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
    private List<MenuItem> menuItem;
    private int inputs;
    private Menu selectedMenu;
    private MenuItem selectedMenuItem;
    private Cart cart = new Cart(new ArrayList<CartList>());
    //생
    Kiosk(List<Menu> list) {
        this.list = list;
    }
    //기
    void start() {
        while (true) {

            //1. 카테고리 처리
            selectedMenu = handleCategory();

            if(selectedMenu == null ) {
                break;
            }
            //2. 메뉴아이템 처리
            selectedMenuItem = handleMenuList();
            if (selectedMenuItem == null ) {
                continue;
            }
            //3. 장바구니 처리
            // ../
        }
    }

    Menu handleCategory() {
        // 1. 카테고리 메뉴 출력
        while( true ) {
            String category = "[ MAIN MENU ]" + "\n";
            for(int i = 0; i < list.size(); i++) {
                category += (i+1) + ". " + list.get(i).getMainCategoryName() + "\n";
            }
            category += "0. 종료     | 종료";
            System.out.println(category);

            // 2. 카테고리 입력받기
            System.out.println("원하는 카테고리를 선택해주세요");
            int inputs = scanningIntegerInput();

            // 3. 입력값에 해당하는 카테고리 출력하기
            if ( inputs >= 1 && inputs <= list.size()) {
                Menu selectedMenu = list.get( inputs - 1 );
                return selectedMenu;
            } else if ( inputs == 0 ) {
                System.out.println("종료합니다. ");
                return null;
            } else {
                System.out.println("올바른 숫자를 입력해주세요");
            }
        }
    }

    MenuItem handleMenuList() {
        // 1. 메뉴아이템 출력
        String menutemplate = selectedMenu.printAllMenuItems();
        System.out.println(menutemplate);
        MenuItem selectedItem;
        // 2. 선택할 메뉴아이템 입력받기
        System.out.println("원하는 메뉴를 선택해주세요");
        int inputs = scanningIntegerInput();

        // 3. 입력값에 해당하는 메뉴아이템 입력받기
        if ( inputs >= 1 && inputs <= selectedMenu.getMenuSize() ) {
            int index = inputs - 1;
            // 4. 입력값에 해당하는 메뉴아아이템 생성하기
            selectedItem = selectedMenu.getMenuItemList().get(index);
            // 5. 입력값에 해당하는 메뉴아아이템 출력하기
            System.out.println( "선택한 메뉴:" + " "+ selectedItem.getName() + " | " + " W "+ selectedItem.getPrice() + " | " + selectedItem.getDescription() );

            return selectedItem;
        } else if ( inputs == 0 ) {
            return null;
        }

        return null;
    }

    int scanningIntegerInput() {
        int input = 0;
        while( true ) {
            try {
                input = sc.nextInt();
                if (input >= 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("올바른 숫자를 입력해주세요.");
                sc.nextLine();

            }
        }
        return input;
    }



    //2. 메뉴 리스트 선택
//    void secondDepth() {
//        boolean flag = true;
//
//        switch (firstInput) {
//            case 1 :
//                System.out.println("[ BURGERS MENU ]");
//                break;
//            case 2 :
//                System.out.println("[ Drink MENU ]");
//                break;
//            case 3 :
//                System.out.println("[ Dessert MENU ]");
//                break;
//        }
//        while(flag) {
//            String printAllMenuItems = list.get(firstInput-1).printAllMenuItems();
//            System.out.println(printAllMenuItems);
//            System.out.println("0. 뒤로가기 ");
//            secondInput = sc.nextInt();
//
//                try{
//                    int realInput = secondInput-1;
//                    if (secondInput >= 1 && secondInput <= list.get(firstInput-1).getList().size()) {
//
//                        String menuName = list.get(firstInput-1).getList().get(realInput).getName();
//                        double price = list.get(firstInput-1).getList().get(realInput).getPrice();
//                        String description = list.get(firstInput-1).getList().get(realInput).getDescription();
//
//                        System.out.println( "선택한 메뉴:"+" "+ menuName +" | "+" W "+ price +" | "+ description );
//                        //올바른 메뉴가 선택된 상태일 경우 세번째 선택과정으로
//                        thirdDepth();
//                    }
//                    else if (secondInput == 0) {
//                        break;
//                    }
//                    else {
//                        System.out.println("올바른 번호를 입력해주세요");
//                    }
//                }
//                catch(InputMismatchException e){
//                    System.out.println("주문번호만 입력해주세요");
//                    sc.nextLine();
//                }
//            flag = false;
//        }
//    }
//    //3. 장바구니 선택
//    void thirdDepth() {
//        boolean flag = true;
//        while (flag) {
//            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
//            System.out.println("1. 확인     | 2. 취소     ");
//            thirdInput = sc.nextInt();
//            try{
//
//                if (thirdInput == 1) {
//
//                    String select = list.get(firstInput-1).getList().get(secondInput-1).getName();
//                    double price = list.get(firstInput-1).getList().get(secondInput-1).getPrice();
//                    String description = list.get(firstInput-1).getList().get(secondInput-1).getDescription();
//                    System.out.println(select+" 이/가 장바구니에 추가되었습니다.");
//                    //장바구니 추가
//                    CartList cartlist = new CartList(select, price, description);
//                    cart.addItem(cartlist);
//
//                    //장바구니 보여주기
//                    showOrderList();
//
//                    flag = false;
//                }
//                else if (thirdInput == 2) {
//                    flag = false;
//                    System.out.println("취소되었습니다");
//                }
//            }
//            catch (InputMismatchException e) {
//                System.out.println("주문번호만 입력해주세요");
//                sc.nextLine();
//            }
//        }
//    }
//    //4. 장바구니 보여주기
//    void showOrderList() {
//        boolean flag = true;
//
//        while(flag) {
//            System.out.println("[ Orders ]");
//            System.out.println(cart.printAllMenuItems());
//            System.out.println("[Total]");
//            System.out.println(cart.printTotalPrice());
//            System.out.println();
//            System.out.println("1. 주문     |  2. 메뉴판");
//            fourthInput = sc.nextInt();
//            try{
//                if( fourthInput == 1) {
//                    System.out.println("주문이 완료되었습니다. 금액은"+cart.printTotalPrice()+" 입니다.");
//                    cart.removeItem();
//                }
//                else if(fourthInput == 2) {
//                    System.out.println("메뉴판으로 돌아갑니다.");
//                }
//                else {
//                    System.out.println("주문 혹은 메뉴판만 선택해주세요");
//                }
//                flag = false;
//            }
//            catch(InputMismatchException e) {
//                System.out.println("주문 혹은 메뉴판만 선택해주세요");
//                sc.nextLine();
//            }
//        }
//    }
}
