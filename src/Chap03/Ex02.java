package Chap03;

public class Ex02 {
    public static void main(String[] args) {
        int n[] = {1, -2, 6, 20, 5, 72, -16, 256};

        int i = 0;
        while(true) {
            if (n[i] > 0 && n[i] % 4 == 0)
                break;
        }
        System.out.print(n[i] + " ");
    }
}

/*
for (int i = 0; i < n.length; i++) {
            if (n[i] > 0 && n[i] % 4 == 0) {
                System.out.print(n[i] + " ");
            }
        }
*/