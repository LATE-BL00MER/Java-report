package Chap04_class;

class Average {
    private int nextIndex[] = new int[10]; // 정수 10개를 저장할 변수
    private int count = 0;

    // 생성자
    public Average() { return; }

    // 데이터를 배열에 저장하는 역할
    public void put(int num) {
        if (count < nextIndex.length) { // 배열이 꽉 차지 않았을 때만 저장
            nextIndex[count] = num; // 현재 인덱스에 값 저장
            count++;                // 다음 저장을 위해 인덱스 저장
        } else {
            System.out.println("더 이상 저장할 공간이 없습니다.");
        }
    }

    public void showAll() {
        System.out.println("***** 저장된 데이터 모두 출력 *****");
        for (int i = 0; i < count; i++) { // 저장된 개수(count)만큼만 반복한다.
            System.out.print(nextIndex[i] + " ");
        }
        System.out.println(); // 줄 바꿈
    }

    public double getAvg() {
        if (count == 0) return 0; // 데이터가 없을 경우 0 반환

        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += nextIndex[i];
        }
        return sum / (double)count; // 총합을 저장된 개수로 나눈 값을 리턴한다.
        // 답안에 맞게 double로 형변환을 해주었다.
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
        System.out.print("평균은 " + avg.getAvg()); // 평균 출력
    }
}

/*
객체는 공간(배열)뿐만 아니라 흐름(인덱스 변수)을 스스로 기억해야 하며,
메소드는 오직 맡은 역할에만 집중해야 한다.

생각하지 못한 점: 배열(공간)만 선언하면 데이터가 순서대로 쌓일 것이라고 막연히 생각함.

도달했어야 하는 사고: 배열은 그저 칸이 나누어진 상자일 뿐,
**"다음에 어디에 넣을지"**를 기억하는 변수(index/count)가 있어야 객체가 자신의 상태를 유지할 수 있음.
[배열과 인덱스] 배열은 공간일 뿐, '현재 저장된 위치'를 추적하는 별도의 멤버 변수가 반드시 필요하다.
------------

생각하지 못한 점: put(int num)에서 받은 num을 getAvg()에서 바로 쓸 수 있을 거라 생각함.

도달했어야 하는 사고: 메소드의 매개변수는 해당 메소드가 끝나면 사라지는 지역 변수임.
이 값을 나중에도(다른 메소드에서) 쓰려면 반드시 **인스턴스 필드(배열)**에 옮겨 담아 영구히 보관해야 함.
[변수 범위] 매개변수는 일시적이다. 데이터를 공유하려면 클래스의 필드(배열)에 저장해 '상태'로 만들어야 한다.
-----------

생각하지 못한 점: 데이터를 넣는 것(put)과 출력하는 것(showAll)의 경계를 명확히 두지 않음.

도달했어야 하는 사고: put은 데이터의 입력만 담당해야 함. 입력할 때마다 출력 로직이 섞여 있으면,
나중에 데이터만 조용히 저장하고 싶을 때 코드를 다시 뜯어고쳐야 하는 결합도 문제가 발생함.
[단일 책임] 하나의 메소드는 하나의 기능만 수행해야 코드가 깔끔하고 재사용하기 유리하다.
------------

생각하지 못한 점: nextIndex.length(10)로 나누면 평균이 나올 거라 생각함.

도달했어야 하는 사고: 배열의 전체 크기(Capacity)와 실제 들어있는 데이터의 개수(Size)는 다름.
평균은 **'실제 입력된 개수'**로 나누어야 논리적으로 완벽함.
[로직 디테일] 전체 배열 크기보다 '실제 저장된 개수'를 기준으로 계산해야 데이터 유동성에 대응할 수 있다.
*/
