// AI 쓴 문제
// 배열에 저장하고 거기서 3의 배수만 고르는 연결고리를 찾지 못했음
package Chap03;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수 10개 입력>>");

        int arr[] = new int[10];

        // 양의 정수 10개를 입력받고 일차원 배열에 저장하기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 배열을 돌면서 3의 배수만 출력(% 3 == 0이면 3의 배수)
        System.out.print("3의 배수는... ");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 3 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
