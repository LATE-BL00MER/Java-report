/*
막히는 포인트
임계값을 입력하고 랜덤으로 생성된 수가 임계값보다 크면 255
임계값보다 작거나 같으면 0으로 출력하는 건데
반복문 밖에다가 이걸 쓰면 어떻게 구현하지...
*/

package Chap03;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");

        int arr[][] = new int[4][4]; // 4x4크기의 2차원 배열 생성

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = (int) (Math.random() * 256); // 0~255까지 랜덤값 생성

                System.out.print(arr[i][j] + " "); // 배열 값들 끼리 띄어쓰기
            }
            System.out.println(); // 4칸마다 줄 바꿈

        }
        System.out.print("임계값을 입력>>");
        int num = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > num) {
                    System.out.print(255);
                } else {
                    System.out.print(0);
                }
                System.out.print(" "); // 배열 값들 끼리 띄어쓰기
            }
            System.out.println(); // 4칸마다 줄 바꿈
        }
    }
}

/*
* 그냥 반복문을 하나 더 쓰면 되는 문제였음
* 쓸데없이 망설였음.
* */
