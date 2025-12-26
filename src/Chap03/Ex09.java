package Chap03;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        int[][] arr = new int[4][4];

        // 2차원 배열을 쓸 때는 for중첩문을 이용해서 행과 열을 구현한다.

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = (int) (Math.random() * 256); // 0~255

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();  // 줄 바꿈
        }
    }
}
