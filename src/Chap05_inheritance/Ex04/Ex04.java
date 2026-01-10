package Chap05_inheritance.Ex04;

class Point {
    private int x, y;
    public Point(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
    protected void move(int x, int y) { this.x = x; this.y = y;}
}

class ColorPoint2 extends Point {
    private String color;

    // 기본 생성자: (0, 0) 위치에 WHITE 색상으로 초기화
    public ColorPoint2() {
        super(0, 0);
        this.color = "WHITE";
    }

    // x, y만 받는 생성자
    public ColorPoint2(int x, int y) {
        super(x, y);
    }

    // x, y, 색상을 모두 받는 생성자
    public ColorPoint2(int x, int y, String color) {
        // 부모 생성자 먼저 호출
        super(x, y);
        this.color = color; // 전달받은 색 저장
    }

    public void set(String color) {
        this.color = color;
    }

    public void set(int x, int y) {
        move(x, y);
    }

    @Override
    public String toString() {
        return color + "색의 (" + getX() + "," + getY() + ")의 점";
    }

    // 거리를 구하는 메서드 (매개변수로 다른 Point 객체를 받음)
    public double getDistance(Point other) {
        int dx = this.getX() - other.getX(); // x 좌표 차이
        int dy = this.getY() - other.getY(); // y 좌표 차이

        // 피타고라스 정리
        return Math.sqrt((dx * dx) + (dy * dy));
    }
}

public class Ex04 {
    public static void main(String[] args) {
        // 0, 0dnlcldml WHITE 색 점
        ColorPoint2 zeroPoint = new ColorPoint2();
        System.out.println(zeroPoint.toString() + "입니다.");

        // 10, 10 위치의 RED색 점
        ColorPoint2 cp = new ColorPoint2(10, 10, "RED");

        cp.set("BLUE");
        cp.set(10, 20);
        System.out.println(cp.toString() + "입니다.");

        // 100, 100 위치의 BLACK 점
        ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);

        System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
    }
}
