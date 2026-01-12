package Chap05_inheritance.Ex11;

/*
인터페이스는 '설계도'이자 '규격'이다
실질적인 구현 내용은 없고, "이런 기능을 가져라"는 약속만 정의한다.
인터페이스를 상속하는 클래스는 메서드들을 반드시 구현해야 한다
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
        if (top == elements.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String pop() {
        if (top == -1) {
            return null;
        }
        return elements[top];
    }

}

public class StackApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackApp stackApp = new StackApp();

        System.out.println("스택 용량>>");


    }
}
