package Chap03;

public class Ex07 {
    public static void main(String[] args) {
        System.out.print("랜덤한 정수들... ");

        int arr[] = new int[10];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*9) + 11;
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }

        // 배열의 길이만큼의 평균이기에  / arr.length;
        // 정확한 평균을 위해 (double)로 형변환
        double average = (double) sum / arr.length;
        System.out.println();
        System.out.printf("평균은 %.1f", average);
    }
}
