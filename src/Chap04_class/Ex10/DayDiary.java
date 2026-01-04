package Chap04_class.Ex10;

public class DayDiary {
    private String text; // 메모 내용이 저장되는 변수

    // 생성자
    public DayDiary () {
        // 객체가 만들어지자마자 "..."으로 채워버림
        text = "...";
    }

    // 메모 내용을 수정할 때 사용
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        // 현재 저장된 text(메모 또는 "...")를 반환한다.
        return text;
    }
}
