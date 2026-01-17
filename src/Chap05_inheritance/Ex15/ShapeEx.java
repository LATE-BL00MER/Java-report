package Chap05_inheritance.Ex15;

interface Shape {
    final double PI = 3.14; // 상수
    void draw(); // 도형을 그리는 추상 메서드
    double getArea(); // 도형의 면적을 리턴하는 추상 메서드
    default public void redraw() { // 디폴트 메소드
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("반지름이 " + radius + "인 원");
    }

    @Override
    public double getArea() {
        return PI * (radius * radius);
    }
}

class Oval implements Shape {
    private int width;
    private int height;

    public Oval(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(width +  "x" + height + "에 내접하는 타원");
    }

    @Override
    public double getArea() {
        return ( (width / 2.0) * ( height / 2.0) ) * PI;
    }
}

class Rect implements Shape {
    private int width;
    private int height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(width + "x" + height + "크기의 사각형");
    }

    @Override
    public double getArea() {
        return (double)(width * height);
    }
}

public class ShapeEx {
    public static void main(String[] args) {
        Shape [] list = new Shape[3]; // Shape를 상속받은 클래스 객체의 레퍼런스 배열
        list[0] = new Circle(5); // 반지름이 5인 원 객체
        list[1] = new Oval(20, 30); // 20 X 30 사각형에 내접하는 타원
        list[2] = new Rect(10, 40); // 10 X 40 크기의 사각형

        for (int  i = 0; i < list.length; i++) {
            list[i].redraw();
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println("면적은 " + list[i].getArea());
        }
    }
}
