//사용자가 입력하는 8자리 정수를 생일(0000년 00월 00일)로 나타내기
// '/'와 '%'를 이용해서 푸는 문제
// 연 계산, 달 계산, 날짜계산이 필요한 문제인데... 30분 고민 후 ai 사용함
package Chap02;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력을 위한 Scanner 객체 생성
        System.out.print("생일 입력 하세요>>");

        int birthday = sc.nextInt(); // 생일 입력받기 (0000/00/00)

        // 년도: 앞의 4자리를 가지고 오기 위해 1000으로 나누기
        int year = birthday / 10000;

        // 월: 뒤의 4자리(0316)를 남긴 후(%1000), 다시 앞의 2자리(03)를 추출(/100)
        int month = (birthday % 10000) / 100;

        // 일: 가장 뒤의 2자리를 가져오기 위해 100으로 나눈 나머지
        int date = birthday % 100;

        System.out.println(year+"년 " + month +"월 " + date + "일");
    }
}
