/*
10크기의 1차원 정수 배열 2개 생성
학번, 점수 2개의 배열 필요

for문으로 10명의 학번과 점수 입력받기
그 다음에
while문으로 3 누르면 종료되게끔 작성
switch 문으로 1 2 3번 선택지(분기) 만들기
예외처리 문제
 */
package Chap03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int studentId[] = new int[10]; // 학생 10명의 학번 배열
        int studentGrade[] = new int[10]; // 학생 10명의 점수 배열

        System.out.println("10명의 학생의 학번과 점수 입력");

        for (int i = 0; i < studentId.length; i++) {
            System.out.print((i + 1) + ">>");
            int studentId2 = sc.nextInt(); // 학생 학번의 변수
            int studentGrade2 = sc.nextInt(); // 학생 점수의 변수
        }

        while(true) {
            System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
            int choice = 0;

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("학번>>");

                    try {
                        // 숫자 받기 시도 (다른 거 입력 시 예외 발생)
                        int id = sc.nextInt(); // 학번

                        int i;
                        for (i = 0; i < studentId.length; i++) {
                            if (studentId[i] != id) {
                                System.out.println(id + "의 학생은 없습니다.");
                            }
                        }

                    } catch (InputMismatchException e) {
                        // 예외 발생 처리
                        System.out.println("경고!! 정수를 입력하세요.");
                        sc.nextLine(); // 버퍼 비우기
                    }
                    break;

                case 2:
                    System.out.println("점수>>");

                    int grade = 0;

                    try {
                        grade = sc.nextInt(); // 점수

                        int i;
                        for (i = 0; i < studentGrade.length; i++) {
                            if (studentId[i] == grade) {
                                System.out.println("점수가 " + grade + "인 학생은 " + studentId[i] + " 입니다");
                            } else {
                                System.out.println("점수가 " + grade + "인 학생은 없습니다.");
                            }
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        sc.nextLine();
                    }
                    break;

                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }
        }
    }
}

/*
뭐가 뭔지 모르겠는 문제 발견
선택지를 이중으로 둬야 함
학번, 점수, 끝내기 선택지 + 그 안에서의 분기 + 그 안에서 예외처리......

*/