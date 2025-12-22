package Chap02;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력을 위한 Scanner 객체 생성(import 필요)

        System.out.print("나이를 입력하세요>>");
        int age = sc.nextInt(); // 입력할 나이 age

        if (age <= 0) { // 나이에 0이나 음수가 입력되면
            System.out.println("나이는 양수로만 입력하세요");
        } else { // 아니라면
            int redCandle = age / 10; // 빨간 초는 10살 취급
            int blueCandle = (age % 10) / 5; // 파란 초는 5살 취급
            int yellowCandle = (age % 5); // 노란 초는 1살 취급 (나누기 1 필요 X)

            int totalCandle = redCandle + blueCandle + yellowCandle;

            System.out.println("빨간 초 " + redCandle + "개, 파란 초 " +
                    blueCandle + "개, 노란 초 " +
                    yellowCandle + "개. 총 " +
                    totalCandle + "개가 필요합니다.");
        }
    }
}
