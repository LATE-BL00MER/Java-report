package Chap05_inheritance.Ex07;

class Point {
    private int x, y;
    public Point(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
    protected void move(int x, int y) { this.x = x; this.y = y;}
}

class Point3DColor extends Point {
    private int z; // z 축의 점
    private String color; // 색깔

    public Point3DColor(int x, int y, int z, String color) {
        super(x, y);
        this.z = z;
        this.color = color;
    }

    public int getZ() {
        return z;
    }


    // 객체를 매개변수로 받아야 함 -> move() 오버로딩
    public void move(Point3DColor object) {
        // object 객체에서 x, y, z 값을 가져옴
        int newX = object.getX();
        int newY = object.getY();
        int newZ = object.getZ();

        // 부모의 move를 이용해서 x, y를 변경하고 내 필드 z를 직접 변경함
        super.move(newX, newY);
        this.z = newZ;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point3DColor)) return false;
        Point3DColor other = (Point3DColor) obj;
        return getX() == other.getX() && getY() == other.getY() &&
                z == other.z && color.equals(other.color);
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + getZ() + ")" + color + "점";
    }
}

public class Ex07 {
    public static void main(String[] args) {
        Point3DColor p = new Point3DColor(10, 20, 30, "RED");
        System.out.println(p.toString() + "입니다.");

        Point3DColor q = new Point3DColor(1, 2, 3, "BLUE");
        p.move(q); // 점 p를 점 q의 위치로 이동
        System.out.println(p.toString() + "입니다.");

        Point3DColor r = new Point3DColor(1, 2, 3, "RED");
        if(p.equals(r)) System.out.println("예. 같은 위치 같은 색깔의 점입니다.");
        else System.out.println("아니오");
    }
}
