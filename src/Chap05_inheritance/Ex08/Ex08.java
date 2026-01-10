package Chap05_inheritance.Ex08;

import java.util.Scanner;

abstract class Box {
    protected int size; // 현재 박스에 들어있는 재료의 양
    public Box(int size) { // 생성자
        this.size = size;
    }

    public boolean isEmpty() { return size == 0; } //  박스가 빈 경우 true 리턴
    public abstract boolean consume(); // 박스에 들어 있는 재료를 일정량 소비
    public abstract void print(); // 박스에 들어 있는 양을 "*" 문자로 출력

}

class IngredientBox extends Box {
    private int coffee;
    private int prim;
    private int sugar;

    // 디폴트 생성자
    public IngredientBox() {
        super(5);
        this.coffee = coffee;
        this.prim = prim;
        this.sugar = sugar;
    }

    public IngredientBox(String name, int size) { // 생성자
        super(5);

    }

    //...

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** 청춘 커피 자판기 입니다. *****");

        while(true) {
            // 커피, 프림, 설탕 중 하나라도 0이 되면 원료가 부족하다고 뜬 다음 현재 재고를 보여주고 종료

            System.out.print("다방커피:1, 설탕커피:2, 블랙커피:3, 종료:4>>");
            int choice = sc.nextInt();

            if (choice == 4) { // 4번 선택시 종료
                break;
            }

            switch(choice) {
                case 1:
                    // 다방커피는 커피, 프림, 설탕 모두 1씩 감소
                    break;

                case 2:
                    // 설탕 커피는 커피와 설탕만 1씩 감소
                    break;

                case 3:
                    // 블랙커피는 커피만 1 감소
                    break;

                default:
                    System.out.println("1~4번만 입력해주세요!");
            }
        }
    }
}

public class Ex08 {
    public static void main(String[] args) {
        IngredientBox coffee = new IngredientBox();
        IngredientBox prim = new IngredientBox();
        IngredientBox sugar = new IngredientBox();
    }
}
