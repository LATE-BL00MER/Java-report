/*
그만이 입력될 때까지니까 while문 써야 함
InputMismatchException 예외 처리로 2'잔' 이런 식의 예외 처리 해야 함
메뉴의 이름과 가격을 수량으로 계산해야 하므로 for 루프를 while문 안에다 적어야 할 거 같음
-> 배열의 인덱스 이용해야 할듯
*/

package Chap03;

import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String coffee[] = {"핫아메리카노", " 아이스아메리카노", "카푸치노", "라떼"};
        int price[] = {3000, 3500, 4000, 5000};

        System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라뗴 있습니다.");

        while(true) {
            System.out.print("주문>>");
            // next() & nextLine()은 공백을 읽을 수 없냐 & 읽을 수 있냐 의 차이
            // 여기선 next()를 써야 함. 이유는 공백 전 까지만 읽어야 하기 때문에 (ex. "아메리카노")
            String menu = sc.next();

            if (menu.equals("그만")) {
                break;
            }

            // 그 댜음에 숫자를 읽어야 함 (ex. 2)
            int count = sc.nextInt();

            for (int i = 0; i < coffee.length; i++) {
                if (coffee[i].equals(menu)) {
                    System.out.println("가격은 " + (count * price[i]) + "원입니다.");
                    continue;
                }
            }

        }


    }
}



/*

*/
