package Chap05_inheritance.Ex10;

import java.util.Scanner;

class BaseArray {
    protected int array[]; // 배열 메모리
    protected int nextIndex = 0; // 다음에 삽입할 배열에 대한 인덱스
    public BaseArray(int size) {
        array = new int [size];
    }

    public int length() { return array.length; }
    public void add(int n) { // 정수 n을 배열 끝에 추가
        if (nextIndex == array.length) return; // 배열이 꽉 찼으면 추가 안함
        array[nextIndex] = n;
        nextIndex++;
    }

    public void print() {
        for (int n : array) System.out.print(n + " ");
        System.out.println();
    }
}

class SortedArray extends BaseArray {

    public SortedArray(int size) {
        super(size);
    }


    // 핵심 로직
    @Override
    public void add(int n) {
        // 일단 배열이 다 찼는지 확인
        if (nextIndex == array.length) return;

        // 뒤에서부터 비교하면서 n보다 큰 값은 오른쪽으로 한 칸씩 밀기
        int i = nextIndex - 1; // 마지막 데이터가 있는 인덱스부터 시작

        while (i >= 0 && array[i] > n) {
            array[i + 1] = array[i]; // 값을 오른쪽으로 복사(밀기)
            i--;
        }

        // n보다 작거나 같은 값 바로 뒤에 (i + 1)에 n 삽입
        array[i + 1] = n;

        // 다음 값이 들어갈 위치 증가
        nextIndex++;
    }
}

public class Ex10 {
    public static void main(String[] args) {
        SortedArray sArray = new SortedArray(10);
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>");
        for (int i = 0; i < sArray.length(); i++) { // sArray.length()는 10
            int n  =scanner.nextInt();
            sArray.add(n);
        }
        sArray.print();
        scanner.close();
    }
}
