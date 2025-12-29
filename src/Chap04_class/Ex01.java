package Chap04_class;

class TV {
    private int inch; // TV 인치 필드
    private String maker; // Tv 제조사
    private int price; // 가격

    public TV (String maker, int inch, int price) {
        this.maker = maker;
        this.inch = inch;
        this.price = price;
    }

    public void show() {
        System.out.println(maker + "에서 만든 " + price + "만원짜리의 " + inch + "인치 TV");
    }

}

public class Ex01 {

    public static void main(String[] args) {
        TV tv = new TV("Samsung", 50, 300);
        tv.show();
    }

}
