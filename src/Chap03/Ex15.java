/*
정수가 입력될 때까지 입력을 받기 때문에 while (true)로 무한 반복문
예외 처리 문제인데 책 예제 3-17 참고함
catch문을 어떻게 작성해야 되는지 모르겠음
문자열과 실수 둘 다 오면 안되는데 어떻게 하는거지
*/

package Chap03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("곱하고자 하는 정수 2개 입력>>");

            try { // 예외가 발생할 가능성이 있는 실행문 (try 블록)
                int n = sc.nextInt(); // 여기서 실수(13.7 이나 문자열(hello)이 들어오면 에외 발생
                int m = sc.nextInt();

                // 정수 입력이 성공했을 때만 아래 문장들이 실행됨
                System.out.println(n + "x" + m + "=" + (n * m));
                break; // 성공했으면 무한 루프 탈출

            } catch (InputMismatchException e) { // ()안에 처리할 예외 타입 선언, 예외처리문 작성
                // 이미 입력된 키를 모두 제거하기 위해 scanner.nextLine()을 호출한다.
                // 버퍼를 지우는 것: 잘못 입력된 것들을 다 읽어서 버린다.
                sc.nextLine();
                System.out.println("정수를 입력하세요!");

                // break가 없으니까 다시 while문의 처음(입력 안내문)으로 돌아감
            }
        }
        sc.close();
    }
}

/*
try 문 안에서 정수 입력이 해결되었을 때만 실행문 뜨게 만들고 break 걸어야 했음
catch문 안에서 sc.nextLine()으로 잘못된 값을 치워주게 하는 것을 알아야 함
*/
