package Chap03;

public class Ex02 {
    public static void main(String[] args) {
        int n[] = {1, -2, 6, 20, 5, 72, -16, 256};

        int i = 0; // i는 0부터
        do {
            if (n[i] > 0 && n[i] % 4 == 0) {
                System.out.print(n[i] + " ");
            }
            i++; // 증감
        } while (i < n.length); // 조건식 (배열 끝까지)
    }
}


/*
for (int i = 0; i < n.length; i++) {
            if (n[i] > 0 && n[i] % 4 == 0) {
                System.out.print(n[i] + " ");
            }
        }

while문
        int i = 0; // i는 0부터
        while(i < n.length) { // 배열 끝까지
            if (n[i] > 0 && n[i] % 4 == 0) {
                System.out.print(n[i] + " ");
            }
            i++; // 반드시 조건 판단 직전에 수행되도록
        }
*/