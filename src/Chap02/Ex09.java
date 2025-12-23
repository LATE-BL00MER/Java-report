/*
계속 틀리길래 ai 돌려보니까
문제를 잘 못읽어서 헤맴
안, 선 위, 밖의 조건은 생각하고, 구현까지 했는데
그냥 y 범위를 계속 200보다 크다고 설정해서 틀렸었음
범위만 잡으면 해결되는 문제였음
 */

package Chap02;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("점 (x, y)의 좌표 입력>>");

        int x = sc.nextInt(); // 입력할 x 좌표 값
        int y = sc.nextInt(); // 입력할 y 좌표 값

        if ((x > 10 && x < 200) && (y > 10 && y < 300)) { // 안에 있어야 하는 조건
            System.out.println("(" + x + "," + y + ")는 사각형 안에 있습니다");
        } else if (((x == 10 || x == 200) && (y >= 10 && y <= 300)) // 선 위의 조건
                || ((y == 10 || y == 300) && (x >= 10 && x <= 200))) {
            System.out.println("(" + x + "," + y + ")는 사각형 선 위에 있습니다");
        } else {
            System.out.println("(" + x + "," + y + ")는 사각형 밖에 있습니다");
        }
    }
}
