package Chap05_inheritance.Ex06;

class Point {
    private int x, y;
    public Point(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
    protected void move(int x, int y) { this.x = x; this.y = y;}
}

class PositivePoint extends Point {

    public PositivePoint() {
        // 기본으로 1, 1을 만들어준다.
        super(1, 1);
    }

    // 매개변수 생성자, 음수면 1,1 유지, 양수면 해당 위치로
    public PositivePoint(int x, int y) {
        super(1, 1); // 첫 줄은 무조건 부모 생성자 호출
        this.move(x, y);  // 오버라이딩한 move를 호출해서 검증 후 이동
    }

    // move 오버라이딩
    @Override
    public void move(int x, int y) {
        // x와 y가 모두 양수일때만 부모의 move를 호출해서 이동시킨다
        if (x > 0 && y > 0) {
            super.move(x, y);
        }
        // 조건에 맞지 않는다면 아무것도 하지 않는다.
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")의 점";
    }
}

public class Ex06 {
    public static void main(String[] args) {
        PositivePoint p = new PositivePoint(10, 10); // 10, 10의 점
        p.move(5, 5); // p는 5, 5 점
        System.out.println(p.toString() + "입니다.");

        p.move(2, -2); // 점 p는 양수 공간만 가능, 그러므로 이동 없음
        System.out.println(p.toString() + "입니다.");

        // 음수의 점 불가. 디폴트(1, 1)의 점 생성
        PositivePoint q = new PositivePoint(-10, -10);

        System.out.println(q.toString() + "입니다.");
    }
}
