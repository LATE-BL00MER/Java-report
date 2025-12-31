package Chap04_class;

class Account {
    private int deposit;

    // 생성자
    public Account(int deposit) {
        this.deposit = deposit;
    }

    // 예금할 금액
    public int deposit(int num) {
        return deposit + num;
    }

    // 매개변수의 타입이나 개수가 다르면 같은 이름의 메소드를 여러개 만들 수 있는 오버로딩 필요함
    public int deposit(int bulk[]) {

    }


    public int getBalance() {
        return
    }

    public int withdraw(int money) {
        if (money < deposit) {
            return money;
        } else if (money == deposit) {
            System.out.println("0원");
        } else {
            return 0;
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
