/*
막히는 포인트
랜덤으로 구구단 중 하나를 던져야 하는데 이걸 어떻게 구현하지
문제 힌트
int n = (int)(Math.random()*9 + 1) -> 1~9 범위의 랜덤한 정수를 생성하는 코드
*/

package Chap03;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** 구구단을 맞추는 퀴즈입니다. *****");

        int failCount = 0; // 틀린 횟수 저장 -> 반복문 밖 -> 루프가 돌아도 초기화 되지 않고 유지됨

        // 3번 틀리면 퀴즈 종료
        while (true) {

            // 새로운 문제 생성(1~9 사이)
            int n1 = (int)(Math.random()*9 + 1);
            int n2 = (int)(Math.random()*9 + 1);

            System.out.print(n1 + " x " + n2 + " = ");
            int num = sc.nextInt(); // 정답 입력

            // 비교 로직
            if (num == (n1 * n2)) {
                System.out.println("정답입니다. 잘했습니다.");
            } else {
                failCount++;

                if (failCount < 3) { // 2번 까지 이렇게 나오게
                    System.out.println(failCount + "번 틀렸습니다. 분발하세요.");
                } else { // 3번 틀리면 이렇게 나오고 종료
                    System.out.println(failCount + "번 틀렸습니다. 퀴즈 종료합니다.");
                    break;
                }
            }
        }
    }
}

/*
틀린 횟수를 변수(failCount)로 설정해야 했음.
구구단을 구하는게 아니라 단순히 숫자를 하나하나 랜덤으로
int n1 = (int)(Math.random()*9 + 1);
int n2 = (int)(Math.random()*9 + 1);
이런 식으로 랜덤으로 수를 던지면 됐음

failCount < 2 로 2번까지만 이렇게 나오게 설정하고
3번 틀릴 때 퀴즈 종료 나오게 설정
*/
