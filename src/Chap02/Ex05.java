/*
ai 도움으로 해결한 문제로 학생1 이름 정수 입력 후 학생 2 입력 문제 해결함
문제 원인은 nextLine();으로 시도 했었지만, 이것은 공백까지 읽고 처리하기 때문에
next();로 수정 하였다.
*/
package Chap02;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int latePanelty = 3; // 지각하면 감점 3점
        int absencePanelty = 8; // 결석하면 감점 8점

        System.out.print("학생1>>");
        String name1 = sc.next(); // 이름
        int lateCount1 = sc.nextInt(); // 지각 횟수
        int absenceCount1 = sc.nextInt(); // 결석 횟수

        System.out.print("학생2>>");
        String name2 = sc.next(); // 이름
        int lateCount2 = sc.nextInt(); // 지각 횟수
        int absenceCount2 = sc.nextInt(); // 결석 횟수

        int totalPanelty1 = (latePanelty * lateCount1) + (absencePanelty * absenceCount1); // name1의 결석 + 지각 종합 점수
        int totalPanelty2 = (latePanelty * lateCount2) + (absencePanelty * absenceCount2); // name2의 결석 + 지각 종합 점수

        System.out.println(name1 + "의 감점은 " + totalPanelty1 + "," +
                name2 + "의 감점은 " + totalPanelty2);

        if (totalPanelty1 < totalPanelty2) { // 출석점수가 더 높아야 하므로 감점 점수가 더 낮을 때로 조건 제시
            System.out.println(name1 + "의 출석 점수가 더 높음. 김유진 출석 점수는 " + (100 - totalPanelty1));
        } else {
            System.out.println(name2 + "의 출석 점수가 더 높음. 김경미 출석 점수는 " + (100 - totalPanelty2));
        }
    }
}
