package Chap05_inheritance.Ex14;

abstract class Shape {
    private Shape next;
    public Shape() { next = null; }
    public void setNext(Shape obj) { next = obj; } // 링크 연결
    public Shape getNext() { return next; }
    public abstract void draw(); // 추상 메서드
}

public class GraphicEditor {
    public static void main(String[] args) {

    }
}
