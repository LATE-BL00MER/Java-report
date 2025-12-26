package Chap03;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String course [] = {"C", "C++", "Python", "Java", "HTML5"};
        String grade [] = {"A", "B+", "B", "A+", "D"};

        while(true) {
            System.out.print("과목>>");
            String courseName = sc.next();

            if (courseName.equals("그만")) {
                break;
            }

            for(int i = 0; i < course.length; i++) {
                for (int j = 0; j < grade.length; j++) {
                    if (course[i].equals("Java")) {
                        System.out.println("Java 학점은 ");
                    }
                }
            }
        }
    }
}
