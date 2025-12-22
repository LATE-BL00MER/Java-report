package Chap02;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        System.out.print("$1=1200원입니다. 달러를 입력하세요>>");

        Scanner sc = new Scanner(System.in); // 입력을 위한 Scanner 객체 생성(import 필요)
        int dollar = sc.nextInt(); // 입력받을 dollar 변수
        int won = dollar * 1200; // 환전 공식

        System.out.println("$" + dollar + "는 " + won + "원입니다.");
    }
}
