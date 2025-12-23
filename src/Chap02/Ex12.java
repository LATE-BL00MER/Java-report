// 이진수를 정수로 변환하는 법을 ai한테 물어봄
// 정수로 변환하는 문제가 아니었음
// 이진수에 대해서 다시 짚고 넘어가기만 하면 되는 문제인듯

package Chap02;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("자동차 상태 입력>>");
        int status = sc.nextInt(); // 자동차 상태 입력 변수 status

        // 자동차 상태 (정지 / 달리기) - 비트 7이 0이면 정지, 1이면 달리기

        // 0b10000000 이게 의미하는 것은 비트 7만 1이라는 뜻
        // AND연산 -> 비트 7만 검사
        if ((status & 0b10000000) != 0) System.out.print("자동차는 달리는 상태이고 ");
        else System.out.print("자동차는 정지 상태이고 ");

        // 에어컨 상태 (켜짐 / 꺼짐) - 비트 6이 0이면 꺼짐, 1이면 켜짐
        if ((status & 0b01000000) != 0) System.out.print("에어컨이 켜진 상태이고 ");
        else System.out.print("에어컨이 꺼진 상태이고 ");

        // 온도 상태 (0~5비트 값)
        // & -> AND연산자
        // 0b00111111 필터를 씌워서 앞부분을 다 날린 다음에 마지막 6비트만 남김
        int temp = status & 0b00111111;
        System.out.println("온도는 " + temp + "도이다.");

    }
}
