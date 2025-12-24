package Chap03;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        do {
            System.out.print("양의 정수를 입력>>");
            num = sc.nextInt();
        } while (num <= 0);

        // 피라미드 문제는 이중 for문으로 푼다
        // 바깥 쪽 for문은 행 담당 -> 몇 줄을 출력할지 결정
        // 안쪽 for문은 열 담당 -> 한 줄에 별을 몇 개로 찍을 지 결정

        for (int i = 0; i < num; i++) { // 행
            for (int j = 0; j < num - i; j++) { // 열 -> 별이 하나씩 줄어들어야 하기 때문데 num - i
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
