package Chap05_inheritance.Ex13;

import java.util.Scanner;

abstract class Calc {
    protected String errorMsg = ""; // 초기화
    protected int a, b;

    abstract public void setValue(int a, int b);
    abstract public int calculate();
}

class Add extends Calc {
    @Override
    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int calculate() {
        return a + b;
    }
}

class Sub extends Calc {

    @Override
    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int calculate() {
        return a - b;
    }
}

class Mul extends Calc {

    @Override
    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int calculate() {
        return  a * b;
    }
}

class Div extends Calc {

    @Override
    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int calculate() {
        if (b == 0) {
            errorMsg = "0으로 나눌 수 없음.";
            return 0;
        }
        return a / b;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("두 정수와 연산자를 입력하시오>>");
            int a = sc.nextInt();
            int b=  sc.nextInt();
            String op = sc.next();

            Calc exp = null; // 부모 클래스 타입으로 선언

            // 연산자에 따라서 객체를 생성 --> 다형성 응용
            switch (op) {
                case "+" : exp = new Add(); break;
                case "-" : exp = new Sub(); break;
                case "*" : exp = new Mul(); break;
                case "/" : exp = new Div(); break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    continue;
            }

            exp.setValue(a, b);
            int result = exp.calculate();

            // 에러 메시지 체크
            if (op.equals("/") && b == 0) {
                System.out.println(exp.errorMsg + " 프로그램 종료");
                break;
            } else {
                System.out.println("계산 결과 " + result);
            }
        }

    }
}
