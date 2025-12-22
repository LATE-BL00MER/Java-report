// 문제에서 if를 쓰라는데 어디서 어떻게 써야 하는지 모르겠음...

package Chap02;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력을 위한 Scanner 객체 생성

        System.out.print("여행지>>");
        String tripPlace = sc.nextLine();

        System.out.print("인원 수>>");
        int people = sc.nextInt();

        System.out.print("숙박일>>");
        int tripDays = sc.nextInt();

        System.out.print("1인당 항공료>>");
        int planePrice = sc.nextInt();

        System.out.print("1방 숙박비>>");
        int roomCharge = sc.nextInt();

        // 여기서부턴 ai의 도움이 들어감
        // if를 써야 하는 핵심 포인트는 "방 개수 계산"임
        // 사람이 홀수라면 방이 하나 더 필요함 (최대 2명까지 투숙 가능)

        int rooms; // 방 갯수

        if (people % 2 == 0) { // 사람이 짝수라면
            rooms = people / 2;
        } else {               // 사람이 홀수라면
            rooms = people / 2 + 1;
        }

        int total_price = (people * planePrice) + (rooms * roomCharge * tripDays);

        System.out.println(
                people + "명의 " + tripPlace + tripDays +"박" + (tripDays + 1) + "일 여행에는 " +
                "방이 " + rooms +"개 필요하며 경비는 "
                + total_price + "원입니다.");
    }
}
