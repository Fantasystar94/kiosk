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
    private int fourthInput;
    private Cart cart = new Cart(new ArrayList<CartList>());
    //생
    Kiosk(List<Menu> list) {
        this.list = list;
    }
    //기


    void start() {
        boolean firstDepthExit = true;
        while (true) {
            System.out.println("[ MAIN MENU ]");
            String category = "";
            for(int i = 0;i < list.size(); i++) {
                category += list.get(i).getMainCategoryName(i);
            }
            category += "0. 종료     | 종료";
            System.out.println(category);

            if(cart.getList().size() != 0) {
                System.out.println(" [ ORDER MENU ] ");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.\n5. Cancel       | 진행중인 주문을 취소합니다.");
            }

            firstDepthExit = firstDepth();
            if(!firstDepthExit) {
                break;
            }
        }
    }
    // 1. 메뉴판 세팅
    boolean firstDepth() {
        boolean flag = true;

            try{
                firstInput = sc.nextInt();

                int realInput = firstInput-1;
                if(firstInput >= 1 && firstInput<=list.size()) {
                    System.out.println(list.get(realInput).getMainCategoryName(realInput));
                    //종료되지 않은 경우 메뉴 리스트 선택으로
                    secondDepth();
                    flag = false;
                }
                else if(firstInput < 0){
                    System.out.println("올바른 번호를 입력해주세요");
                }
                else if (firstInput == 4) {
                    //장바구니 확인시켜주기
                    showOrderList();
                }
                else if (firstInput == 5) {
                    //진행중인 주문 취소
                    cart.removeItem();
                    return true;
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

        return true;
    }
    //2. 메뉴 리스트 선택
    void secondDepth() {
        boolean flag = true;

        switch (firstInput) {
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
            String printAllMenuItems = list.get(firstInput-1).printAllMenuItems();
            System.out.println(printAllMenuItems);
            System.out.println("0. 뒤로가기 ");
            secondInput = sc.nextInt();

                try{
                    int realInput = secondInput-1;
                    if (secondInput >= 1 && secondInput <= list.get(firstInput-1).getList().size()) {

                        String menuName = list.get(firstInput-1).getList().get(realInput).getName();
                        double price = list.get(firstInput-1).getList().get(realInput).getPrice();
                        String description = list.get(firstInput-1).getList().get(realInput).getDescription();

                        System.out.println( "선택한 메뉴:"+" "+ menuName +" | "+" W "+ price +" | "+ description );
                        //올바른 메뉴가 선택된 상태일 경우 세번째 선택과정으로
                        thirdDepth();
                    }
                    else if (secondInput == 0) {
                        break;
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
    //3. 장바구니 선택
    void thirdDepth() {
        boolean flag = true;
        while (flag) {
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인     | 2. 취소     ");
            thirdInput = sc.nextInt();
            try{

                if (thirdInput == 1) {

                    String select = list.get(firstInput-1).getList().get(secondInput-1).getName();
                    double price = list.get(firstInput-1).getList().get(secondInput-1).getPrice();
                    String description = list.get(firstInput-1).getList().get(secondInput-1).getDescription();
                    System.out.println(select+" 이/가 장바구니에 추가되었습니다.");
                    //장바구니 추가
                    CartList cartlist = new CartList(select, price, description);
                    cart.addItem(cartlist);

                    //장바구니 보여주기
                    showOrderList();

                    flag = false;
                }
                else if (thirdInput == 2) {
                    flag = false;
                    System.out.println("취소되었습니다");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("주문번호만 입력해주세요");
                sc.nextLine();
            }
        }
    }
    //4. 장바구니 보여주기
    void showOrderList() {
        boolean flag = true;

        while(flag) {
            System.out.println("[ Orders ]");
            System.out.println(cart.printAllMenuItems());
            System.out.println("[Total]");
            System.out.println(cart.printTotalPrice());
            System.out.println();
            System.out.println("1. 주문     |  2. 메뉴판");
            fourthInput = sc.nextInt();
            try{
                if( fourthInput == 1) {
                    System.out.println("주문이 완료되었습니다. 금액은"+cart.printTotalPrice()+" 입니다.");
                    cart.removeItem();
                }
                else if(fourthInput == 2) {
                    System.out.println("메뉴판으로 돌아갑니다.");
                }
                else{
                    System.out.println("주문 혹은 메뉴판만 선택해주세요");
                }
                flag = false;
            }
            catch(InputMismatchException e){
                System.out.println("주문 혹은 메뉴판만 선택해주세요");
                sc.nextLine();
            }
        }
    }
}
