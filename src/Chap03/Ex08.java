package Chap03;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 몇 개 저장하시겠습니까>>");

        int num = sc.nextInt(); // 저장할 배열의 크기 설정
        int arr[]  = new int[num]; // num만큼의 배열 생성
        int sum = 0; // 평균에 쓸 배열 값들의 합

        System.out.print("랜덤한 정수들... ");

        // 랜덤으로 수 지정 후 반복문을 통해 sum값 구하기
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        // 평균 구하기 (double)로 정확하게
        double average = (double) sum / arr.length;
        System.out.print("평균은 " + average);
    }
}