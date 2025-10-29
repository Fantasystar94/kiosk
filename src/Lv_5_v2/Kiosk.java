package Lv_5_v2;

import java.util.*;

// Kiosk: 프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    //속
    private Scanner sc = new Scanner(System.in);
    private List<Menu> list;
    private Menu selectedMenu;
    private MenuItem selectedMenuItem;
    private int amount;
    private Cart cart;
    //생
    Kiosk(List<Menu> list,Cart cart) {
        this.cart = cart;
        this.list = list;
    }
    //기
    void start() {
        boolean startContoller = true;
        while (true) {
            //1. 카테고리 처리
            startContoller = handleCategory();
            if(!startContoller) {
                break;
            }
            //2. 메뉴아이템 처리
            startContoller = handleMenuList();
            if (!startContoller) {
                continue;
            }
            //3. 장바구니 처리
            startContoller = handleCart();
            if (!startContoller) {
                continue;
            }
        }
    }
    // 기능간 객체로 분리 - 인터페이스 활용 가능.
    boolean handleCategory() {
        // 1. 카테고리 메뉴 출력

        while (true) {
            String category = "[ MAIN MENU ]" + "\n";
            for( int i = 0; i < list.size(); i++ ) {
                category += (i+1) + ". " + list.get(i).getMainCategoryName() + "\n";
            }
            category += "0. 종료     | 종료";

            System.out.println(category);

            // 4-1. 장바구니 이후 추가기능. cart 가 비어있지 않으면 [ ORDER MENU ] 출력
            if ( cart.getCartSize()!=0 ) {
                System.out.println();
                System.out.println("[ORDER MENU] \n4. Orders       | 장바구니를 확인 후 주문합니다. \n5. Cancel       | 진행중인 주문을 취소합니다.");
            }
            // 2. 카테고리 입력받기
            int inputs = scanningIntegerInput();

            // 3. 입력값에 해당하는 카테고리 출력하기
            if ( cart.getCartSize() == 0 ) {
                if (inputs >= 1 && inputs <= list.size()) {
                    selectedMenu = list.get( inputs - 1 );
                } else if (inputs == 0) {
                    System.out.println("종료합니다. ");
                    return false;
                } else {
                    System.out.println("올바른 숫자를 입력해주세요");
                }
            } else {

                // 4-2. 장바구니 주문, 취소
                if (inputs >= 1 && inputs <= list.size()) {
                    selectedMenu = list.get( inputs - 1 );
                } else if (inputs == 0) {
                    System.out.println("종료합니다. ");
                    return false;
                } else if (inputs == 4) {
                    System.out.println("아래와 같이 주문 하시겠습니까?");
                    System.out.println("[ ORDERS ]");
                    System.out.println(cart.printAllCartItems());
                    System.out.println(cart.printTotalPrice());
                    System.out.println("1. 주문      2. 메뉴판");
                    int choice = scanningIntegerInput();
                    switch (choice) {
                        case 1 :
                            System.out.println("할인 정보를 입력해주세요\n1. 국가유공자 : 10% \n2. 군인     :  5%\n3. 학생     :  3%\n4. 일반     :  0%");
                            int selectDiscount = scanningIntegerInput();
                            double resultPrice = cart.calculateDiscountedPrice(selectDiscount);
                            System.out.println("주문이 완료되었습니다. 금액은 W " + resultPrice + " 입니다.");
                            cart.removeItem();
                            continue;
                        case 2 :
                            continue;
                        default :
                            System.out.println("잘못된 입력입니다.");
                            continue;
                    }
                } else if (inputs == 5) {
                    cart.removeItem();
                    continue;
                }
            }
            return true;
        }
    }

    boolean handleMenuList() {

        // 1. 메뉴아이템 출력
        String menutemplate = selectedMenu.printAllMenuItems();
        System.out.println(menutemplate);

        // 2. 선택할 메뉴아이템 입력받기
        System.out.println("원하는 메뉴를 선택해주세요");
        int inputs = scanningIntegerInput();

        // 3. 입력값에 해당하는 메뉴아이템 입력받기
        if ( inputs >= 1 && inputs <= selectedMenu.getMenuSize() ) {
            int index = inputs - 1;

            // 4. 입력값에 해당하는 메뉴아아이템 생성하기
            selectedMenuItem = selectedMenu.getMenuItemList().get(index);

            // 5. 입력값에 해당하는 메뉴아아이템 출력하기
            System.out.println( "선택한 메뉴:" + " "+ selectedMenuItem.getName() + " | " + " W "+ selectedMenuItem.getPrice() + " | " + selectedMenuItem.getDescription());
            // 6. 수량 추가하기
            System.out.println("수량을 입력하세요");
            amount = scanningIntegerInput();
            if (amount == 0) {
                System.out.println("0개는 입력할 수 없습니다.");
                amount = scanningIntegerInput();
            }
            return true;
        } else if ( inputs == 0 ) {
            return false;
        }
        else{
            return false;
        }
    }

    boolean handleCart() {

        // 1. 장바구니 입력받기
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인     | 2. 취소     ");
        int inputs = scanningIntegerInput();

        // 2. 장바구니 출력
        if (inputs == 1) {
            cart.addItem(selectedMenuItem, amount);
            System.out.println(selectedMenuItem.getName() + " " + amount + " 개" + " 가 장바구니에 추가되었습니다.");


//          3. 장바구니에 담긴 모든 아이템 출력 - order 로 분할
            System.out.println("[ ORDERS ]");
            System.out.println(cart.printAllCartItems());
            System.out.println(cart.printTotalPrice());
            System.out.println("-----------");
            return true;
        }
        else if (inputs == 2) {
            System.out.println("취소되었습니다.");
            return false;
        }
        return true;
    }

    int scanningIntegerInput() {
        int input = 0;
        while (true) {
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
}
