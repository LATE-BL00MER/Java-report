package Chap04_class.Ex09;

// 게임에 참여하는 사람들 관리
// 이 곳에 선수 이름과 누적 점수를 저장한다.

public class Player {
    private String name; // 참여자 이름
    private int score;

    // 생성자
    public Player(String name) {
        this.name = name;
        this.score = 0; // 처음 생성할 때 이름만 받으면 점수는 자동으로 0부터 시작하도록 설정
    }

    // 누적 점수 저장 (1점씩)
    public void countScore() {
        this.score++;
    }

    // 총점 확인하기 (GuessGame에서도 접근 가능하게 public)
    public int getTotalScore() {
        return score;
    }

    // 이름 확인하기 (GuessGame에서도 접근 가능하게 public)
    public String getName() {
        return name;
    }
}
