// if-else문과 switch를 이용해 풀 수 있는 문제.
package Chap02;

import java.util.Scanner;

public class Ex07_if_else {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("월을 입력하세요(1~12)>>");

        int month = sc.nextInt(); // 입력할 월 month

        if (3 <= month && month <= 5) { // 3~5는 따뜻한 봄
            System.out.println("따뜻한 봄");
        } else if (6 <= month && month <= 8) { // 6~8은 바다가 즐거운 여름
            System.out.println("바다가 즐거운 여름");
        } else if (9 <= month && month <= 11) { // 9~11은 낙엽이 지는 가을
            System.out.println("낙엽이 지는 아름다운 가을");
        } else if (month == 12 || month == 1 || month == 0) { // 12,0,1은 눈 내리는 하얀 겨울
            System.out.println("눈 내리는 하얀 겨울");
        } else { // 그 외의 숫자를 입력한 경우는 1~12만 입력하세요
            System.out.println("1~12만 입력하세요");
        }
    }
}