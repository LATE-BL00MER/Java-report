/*
Ex13과 유사한 문제다
단지 예외처리가 들어간 경우이다
그만이 입력될 때까지니까 while문 써야 함
InputMismatchException 예외 처리로 2'잔' 이런 식의 예외 처리 해야 함
메뉴의 이름과 가격을 수량으로 계산해야 하므로 for 루프를 while문 안에다 적어야 할 거 같음
-> 배열의 인덱스 이용해야 할듯
*/

package Chap03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String coffee[] = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
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

            int count = 0; // 수량을 저장할 변수

            try { // 예외가 발생할 가능성이 있는 것을 적는 곳
               count = sc.nextInt();
            } catch(InputMismatchException e) {
               // 버퍼 지우기. 입력 통로에 남아있는 "잔" 또는 "2잔"을 싹 읽어서 버림
               sc.nextLine();

                System.out.println("잔 수는 양의 정수로만 입력해주세요!");
                continue;
            }

            int i; // i를 for문 밖에서 미리 선언
            for (i = 0; i < coffee.length; i++) {
                if (coffee[i].equals(menu)) {
                    System.out.println("가격은 " + (price[i] * count) + "원입니다.");
                    break; // 찾으면 멈춤, 이때 i는 coffee.length보다 작음
                }
            }

            // for문 밖에 서 체크해야 함!
            // break를 못 만나서 끝까지 다 돌았다면, i는 coffee.length와 같아짐
            if (i == coffee.length) {
                System.out.println(menu + "은(는) 없는 메뉴입니다.");
            }
        }
    }
}



/*
가격은~ 이게 계속 안나왔는데 그냥 띄어쓰기 문제였음 사소한 오타도 주의해야 함...
 int i; // i를 for문 밖에서 미리 선언
 for (i = 0; i < coffee.length; i++)
 if (coffee[i].equals(menu)) {
 System.out.println("가격은 " + (price[i] * count) + "원입니다.");
      break; // 찾으면 멈춤, 이때 i는 coffee.length보다 작음
                    }
                }

                // for문 밖에 서 체크해야 함!
                // break를 못 만나서 끝까지 다 돌았다면, i는 coffee.length와 같아짐
                if (i == coffee.length) {
                    System.out.println(menu + "은(는) 없는 메뉴입니다.");
                }
이런 배열을 이용해서 출력하는 구문을 논리적으로 이해해야 함

예외처리에서 try-catch문의 개념을 제대로 가지고 가야 함
try는 예외가 발생할 수 도 있는 곳
catch는 그 예외를 받고 처리하는 곳

count = 0;을 따로 빼둔 이유는 try문이 끝나도 count가 살아있어서 가격 계산에 쓸 수 있기 때문이다.
*/
