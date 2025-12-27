/*
두 배열 인덱스 [i], [j] 값이 서로 맞물리게 나오게 해야 함
근데 그걸 어떻게 하지
*/

package Chap03;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String course [] = {"C", "C++", "Python", "Java", "HTML5"};
        String grade [] = {"A", "B+", "B", "A+", "D"};

        while(true) {
            System.out.print("과목>>");
            String courseName = sc.next();

            if (courseName.equals("그만")) {
                break;
            }

            int i;
            for (i = 0; i < course.length; i++) {
                if (course[i].equals(courseName)) {
                    System.out.println(courseName + " 학점은 " + grade[i]);
                    break; // 핵심!! 여기서 멈추면 i가 course.length(5)보다 작은 상태로 나간다.
                }
            }

            // 끝까지 못 찾아서 루프를 다 돌았을 때만(i가 5가 됐을 때만) 실행됨
            if (i == course.length) {
                System.out.println(courseName + "없는 과목입니다.");
            }
        }
    }
}

/*
계속 배열이 두개라서 이중 for문이라고 착각했음
그냥 반복문 하나 쓰고 배열 길이만큼 도는 for문 하나 생성후
[i]활용을 하면 된다.

예외 처리에서는 배열의 마지막 까지 검사했는데도 일치하는 값을 찾지 못했다면,
해당 데이터가 존재하지 않는 것이므로 i == course.length로 표기
*/
