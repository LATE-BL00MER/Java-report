// if-else문과 switch를 이용해 풀 수 있는 문제.
package Chap02;

import java.util.Scanner;

public class Ex07_switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("월을 입력하세요(1~12)>>");

        int month = sc.nextInt(); // 입력할 월 month

        switch (month) {
            case 3,4,5: // 3,4,5를 치면
                System.out.println("따뜻한 봄");
                break;
            case 6,7,8: // 6,7,8을 치면
                System.out.println("바다가 즐거운 여름");
                break;
            case 9,10,11: // 9,10,11을 치면
                System.out.println("낙엽이 지는 아름다운 가을");
                break;
            case 12,0,1: // 12,0,1을 치면
                System.out.println("눈 내리는 하얀 겨울");
                break;
            default: { // 그 외의 것들을 치면
                System.out.println("1~12만 입력하세요.");
                break;
            }
        }
    }
}

// 푼건 다 내 손으로 직접 풀고 맞춤
// AI한테 리팩토링 시켜보니까 이렇게도 작성 가능하다 함
/*
String result = switch (month) {
                case 3, 4, 5 -> "따뜻한 봄";
                case 6, 7, 8 -> "바다가 즐거운 여름";
                case 9, 10, 11 -> "낙엽이 지는 아름다운 가을";
                case 12, 0, 1 -> "눈 내리는 하얀 겨울";
                default -> "1~12만 입력하세요.";
            };
*/