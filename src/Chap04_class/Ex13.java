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
        System.out.print(type + ">> ");
        for (int i = 0; i < seats.length; i++) {
            System.out.print(seats[i].getName() + " ");
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
    private Scanner sc = new Scanner(System.in);

    public ConcertApp() {
        groups = new Group[3];
        groups[0] = new Group("S");
        groups[1] = new Group("A");
        groups[2] = new Group("B");
    }

    // 예약
    public void reserve() {
        System.out.print("좌석구분 S(1), A(2), B(3)>>");
        int grade = sc.nextInt();

        // 선택한 등급의 좌석 현황 출력
        groups[grade - 1].show();

        // 예약 정보 입력
        System.out.print("이름>>");
        String name = sc.next();
        System.out.print("번호>>");
        int seatNum = sc.nextInt();

        // 입력한 값 저장하기
        groups[grade - 1].reserve(name, seatNum);
    }

    // 모든 그룹 보여주기
    public void showAll() {
        for (int i = 0; i < groups.length; i++) {
            groups[i].show(); // 각 등급(Group)의 show()를 호출해줌
        }
        System.out.println("<<<조회를 완료했습니다>>>");
    }

    public void cancel() {
        System.out.print("좌석 S:1, A:2, B:3>>");
        int choice = sc.nextInt();

        groups[choice - 1].show(); // 선택한 등급의 현재 상태를 보여준다(누가 있는지)

        // 취소할 이름 입력받기
        System.out.print("이름>>");
        String cancelName = sc.next();

        // 해당 그룹에서 이름 찾아서 이름 지워야 함
        // Group의 cancel 메서드는 찾으면 true, 못 찾으면 false리턴
        boolean success = groups[choice - 1].cancel(cancelName);

        if (success) {
            return;
        } else {
            System.out.println("이름을 다시 확인해주세요!");
        }
    }

    // 전체 관리 및 실행
    public void run() {
        System.out.println("명품콘서트홀 예약 시스템입니다.");
        while(true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            int menu = sc.nextInt();

            if (menu == 4) break; // 끝내기

            switch (menu) {
                case 1: // 예약 로직
                    // 좌석 등급 선택 -> 이름 입력 -> 번호 입력 순으로 구현
                    reserve(); // 예약 메서드 호출
                    break;
                case 2: // 모든 그룹 show() 호출
                    showAll(); // 조회 메서드
                    break;
                case 3: // 취소 로직 호출
                    cancel();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

public class Ex13 {
    public static void main(String[] args) {
        ConcertApp concertApp = new ConcertApp();
        concertApp.run();
    }
}
