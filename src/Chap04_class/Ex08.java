package Chap04_class;

class Account {
    private int deposit;

    // 생성자
    public Account(int deposit) {
        this.deposit = deposit;
    }

    // 예금할 금액
    public void deposit(int num) {
        deposit += num;
    }

    // 매개변수의 타입이나 개수가 다르면 같은 이름의 메소드를 여러개 만들 수 있는 오버로딩 필요함
    public void deposit(int bulk[]) {
        for (int i = 0; i < bulk.length; i++) {
            this.deposit += bulk[i];
        }
    }


    public int getBalance() {
        return deposit;
    }

    // 구현을 못했음
    public int withdraw(int money) {
        if (money <= deposit) {
            // 잔액이 충분한 경우
            deposit -= money; // 실제 잔액에서 차감 필수 
            return money; // 요청한 금액 반환
        } else {
            // 잔액이 부족한 경우
            int actualMoney = deposit; // 남은 돈 잔액
            deposit = 0; // 계좌는 0원이 됨
            return actualMoney; // 가진 돈만 반환
        }
    }

}

public class Ex08 {
    public static void main(String[] args) {
        Account a = new Account(100); // 100원을 예금하면서 계좌 형성
        a.deposit(5000); // 5000원 예금
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int bulk[] = {100, 500, 200, 700};
        a.deposit(bulk); // bulk[] 배열에 있는 모든 돈 예금
        System.out.println("잔금은 "  + a.getBalance() + "원입니다.");

        int money = 1000; // 인출하고자 하는 금액
        int wMoney = a.withdraw(money); // 1000원 인출 시도. wMoney는 실제 인출한 금액
        if (wMoney < money)
            System.out.println(wMoney + "원만 인출"); // 잔금이 1000원보다 작은 경우
        else
            System.out.println(wMoney + "원 인출"); // 잔금이 1000원보다 큰 경우

        System.out.println("잔금은 " + a.getBalance() + "원입니다.");
    }
}

/*
getBalance() 에서 무엇을 내보내야 할지 작성을 못함
이 함수는 현재 내 통장에 얼마나 있는지(상태)를 알려주는 함수이다
deposit을 그대로 return 해주면 되는 거였음.

withdraw(int money)에서 돈을 인출했지만, 실제 deposit 값에 변화를 못 주었음
실제 내 계좌잔고(deposit)에서 그만큼을 차감(-=) 해야 함
 */