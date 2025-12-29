package Chap04_class;

class Cube {
    private int width; // 가로
    private int depth; // 세로
    private int height; // 높이

    // 생성자 (생성자 이름은 클래스의 이름과 같게 해야 한다)
    public Cube(int width, int depth, int height) {
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    // 부피를 구하는 메소드 (가로 * 세로 * 높이)
    public int getVolume() {
        return (width * depth * height);
    }

    // 가로, 세로, 높이가 각각 1,2,3씩 증가한 상태에서 부피를 구하는 메소드
    public void increase(int w1, int d1, int h1) {
        this.width += w1; // 가로 증가
        this.depth += d1; // 세로 증가
        this.height += h1; // 높이 증가
    }

    // 부피가 0인지 아닌지 판별하는 메소드
    // main에서 if로 판별하기 때문에 boolean타입으로 반환한다.
    public boolean isZero() {
        if (getVolume() == 0) {
            return true;
        } else {
            return false;
        }
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Cube cube = new Cube(1, 2, 3);
        System.out.println("큐브의 부피는 " + cube.getVolume());
        cube.increase(1,2,3);
        System.out.println("큐브의 부피는 " + cube.getVolume());
        if (cube.isZero()) {
            System.out.println("큐브는 부피는 0");
        } else {
            System.out.println("큐브는 부피는 0이 아님");
        }
    }
}
