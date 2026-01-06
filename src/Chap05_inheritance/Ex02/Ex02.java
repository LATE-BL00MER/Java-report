package Chap05_inheritance.Ex02;

class TV {
    private int size;
    public TV(int size) { this.size = size; }
    protected int getSize() { return size; }
}

class SmartTV extends TV {
    private int color;
    private String address;

    public SmartTV(String address, int size, int color) {
        super(size); // 부모클래스 TV의 생성자 호출
        this.color = color;
        this.address = address; // 전달받은 주소를 멤버 변수에 저장해야 함
    }

    public void printProperty() {
        System.out.println("나의 SmartTV는 " + address + " 주소의 "
                + getSize() + "인치 " + color + "컬러");
    }
}


public class Ex02 {
    public static void main(String[] args) {
        // "192.168.0.5" 주소의 77인치 20000000컬러 TV
        SmartTV smartTv = new SmartTV("192.168.0.5", 77, 20000000);
        smartTv.printProperty();
    }
}
