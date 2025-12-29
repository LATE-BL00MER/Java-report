package Chap03;

public class Ex04 {
    public static void main(String[] args) {
        int n[][] = {
                {1, 2, 3},
                {1, 2},
                {1},
                {1, 2, 3},
                {1, 2, 3, 4}
        };

        for (int i = 0; i < n.length; i++) { // 행 -> 5개만큼 반복
            for (int j = 0; j < n[i].length; j++) { //열 -> 각 행이 가진 열의 개수만큼 반복
                System.out.print(n[i][j] + "\t"); // 탭으로 간격 띄우기
            }
            System.out.println(); //  한 행 출력이 끝나면 줄 바꿈
        }
    }
}
