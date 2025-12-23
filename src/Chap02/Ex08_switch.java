package Chap02;

import java.util.Scanner;

public class Ex08_switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("연산 입력>>");

        double num1 = sc.nextDouble(); // 처음 쓸 실수
        String op = sc.next(); // 실수 사이의 연산(더하기, 빼기, 곱하기, 나누기)
        double num2 = sc.nextDouble(); // 두번 째 실수

        switch(op) {
            case "더하기":
                System.out.println(num1 + " " + op + " " + num2 + "의 계산 결과는 " + (num1 + num2));
                break;
            case "빼기":
                System.out.println(num1 + " " + op + " " + num2 + "의 계산 결과는 " + (num1 - num2));
                break;
            case "곱하기":
                System.out.println(num1 + " " + op + " " + num2 + "의 계산 결과는 " + (num1 * num2));
                break;
            case "나누기":
                if (num2 == 0) { // switch문과 같은 이유로 조건문 필요
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    System.out.println(num1 + " " + op + " " + num2 + "의 계산 결과는 " + (num1 / num2));
                }
                break;
            default :
                System.out.println("사칙연산이 아닙니다.");
                break;
        }
    }
}
