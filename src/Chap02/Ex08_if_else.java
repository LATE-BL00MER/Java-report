// 30분 고민 후 ai 사용한 문제
package Chap02;

import java.util.Scanner;

public class Ex08_if_else {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("연산 입력>>");

        double num1 = sc.nextDouble(); // 처음 쓸 실수
        String op = sc.next(); // 실수 사이의 연산(더하기, 빼기, 곱하기, 나누기)
        double num2 = sc.nextDouble(); // 두번 째 실수

        if (op.equals("더하기")) {
            System.out.println(num1 + " " + op + " " + num2 + "의 계산 결과는 " + (num1 + num2));
        } else if (op.equals("빼기")) {
            System.out.println(num1 + " " + op + " " +  num2 + "의 계산 결과는 " + (num1 - num2));
        } else if (op.equals("곱하기")) {
            System.out.println(num1 + " " + op + " " + num2 + "의 계산 결과는 " + (num1 * num2));
        } else if (op.equals("나누기")) {
            if (num2 == 0) { // 이 조건이 먼저 와야 했었음. 수정 전 버전은 else문으로 뺏기에 오류발생
                System.out.println("0으로 나눌 수 없습니다.");
            } else {
                System.out.println(num1 + " " + op + " " + num2 + "의 계산 결과는 " + (num1 / num2));
            }
        } else {
            System.out.println("사칙연산이 아닙니다.");
        }
    }
}
