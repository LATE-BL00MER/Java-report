package Chap04_class.Ex10;

import java.util.Scanner;

public class MonthDiary {
    private int year; // 년도
    private int month; // 월
    private DayDiary [] diary = new DayDiary[30];

    private Scanner sc = new Scanner(System.in);

    // 생성자
    public MonthDiary() { return; }

    // 오버로딩한 생성자(매개변수가 있는 생성자)
    public MonthDiary(int year, int month) {
        this.year = year;
        this.month = month;

        // 30개 배열 칸에 DayDiary 객체를 하나씩 채워놓는다. (미리 생성하는 것임)
        for (int i = 0; i < diary.length; i++) {
            diary[i] = new DayDiary();
        }
    }

    // 날짜랑 메모 텍스트 작성하는 함수
    public void write() {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자 이하)>>");
        int date = sc.nextInt(); // 입력할 날짜
        String memoText = sc.next(); // 메모할 기억할 일

        // 입력받은 날짜의 객체에 텍스트 저장 (인덱스는 date-1)
        diary[date - 1].setText(memoText);
    }

    // 기록했던 메모를 보여주는 함수
    public void show() {
        for (int i = 0; i < diary.length; i++) {
            // \t 로 간격 조정, getText()로 저장된 메모 + ... 출력하기
            System.out.print(diary[i].getText() + "\t");

            // 가독성을 위해 10일마다 줄바꿈
            if ((i + 1) % 10 == 0) System.out.println();
        }
        System.out.println();
    }

    // 입력을 전달하는 함수
    public int getMenu() {
        System.out.print("기록:1, 보기:2, 종료:3>>");
        int choice = sc.nextInt();
        return choice;
    }

    // 실행 메인 메소드
    public void run() {
        System.out.println("*****" + year + "년" + month + "월 다이어리 *****");

        while (true) {

            int choice = getMenu(); // getMenu()로 입력받기

            switch (choice) {
                // 1번: 기록하기
                case 1:
                    write(); // 기록을 위해 write() 메소드 호출
                    break;

                // 2번: 보기
                case 2:
                    show(); // 기록했던 메모를 보기위해 show() 메소드 호출
                    break;

                // 3번: 종료
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;

                // 예외처리 (1,2,3번 이외의 것을 눌렀을 때)
                default:
                    System.out.println("1,2,3번 중에서 선택해주세요!");
            }
        }
    }

    public static void main(String[] args) {
        MonthDiary monthDiary = new MonthDiary(2024, 10); //2024년 10월 다이어리
        monthDiary.run();
    }
}

/*
다시 풀어봐야 할 문제로 생각함

DayDiary 클래스의 구현을 좀 더 생각했어야 함

MonthDiary안에 메소드가 많이 필요했는데 이미 run()함수에 넣었던 기능들을 그냥 쪼개면 되는 거였음
객체 배열을 생성한다고 그안에 값이 저장된 것은 아니라는 것을 계속 잊는 거 같은데 꼭 인지하고 풀어야 함
*/
