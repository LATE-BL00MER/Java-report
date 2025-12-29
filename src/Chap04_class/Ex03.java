package Chap04_class;

import java.util.Scanner;

class Grade {
    private String name; // 학생 이름
    private int javaGrade; // 자바 성적
    private int webGrade; // 웹프 성적
    private int osGrade; // 운체 성적

    // 생성자
    public Grade(String name, int javaGrade, int webGrade, int osGrade) {
        this.name = name;
        this.javaGrade = javaGrade;
        this.webGrade = webGrade;
        this.osGrade = osGrade;
    }

    public String getName() {
        return name;
    }

    public int getAverage() {
        int sum = 0;
        sum += javaGrade + webGrade + osGrade;

        int avg = sum / 3;

        return avg;
    }
}

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
        String name = sc.next();
        int java = sc.nextInt();
        int web = sc.nextInt();
        int os = sc.nextInt();

        Grade st = new Grade(name, java, web, os); // 한 명의 점수 객체 생성
        System.out.print(st.getName() + "의 평균은 " + st.getAverage());
        sc.close();
    }
}
