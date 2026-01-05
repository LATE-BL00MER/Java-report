package Chap04_class.Ex12;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

class Dictionary {
    private static String [] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String [] eng = {"love", "baby", "money", "future", "hope"};

    public static String [] kor2eng(String word) {
            int i;
            for (i = 0; i < kor.length; i++) { //kor 배열을 처음부터 끝까지 하나씩 확인한다.
                // 입력받은 단어(word)가 배열에 있는 단어(kor[i])와 같은지 비교한다.
                if (kor[i].equals(word)) {
                    // 찾았다면? 새 배열 { 한글, 영어 } 를 만들어서 함수를 호출한 곳으로 던진다
                    // return을 만나면 함수는 그 즉시 종료됨 (break 역할 포함)
                    return new String[] { kor[i], eng[i] };
                }
            }

            // 끝까지 돌고 못 찾는다면 사전에 없다는 뜻
            // "찾는 게 없다"는 신호로 null을 던짐
            return null;
        }
    }

public class DicApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 검색 코드 작성
        System.out.println("한영단어 검색 프로그램입니다.");

        while (true) {
            System.out.print("한글 단어?");
            String typeKorean = sc.next();

            if (typeKorean.equals("그만")) { // 그만 치면 종료
                break;
            }

            // 핵심 코드! Dictionary 클래스에게 typeKorean을 찾으라고 시키는 코드
            // 결과값 { 한글, 영어 }, 배열 혹은 null 을 result라는 변수에 담는다.
            String[] result = Dictionary.kor2eng(typeKorean);

            // 사전이 결과를 보냈는지 확인한다.
            if (result != null) {
                System.out.println(result[0] + "은(는) " + result[1]);
            } else {
                // 함수가 null을 리턴했다면 i == kor.length였다는 뜻
                System.out.println(typeKorean + "는 저의 사전에 없습니다.");
            }
        }
    }
}
