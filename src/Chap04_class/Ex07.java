package Chap04_class;

class Memo {
    private String name; // 메모 작성자
    private String time; // 메모 시점
    private String content; // 메모 텍스트

    // 생성자
    public Memo(String name, String time, String content) {
        this.name = name;
        this.time = time;
        this.content = content;
    }

    // 메모 작성자가 같으면 true 리턴, 아니면 false 리턴
    public boolean isSameName(Memo name) { // Memo 객체를 매개변수로 받아야 함
        if (this.name.equals(name)) { // 문자열 비교는 .equals() 로 써야 한다 무조건!!
            return true;
        } else  {
            return false;
        }
    }

    // 메모 작성자 이름 리턴
    public String getName() {
        return name;
    }

    // 메모 출력
    public void show() {
        System.out.println(name + ", " + time + " " + content);
    }

    // 메모 텍스트의 길이 리턴
    public int length() {
        return content.length();
    }
}

public class Ex07 {
    public static void main(String[] args) {
        Memo a = new Memo("유송연", "10:10", "자바 과제 있음");
        Memo b= new Memo("박채원", "10:15", "시카고로 어학 연수가요!");
        Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요.");

        a.show();
        if(a.isSameName(b)) System.out.println("동일한 사람입니다.");
        else System.out.println("다른 사람입니다.");
        System.out.println(c.getName() + "가 작성한 메모의 길이는 " + c.length());
    }
}
