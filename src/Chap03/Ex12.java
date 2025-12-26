/*
* 일단 입력할려면 Scanner 필요
* 특정 조건 전까지 무한 루프니까 while(true)---break;
* 이름을 담을 배열
* 특정 조건 구현 위해 if문 필요
* */
package Chap03;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** 작명 프로그램이 실행됩니다. *****");

        String boyMiddleList [] = {"기", "민", "용", "종", "현", "진", "재", "승", "소", "상", "지"};
        String boyLastList [] = {"태", "진", "광", "혁", "우", "철", "빈", "준", "구", "호", "석"};
        String girlMiddleList [] = {"은", "원", "경", "수", "현", "예", "여", "송", "서", "채", "하"};
        String girlLastList [] = {"진", "연", "경", "서", "리", "숙", "미", "원", "린", "희", "수"};

        while(true) {
            System.out.print("남/여 선택>>");
            String gender = sc.next();

            // 성별 선택 시 "그만"입력 시 프로그램 종료
            if (gender.equals("그만")) {
                break;
            }

            // 남/여 가 아닌 이상한 걸 입력했을 때 거르기
            if (!gender.equals("남") && !gender.equals("여")) {
                System.out.println("남/여/그만 중에서 입력하세요!");
                continue; // 다시 while문 처음으로 돌아가서 성별부터 묻게 함
            }

            System.out.print("성 입력>>");
            String firstName = sc.next();

            // 남자면
            if (gender.equals("남")) {
                int index1 = (int)(Math.random()*boyMiddleList.length);
                String boyMiddle = boyMiddleList[index1];
                int index2 = (int)(Math.random()*boyLastList.length);
                String boyLast = boyLastList[index2];

                System.out.print("추천 이름: " + firstName + boyMiddle + boyLast);
                System.out.println();

            // 여자면
            } else if (gender.equals("여")) {
                int index3 = (int)(Math.random()*girlMiddleList.length);
                String girlMiddle = girlMiddleList[index3];
                int index4 = (int)(Math.random()*girlLastList.length);
                String girlLast = girlLastList[index4];

                System.out.print("추천 이름: " + firstName + girlMiddle + girlLast);
                System.out.println();

            }
        }
    }
}

/*
* 자바에서 문자열 비교는 무조건 .equals() 사용!!
* */