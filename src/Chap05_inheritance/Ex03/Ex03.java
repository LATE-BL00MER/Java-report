package Chap05_inheritance.Ex03;

class Point {
    private int x, y;
    public Point(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
    protected void move(int x, int y) { this.x = x; this.y = y;}
}

class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x, int y, String color) {
        // 부모 생성자를 반드시 먼저 호출해야 한다!
        super(x, y);

        // 받은 color 값을 필드에 저장
        this.color = color;
    }

    public void setXY(int x, int y) {
        // 부모가 가진 move 메서드를 활용해 좌표를 바꾼다
        move(x, y);
    }

    public void setColor(String color) {
        this.color = color;
    }

    // main에서 toString()을 쓰려면 Overriding이 필요하다!
    @Override
    public String toString() {
        return color + "색의 (" + getX() + "," + getY() + ")의 점";
    }
}

public class Ex03 {
    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint(5, 5, "RED");
        cp.setXY(10, 20);
        cp.setColor("BLUE");
        String str = cp.toString();
        System.out.println(str + "입니다.");
    }
}