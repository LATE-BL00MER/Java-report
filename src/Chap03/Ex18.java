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
                studentId[i] = sc.nextInt();
                studentGrade[i] = sc.nextInt();
        }

        while(true) {
            System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
            int choice = 0;

            choice = sc.nextInt();

            if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("학번>>");
                        try {
                            // 숫자 받기 시도 (다른 거 입력 시 예외 발생)
                            int id = sc.nextInt(); // 학번
                            boolean found = false;

                            for (int i = 0; i < studentId.length; i++) {
                                if (studentId[i] == id) { // 1. 일치하는 학번을 찾으면
                                    System.out.println(studentGrade[i] + "점");
                                    found = true;
                                    break;
                                }
                            }
                            // for 문이 끝나고도 found값이 false라면?
                            if (!found) {
                                System.out.println(id + "의 학생은 없습니다.");
                            }
                            break; // 정상적으로 끝났으면 내부 while 탈출(메뉴로 복귀)

                        } catch (InputMismatchException e) {
                            // 예외 발생 처리
                            System.out.println("경고!! 정수를 입력하세요.");
                            sc.nextLine(); // 버퍼 비우기

                            // 여기서 경고문이 뜨고 다시 학번>> 이 나와야 하는데 다시 1,2,3 선택이 또 나옴
                            // 학번으로 검색들어가서 학번을 치면 없다는 문구가 반복문으로 나오는 문제 발생
                            // 아마 이건 배열에 저장이 안되어서 그런듯?

                        }
                    }
                    break; // switch의 case 1 종료

                case 2:
                    while (true) {
                        System.out.print("점수>>");
                        try {
                            int grade = sc.nextInt(); // 점수
                            boolean found = false;
                            String result = ""; // 점수가 같은 학생들의 학번을 모아둘 변수

                            for (int i = 0; i < studentGrade.length; i++) {
                                if (studentGrade[i] == grade) {
                                    result += studentId[i] + " "; // 찾은 학번을 한 칸 띄워서 출력
                                    found = true;
                                }
                            }

                            if (found) {
                                System.out.println("점수가 " + grade + "인 학생은 " + result + "입니다.");
                            } else {
                                System.out.println("점수가 " + grade + "인 학생은 없습니다.");
                            }

                            break; // 제대로 처리됐으니 내부 while 탈출

                        } catch (InputMismatchException e) {
                            System.out.println("경고!! 정수를 입력하세요.");
                            sc.nextLine(); // 버퍼 비우고 다시 점수>> 로 되돌리기
                        }
                    }
                    break;
            }
        }
    }
}

/*
뭐가 뭔지 모르겠는 문제 발견
선택지를 이중으로 둬야 함
학번, 점수, 끝내기 선택지 + 그 안에서의 분기 + 그 안에서 예외처리......

문제점
1. 배열에 데이터 저장 안됨: for문 안에서 입력 받기만 하고, 선언한 배열에 값 대입 x
2. 검색 로직의 오류: 반복문 안에서 if조건이 맞지 않으면 10번 반복되서 나옴
3. 프로그램 종료 미작동: catch 이후에 break;가 걸려있어서 switch를 빠져나가기 때문에
다시 메뉴 선택으로 돌아가게 됨. 내부에 별도로 반복문 필요함

*/