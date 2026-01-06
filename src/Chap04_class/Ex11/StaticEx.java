package Chap04_class.Ex11;

class ArrayUtil {
    public static int [] concat(int[] a, int[] b) {
        // 배열 a와 b를 연결한 새로운 배열 리턴

        // 두 배열 길이를 합친 새 배열 result
        int[] result = new int[a.length + b.length];

        // 배열 a의 내용을 result에 복사
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }

        // 배열 b의 내용을 result의 a 다음 위치부터 복사
        for (int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i]; // a.length만큼 띄우고 저장 시작
        }

        // 완성된 배열 리턴
        return result;
    }

    public static void print(int[] a) {
        // 배열 a 출력
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
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
