package Chap04_class;

class Rectangle {
    private int x; // x 축의 점
    private int y; // y 축의 점
    private int width; // 가로의 길이
    private int height; // 세로의 길이

    // 생성자
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // 정사각형이면 true, 아니면 false로 리턴
    public boolean isSquare() {
        if (width == height) {
            return true;
        } else {
            return false;
        }
    }

    // 현재 사각형 내부에 매개변수로 받은 사각형 r이 있으면 true, 아니면 false로 리턴
    public boolean contains(Rectangle r) {
        return (r.x >= this.x && r.y >= this.y && // r 사각형의 x와 y의 범위 비교
                (r.x + r.width) <= (this.x + this.width) &&  // r 사각형의 오른쪽 끝이 넘지 않는지
                (r.y + r.height) <= (this.y + this.height)); // r 사각형의 위쪽 끝이 넘지 않는지
    }

    // 문구 출력 메소드
    public void show() {
        System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
    }
}

public class Ex06 {
    public static void main(String[] args) {
        Rectangle a = new Rectangle(3, 3, 6, 6); // (3,3) 점에서 6x6 크기의 사각형
        Rectangle b = new Rectangle(4, 4, 2, 3); // (4,4) 점에서 2x3 크기의 사각형

        a.show();
        if (a.isSquare()) System.out.println("a는 정사각형입니다.");
        else System.out.println("a는 직사각형입니다.");
        if (a.contains(b)) System.out.println("a는 b를 포함합니다.");
    }
}

/*
객체가 점유하는 '공간'을 판별할 때는 단일 지표(면적)가 아닌,
시작과 끝의 '범위(Range)'를 논리적으로 결합하여 증명해야 한다.

도달했어야 하는 사고: 면적이 아무리 작더라도 좌표(x, y)가 기준 사각형 밖에 있으면 포함될 수 없음.
포함은 '양'의 문제가 아니라 공간상의 '범위(Range)' 문제임. [면적 vs 범위] 포함 관계는 면적의 대소 비교가 아니라,
X축과 Y축 각각의 선분 범위가 기준 안에 완전히 들어오는지를 따져야 함.

생각하지 못한 점: 시작 좌표(x, y)만 비교하거나 사각형의 끝점 위치를 계산에 넣지 않음.

도달했어야 하는 사고: 사각형은 시작점만으로 정의되지 않음.

반드시 **'x + width'**와 **'y + height'**를 통해 실제 공간적 한계선을 도출해야
그 지점까지 안전한지 확인이 가능함.
[경계값 산출] 객체의 속성(길이)을 현재 좌표에 더해 우측 끝과 상단 끝이라는 '절대 좌표'를 먼저 도출하는 과정이 핵심임.

생각하지 못한 점: 한두 개의 조건만 맞으면 포함될 것이라고 직관적으로 판단함.

도달했어야 하는 사고: 사각형이 삐져나오지 않으려면 상, 하, 좌, 우 네 방향의 벽이 모두 기준 사각형 내부에 있어야 함.

논리 연산자 &&는 이 '완전한 포함'을 증명하는 도구임.
[논리 결합] 독립적인 4개의 경계 조건이 모두 참(&&)일 때만 '객체 간의 포함'이 성립하는 논리적 엄격함이 필요함.

생각하지 못한 점: width와 height라는 크기 정보를 위치 정보와 혼동함.

도달했어야 하는 사고: width와 height는 길이를 나타내는 상대적인 값일 뿐임.
실제 공간에서의 끝점을 알기 위해서는 기준점(x, y)에 길이를 더한 실제 위치값을 계산해야 함.
[좌표와 크기] 크기 정보는 반드시 기준 좌표와의 연산을 통해 공간상의 실제 점유 영역 정보로 변환되어야 함.
*/
