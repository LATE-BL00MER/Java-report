package Chap05_inheritance.Ex09;

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

class BinaryArray extends BaseArray {

    public BinaryArray(int num) {
        super()
    }
}

public class Ex09 {
    public static void main(String[] args) {
        int threshold = 50; // 임계값 50
        BinaryArray bArray = new BinaryArray(10, threshold);

        Scanner scanner = new Scanner(System.in);
        System.out.print(">>");
        for (int i = 0; i < bArray.length(); i++) { // bArray.length()는 10
            int n = scanner.nextInt();
            bArray.add(n);
        }
        bArray.print();
        scanner.close();
    }
}
