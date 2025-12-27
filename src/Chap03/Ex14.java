/*
엔터 키를 입력하면 0 1 2 중에서 랜덤하게 3개 수 나오게 해야 함
3개의 수를 어떻게 나오게 하지 --> 이게 제일 문제
만약 3개 수가 같다면 yes/no 입력하게 하고 yes면 계속, no면 종료
위와 같은 이유로 while 반복문이 필요하고, if 조건문 필요
랜덤하게 수가 나오게 하는 무언가(함수? import문?)가 필요함
-> Math.random()으로 해결
*/
package Chap03;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("***** 갬블링 게임을 시작합니다. *****");

        while (true) {
            System.out.print("엔터키 입력>>");
            String enter = sc.nextLine(); // 엔터키 입력을 위해 nextLine() 사용

            int randNum1 = (int)(Math.random() * 4); // 0~3까지의 임의의 정수 생성
            int randNum2 = (int)(Math.random() * 4); // 0~3까지의 임의의 정수 생성
            int randNum3 = (int)(Math.random() * 4); // 0~3까지의 임의의 정수 생성

            System.out.println(randNum1 + " " + randNum2 + " " + randNum3);

            if (randNum1 == randNum2 && randNum2 == randNum3) {
                System.out.println("성공! 대박났어요!");
                System.out.print("계속 하시겠습니까?(yes/no)>>");

                String answer = sc.nextLine(); // yes 또는 no 입력받기

                if (answer.equals("yes")) {
                    continue; // 다시 while문으로 돌아가기
                } else if (answer.equals("no")) {
                    System.out.println("게임을 종료합니다.");
                    break; // 종료
                }
            }
        }
    }
}

/*
랜덤 수 3개를 생성할 때 반복문이 아니라 그냥 3개의 랜덤 수를 생성한 후에 + 하면 되는 거였음
앞으로 랜덤 수를 생성할 때는 Math.random()으로 하는 것이 깔끔할 거 같음
범위를 정할려면 * (범위를 정하고 싶은 수) ()안에는 0부터 ()안에 있는 수 -1 로 생각하면 된다.
EX) * (100) --> 0~99까지의 랜덤 수
*/
