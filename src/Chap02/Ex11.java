package Chap02;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("냉장고 상태 입력>>");
        String str = sc.next(); // 문자열 "00001101" 등을 입력

        // 문자열 "00001101"을 2진수 00001101로 만들어 바이트 타입의 정수 status에 저장
        byte status  = Byte.parseByte(str,2);

        // 전원 유무
        if ((status & 0b00000001) != 0) System.out.print("전원 켜져있음. ");
        else System.out.print("전원 꺼져 있음. ");

        // 문 닫힘 유무
        if ((status & 0b00000010) != 0) System.out.print("문 닫혀있음. ");
        else System.out.print("문 열려 있음. ");

        // 전구 작동 유무
        if ((status & 0b00000100) != 0) System.out.print("전구 정상 작동. ");
        else System.out.print("전구 손상. ");

        // 냉장고 온도 상태
        if ((status & 0b00001000) != 0) System.out.print("냉장고 온도 3도 미만. ");
        else System.out.print("냉장고 온도 3도 이상. ");
    }
}
