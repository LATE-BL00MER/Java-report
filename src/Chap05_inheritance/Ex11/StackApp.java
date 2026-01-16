package Chap05_inheritance.Ex11;

/*
인터페이스는 '설계도'이자 '규격'이다
실질적인 구현 내용은 없고, "이런 기능을 가져라"는 약속만 정의한다.
인터페이스를 상속하는 클래스는 메서드들을 반드시 구현해야 한다

자바로 자료구조 stack으로 푸는 문제
*/

import java.util.Scanner;

interface IStack {
    int capacity(); // 스택에 저장 가능한 개수 리턴
    int length(); // 스택에 현재 저장된 개수 리턴

    // 스택의 톱(top)에 문자열 저장하고 true 리턴
    // 꽉 차서 넣을 수 없으면, false 리턴
    boolean push(String val);

    // 스택의 톱(top)에 저장된 문자열 리턴. 스택이 비어 있으면 null 리턴
    String pop();
}

class StringStack implements IStack {

    private int maxSize; // 최대 크기 (필드명)
    private int top; // 현재 저장된 위치 (인덱스)
    private String[] elements;

    public StringStack(int capacity) {
        this.maxSize = capacity; // 생성자에서 받아온 값을 maxSize에 저장
        this.elements = new String[capacity];
        this.top = 0;
    }

    @Override
    public int capacity() {
        return maxSize; // 저장 가능한 개수 리턴
    }

    @Override
    public int length() {
        return top;
    }

    @Override
    public boolean push(String val) {
        if (top == maxSize) {
            return false; // 꽉 찼다면 false 리턴
        }
        elements[top++] = val; // 값 넣고 top 증가
        return true;
    }

    @Override
    public String pop() {
        if (top == 0) { // 비어있다면
            return null;
        }
        return elements[--top]; // top 감소시키고 해당 위치 값 변환
    }

}

public class StackApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("스택 용량>>");
        int capacity = sc.nextInt();
        StringStack stack = new StringStack(capacity);

        while (true) {
            System.out.print("문자열 입력>>");
            String input = sc.next();

            // 그만 입력 시 프로그램 종료
            if (input.equals("그만")) {
                break;
            }

            // push 시도 후에 스택이 다 차면 "스택이 꽉차서 디지털 저장 불가" 출력
            if (!stack.push(input)) {
                System.out.println("스택이 꽉차서 " + input + " 저장 불가");
            }
        }

        // 그만 입력 시 스택에 저장된 모든 문자열 팝해서 출력
        System.out.print("스택에 저장된 문자열 팝: ");
        int len = stack.length();
        for (int i = 0; i < len; i++) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();
    }
}
