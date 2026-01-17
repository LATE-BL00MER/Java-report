package Chap05_inheritance.Ex14;

import java.util.Scanner;

abstract class Shape {
    private Shape next;
    public Shape() { next = null; }
    public void setNext(Shape obj) { next = obj; } // 링크 연결
    public Shape getNext() { return next; }
    public abstract void draw(); // 추상 메서드
}

class Line extends Shape {

    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {

    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

public class GraphicEditor {
    private Shape head = null; // 시작 노드
    private Shape tail = null; // 끝 노드
    private Scanner sc = new Scanner(System.in);

    private void insert(int type) {
        Shape obj = null;
        if (type == 1) {
            obj = new Line();
        } else if (type == 2) {
            obj = new Rect();
        } else if (type == 3) {
            obj = new Circle();
        }

        if (head == null) { // 리스트가 빈 경우
            head = tail = obj;
        } else { // 마지막에 추가
            tail.setNext(obj);
            tail = obj;
        }
    }

    private void printAll() {
        Shape p = head;
        while (p != null) {
            p.draw();
            p = p.getNext();
        }
    }

    private void delete(int index) {
        if (head == null) { // 리스트가 비어있는 경우
            System.out.println("삭제할 수 있는 도형이 없습니다.");
            return;
        }

        Shape prev = head;
        Shape curr = head;

        // 첫 번째 노드를 삭제하는 경우
        if (index == 1) {
            if (head == tail) { // 노드가 하나뿐이었다면
                head = tail = null;
            } else {
                head = head.getNext();
            }
            return;
        }

        // index만큼 이동해서 삭제할 노드(curr)와 그 이전 노드(prev) 찾기
        for (int i = 1; i < index; i++) {
            prev = curr;
            curr = curr.getNext();
            if (curr == null) { // 인덱스가 범위를 벗어난 경우
                System.out.println("삭제할 수 없습니다.");
                return;
            }
        }

        // 연결 끊기
        prev.setNext(curr.getNext());

        // 만약 마지막 노드를 삭제했다면 tail을 갱신
        if (curr == tail) {
            tail = prev;
        }
    }

    public void run() {
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
        while(true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // 삽입
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    insert(sc.nextInt());
                    break;
                case 2: // 삭제
                    System.out.print("삭제할 도형의 위치>>");
                    delete(sc.nextInt());
                    break;
                case 3: // 모두 보기
                    printAll();
                    break;
                case 4: // 종료
                    System.out.println("Beauty Graphic Editor를 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력! 다시 입력하세요");
            }
        }
    }

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.run();
    }
}
