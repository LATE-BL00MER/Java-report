package Chap04_class;

import java.util.Scanner;

// 좌석 하나하나를 의미
class Seat {
    private String name; // 예약자 이름

    public Seat() {
        this.name = "---"; // 초기 상태는 빈 좌석 상태로 둔다
    }

    public String getName() { return name; }

    // 좌석에 이름을 등록
    public void reserve(String name) {
        this.name = name;
    }

    // 이름을 비우고 지움
    public void cancel() {
        this.name = "---";
    }

    // 이미 예약된 자리인지 확인
    public boolean isOccupied() {
        return !name.equals("---"); // 이름이 "---"이 아니면 예약된 상태
    }
}

// S석, A석, B석 각각 10개의 좌석을 관리하는 '줄'
class Group {
    private String type; // S, A, B 중 하나
    private Seat[] seats; // 10개짜리 좌석 객체 배열

    public Group(String type) {
        this.type = type;
        this.seats = new Seat[10];
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat(); // 실제 Seat 객체 생성해서 채우기
        }
    }

    // 현재 줄의 예약 상태를 보여줌(ex. S>>--- --- 홍길동 --- ... )
    public void show() {
        System.out.println(type + ">>");
        for (int i = 0; i < seats.length; i++) {
            System.out.println(seats[i].getName() + " ");
        }
        System.out.println();
    }


    // 사용자에게 번호를 입력받아 해당 인덱스의 Seat객체에 이름을 저장
    // 예약을 위해 이름을 저장하는 로직
    public void reserve(String name, int seatNum) {
        seats[seatNum - 1].reserve(name); // 배열은 0부터 시작, -1 해줘야 함
    }

    // 이름을 입력받아 배열을 돌며 일치하는 사람을 찾아 취소
    public boolean cancel(String name) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].getName().equals(name)) {
                seats[i].cancel();
                return true; // 취소 성공
            }
        }
        return false; // 찾는 이름 없음
    }
}

// 전체 시스템 관리
class ConcertApp {
    // S, A, B 세 개의 그룹 객체를 담는 배열
    private Group[] groups;

    // 전체 관리 및 실행
    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice1;

        System.out.println("명품콘서트홀 예약 시스템입니다.");
        while(true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            choice1 = sc.nextInt();

            switch (choice1) {
                case 1:
                    int choice2;
                    System.out.println("좌석구분 S(1), A(2), B(3)>>");
                    choice2 = sc.nextInt();

            }
        }

    }
}

public class Ex13 {
    public static void main(String[] args) {

    }
}
