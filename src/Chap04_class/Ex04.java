package Chap04_class;

class Average {
    private int nextIndex[] = new int[10]; // 정수 10개를 저장할 변수

    public Average() {
        this.nextIndex = nextIndex;
    }

    public void put(int num) {

    }

    public void showAll() {

    }

    public void getAvg() {

    }
}

public class Ex04 {
    public static void main(String[] args) {
        // AVerage 클래스를 만들라는 뜻 Average 클래스의 avg객체를 만든다는 뜻
        Average avg = new Average();
        avg.put(10); // 10 저장
        avg.put(15); // 15 저장
        avg.put(100); // 100 저장
        avg.showAll(); // 저장된 모든 원소 출력
        //System.out.print("평균은 " + avg.getAvg()); // 평균 출력
    }
}
