/*
추상 클래스를 상속받은 일반 클래스는, 부모가 가진 모든 추상 메서드를 반드시 구현(override)해야만 한다!!
추상 메서드 보이면 구현부터 하면 된다. (강제성 부여)
*/

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
    private String name;

    // 생성자: 이름 받고, size 초기 세팅은 5로 고정
    public IngredientBox(String name, int size) { // 생성자
        super(size);
        this.name = name;
    }

    // 부모의 추상 메서드를 반드시 구현해야 함!!!
    @Override
    public boolean consume() {
        if (size > 0) {
            size--; // size가 0보다 크면 재료의 양 1씩 감소
            return true;
        }
        return false;
    }

    // 부모의 추상 메서드를 구현하기
    @Override
    public void print() {
        System.out.print(name + " ");
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println(size);
    }
}

public class Ex08 {
    public static void main(String[] args) {
        IngredientBox coffee = new IngredientBox("커피", 5);
        IngredientBox prim = new IngredientBox("프림", 5);
        IngredientBox sugar = new IngredientBox("설탕", 5);

        Scanner sc = new Scanner(System.in);
        System.out.println("***** 청춘 커피 자판기 입니다. *****");

        while(true) {
            // 커피, 프림, 설탕 중 하나라도 0이 되면 원료가 부족하다고 뜬 다음 현재 재고를 보여주고 종료

            coffee.print();
            prim.print();
            sugar.print();

            System.out.print("다방커피:1, 설탕커피:2, 블랙커피:3, 종료:4>>");
            int choice = sc.nextInt();


            if (choice == 4) { // 4번 선택시 종료
                System.out.println("청춘 커피 자판기 프로그램을 종료합니다.");
                break;
            }

            switch(choice) {
                case 1:
                    // 다방커피는 커피, 프림, 설탕 모두 1씩 감소
                    if (!coffee.isEmpty() && !prim.isEmpty() && !sugar.isEmpty()) {
                        coffee.consume();
                        prim.consume();
                        sugar.consume();
                    } else {
                        System.out.println("원료가 부족합니다.");
                    }
                    break;

                case 2:
                    // 설탕 커피는 커피와 설탕만 1씩 감소
                    if (!coffee.isEmpty() && !sugar.isEmpty()) {
                        coffee.consume();
                        sugar.consume();
                    } else
                        System.out.println("원료가 부족합니다.");
                    break;

                case 3:
                    // 블랙커피는 커피만 1 감소
                    if (!coffee.isEmpty()) {
                        coffee.consume();
                    } else
                        System.out.println("원료가 부족합니다.");
                    break;

                default:
                    System.out.println("1~4번만 입력해주세요!");
            }
        }
    }
}
