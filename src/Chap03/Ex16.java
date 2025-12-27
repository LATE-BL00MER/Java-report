/*
입력에서 양의 정수가 아닌 것들을 모두 빼고 평균을 구하는 문제
NumberFormatExceptiond 예외 처리 필요
교재의 3-18번 예제를 참고해서 문제 해결해야 함

-1을 치면 종료니까 while문 무한루프 돌고
if문으로 -1이 오면 break해서 종료
평균을 구할려면 총합과 그리고 나눌 데이터의 수(n의 개수)가 필요한데
총합은 구했는데 데이터의 수를 어떻게 구현해야 되는지 모르겠음

~ 제외 이걸 어떻게 만들지? if문을 써야 하나
-> 이걸 진짜 모르겠음...
어떻게 걸러야 하는 거지
*/
package Chap03;

import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("양의 정수를 입력하세요. -1은 입력 끝>>");

        //ai 도움을 받음
        int sum = 0; // 합계 (루프 밖에서 선언해야 함)
        int count = 0; // 양수의 개수 (루프 밖에서 선언한다.)

        while (true) { // -1이 아닐 때 동안
            String input = sc.next(); // 일단 문자열로 받음 (hello, 3.14..등을 받기 위해)

            try { //예외가 발생할 가능성이 있는 실행문 (try 블록)
                // 숫자로 변환 시도
                int n = Integer.parseInt(input);

                // -1 입력되면 while루프 종료
                if (n == -1) break;

                if (n > 0) {
                    sum += n; // 합계 더하기
                    count++; // 양수의 개수 세기
                } else {
                    // 0이나 -1이 아닌 음수가 들어온 경우 제외
                    System.out.println(input + " 제외");
                }

            } catch (NumberFormatException e) { // ()안에 처리할 예외 타입 선언, 예외처리문 작성

                // 숫자가 아닌 "hello", 3.21 등은 이쪽에서 해결
                System.out.println(input + " 제외");
            }
        }

        // 결과 출력
        if (count > 0) {
            System.out.println("평균은 " + (double)sum / count);
        } else {
            System.out.println("입력된 양의 정수가 없음");
        }
    }
}

/*
입력을 여러 번 받을려면 sc.nextInt()는 무조건 반본문 안에 위치해야 하는 거 잊지 말기 (계속 실수함)

int sum = 0;을 while안에 넣으면 숫자를 10번 입력해도 마지막 숫자만 남게 된다,
누적해야 하는 값은 반드시 반복문 직전에 준비해야 함

sc.nextInt() 대신 Integer.parseInt(sc.next())를 쓰는 이유?

sc.nextInt()는 실수를 만나면 InputMismatchException을 던지지만,
보통 **문자열 변환 예외(NumberFormatException)**를 가르치기 위함.
Integer.parseInt()를 써야 "3.21" 같은 것도 "이건 정수 형태의 문자열이 아니야!"라며 예외를 던져준다.

데이터의 개수는 int count 를 통해서 양수라면 count++를 하면서 개수를 구한다.
양수의 개수를 구하면 되는거니까 count변수 생성 후에 증가된 값이 양수의 개수라는 걸 이용한거임.
*/
