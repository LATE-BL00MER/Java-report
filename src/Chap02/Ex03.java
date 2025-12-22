package Chap02;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력을 위한 Scanner 객체 생성

        System.out.println("**** 자바 분식입니다. 주문하면 금액을 알려드립니다. ****");
        System.out.print("떡볶이 몇 인분>>");
        int tteok = sc.nextInt(); // 떡볶이 갯수 입력

        System.out.print("김말이 몇 인분>>");
        int gim = sc.nextInt(); // 김말이 갯수 입력

        System.out.print("쫄면 몇 인분>>");
        int zzol = sc.nextInt(); // 쫄면 개수 입력

        int tteok_price = 2000; // 떡볶이 1인분 가격
        int gim_price = 1000; // 김말이 1인분 가격
        int zzol_price = 3000; // 쫄면 1인분 가격

        // total은 각 갯수에 각 가격을 곱한 값들을 더하면 전체금액 완성
        int total = (tteok * tteok_price) + (gim * gim_price) + (zzol * zzol_price);

        System.out.println("전체 금액은 " + total + "원입니다.");
    }
}
