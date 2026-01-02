package Chap04_class.Ex09;

import java.util.Scanner;

// main을 포함하는 게임 프로그램
public class GuessGame {
    private int hiddenAnswer;
    private int numOfPlayers; // 참가자의 인원
    private Player[] players; // 플레이어 한명이 아니고 여러 명이기 때문에 배열로 선언!!

    private Scanner sc = new Scanner(System.in); // 입력을 위한 Scanner 객체 생성

    // 생성자
    public GuessGame() {
        // [수정] 생성자에서는 인사만 출력하고 함수 호출은 하지 않음 (중복 방지)
        System.out.println("*** 예측 게임을 시작합니다. ***");
    }

    // 선수 입력하는(인원 + 이름) 메소드
    public void setPlayer() {
        System.out.print("게임에 참여할 선수>>");
        numOfPlayers = sc.nextInt();

        // 입력받은 선수 인원 수 만큼 배열 크기를 정함
        players = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("선수 이름>>");
            String name = sc.next();

            players[i] = new Player(name); // 객체를 생성해서 배열 칸에 대입해야 한다!
        }
    }

    // 난수 생성 메소드
    public int setRandomNumber() {
        System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞춰보세요.");
        return hiddenAnswer = (int)(Math.random() *100) + 1; // 1부터 100까지 랜덤 정수 생성
    }

    // 난수 생성 후 선수들이 맞춰보는 함수
    public void setGuessNum() {
        int minDiff = 101; // 첫 번째 나온 점수가 무조건 1등이 되게끔 가짜로 큰 숫자 만들기
        int winnerIndex = -1; // 아직 아무도 1등이 아니라는 것을 표현하기 위해 -1

        for (int i = 0; i < players.length; i++) {
            // players[i]만 쓰면 객체의 주소만 나옴, getName()으로 이름을 가져와야 한다,
            System.out.print(players[i].getName() + ">>");
            int guessNum = sc.nextInt(); // 선수들이 맞출 1~100 사이의 추측할 숫자

            int diff = Math.abs(hiddenAnswer-guessNum); // 두 정수의 차이

            if (diff < minDiff) {
                minDiff = diff; // 최솟값 업데이트;
                winnerIndex = i; // i번째 선수가 현재 1등
            }

        }

        System.out.println("정답은 " + hiddenAnswer + ". " + players[winnerIndex].getName() + "이 이겼습니다. 승점 1점 확보!");
        players[winnerIndex].countScore(); // 점수 1점 추가
    }

    // [수정] 한 줄에 이름:점수 형식으로 나오게 수정
    public void showResults() {
        for (int i = 0; i < players.length; i++) {
            // println 대신 print와 공백 사용
            System.out.print(players[i].getName() + ":" + players[i].getTotalScore() + " ");
        }
        System.out.println(); // 줄바꿈
    }

    public void run() {
        setPlayer(); // 선수들 이름이랑 인원 정하기

        while(true) {
            setRandomNumber(); // 정답 숫자 정하기
            setGuessNum(); // 누가 정답에 제일 가까운지(추측) 시합(승자는 점수 1 증가)

            System.out.print("계속하려면 yes입력>>");
            String choice  = sc.next();
            if (choice.equals("no")) {
                showResults();
                break;
            }
        }

        int maxScore = -1;
        int finalWinner = 0;

        for (int i = 0; i < players.length; i++) {
            if (players[i].getTotalScore() > maxScore) {
                maxScore = players[i].getTotalScore();
                finalWinner = i;
            }
        }
        System.out.println(players[finalWinner].getName() + "이(가) 최종 승리하였습니다.");
    }

    public static void main(String[] args) {
        GuessGame guessGameEx09 = new GuessGame();
        guessGameEx09.run();
    }
}

/*
여러 데이터를 담을 때 배열을 이용한다는 것을 기반으로 생각해야 한다.
선수'들' 이기 때문에 변수로 접근이 아닌 배열로 접근했어야 함..

players[i] = new Player_Ex09(name); // 객체를 생성해서 배열 칸에 대입해야 한다!
배열의 수만큼 반복했다고 끝이 아니라 객체가 배열에 저장되게 만들어야 한다.

diff -> 두 수의 차이까진 구하겠는데 이걸 가지고 최솟값 변수를 만들고
if문과 while 반복문으로 여러 번 플레이하는 것을 해야 함
*/