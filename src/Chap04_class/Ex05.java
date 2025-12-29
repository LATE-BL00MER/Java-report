package Chap04_class;

class Song {
    private String title; // 노래 제목
    private String singer; // 가수 이름
    private int year; // 발표 년도
    private String lang; // 가수의 나라

    // 생성자 Song
    public Song(String title, String singer, int year, String lang) {
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.lang = lang;
    }

    // 노래 정보를 출력하는 show() 메소드
    public void show() {
        System.out.println(year + "년 " + lang + "의 " + singer + "가 부른 " + title);
    }
}

// main은 항상 짧게 작성하는 것을 지향한다.
public class Ex05 {
    public static void main(String[] args) {
        Song song = new Song("가로수 그늘 아래 서면", "이문세", 1988, "한국");

        song.show();
    }
}
