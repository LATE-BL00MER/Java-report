package Chap05_inheritance.Ex05;

class Point {
    private int x, y;
    public Point(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
    protected void move(int x, int y) { this.x = x; this.y = y;}
}

class Point3D extends Point {
    private int z; // z 축의 점

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    // z 축의 좌표 리턴
    public int getZ() {
        return z;
    }

    // z 축의 값을 증가
    public void moveUp(int z) { // 여기서 z는 '매개변수'
        this.z += z; // this.z는 '클래스의 필드', 그냥 z는 '매개변수'
    }

    // z 축의 값을 감소
    public void moveDown(int z) {
        this.z -= z;
    }

    // 오버로딩!! -> 이름은 같으나 매개변수의 개수나 타입이 달라야 함!
    public void move(int x, int y, int z) {
        this.move(x, y); // 오버라이딩한 자신의 move(x, y) 호출
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + getZ() + ")의 점";
    }
}

public class Ex05 {
    public static void main(String[] args) {
        Point3D p = new Point3D(3, 2, 1);
        System.out.println(p.toString() + "입니다.");

        p.moveUp(3); // z 축으로 3 이동
        System.out.println(p.toString() + "입니다.");
        p.moveDown(2); // z 축으로 -2 이동
        System.out.println(p.toString() + "입니다.");
        p.move(5, 5); // x = 10, y = 10으로 이동
        System.out.println(p.toString() + "입니다.");
        p.move(100, 200, 300);
        System.out.println(p.toString() + "입니다.");
    }
}
