// 자리수의 합을 구할려면 주어진 숫자를 10으로 나누고
// 또 나눈 나머지를 통해서 나머지 자리수를 구하고
// 이 과정을 반복하면 된다.
// EX) 15의 자리수의 합은 10으로 나눴을 때 몫이 1 나머지가 5 => 6

package Chap03;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수 10개 입력>>");

        int arr[] = new int[10];

        // 양의 정수 10개를 입력받고 일차원 배열에 저장하기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("자리수의 합이 9인 것은 ...");

        // ai 도움 들어간 곳
        // 공식은 알았으나 구현에서 막힘

        // 각 숫자별로 자리수의 합 구하기
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i]; // 원래 배열의 값을 보존하기 위해 임시로 복사
            int sum = 0; // 각 숫자마다 합계를 0으로 초기화

            while (temp > 0) {
                sum += temp % 10; // 10으로 나눈 나머지(1의자리)를 더함
                temp /= 10; // 10으로 나눈 몫을 다시 temp에 저장(자리수 이돋)
            }

            if (sum == 9) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
