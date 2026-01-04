package Chap04_class.Ex11;

class ArrayUtil {
    public static int [] concat(int[] a, int[] b) {
        // 배열 a와 b를 연결한 새로운 배열 리턴
        int[] result = new int[a.length + b.length];
    }

    public static void print(int[] a) {
        // 배열 a 출력
        System.out.println();
    }
}

public class StaticEx {
    public static void main(String[] args) {
        int [] array1 = { 1, 5, 7, 9 };
        int [] array2 = { 3, 6, -1, 100, 77 };
        int [] array3 = ArrayUtil.concat(array1, array2);
        ArrayUtil.print(array3);
    }
}
