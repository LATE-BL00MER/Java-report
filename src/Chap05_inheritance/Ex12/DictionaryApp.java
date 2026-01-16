package Chap05_inheritance.Ex12;

abstract class PairMap {
    protected String keyArray []; // 키 문자열을 저장하는 배열
    protected String valueArray []; // 값 문자열을 저장하는 배열
    abstract public String get(String key); // key 값으로 value 검색

    // key와 value를 쌍으로 저장
    // key가 이미 저장되어 있으면 값을 value로 수정
    abstract public void put(String key, String value);

    // key값을 가진 아이템(value와 함께) 삭제. 삭제된 value 값 리턴
    abstract public String delete(String key);

    abstract public int length(); // 현재 저장된 아이템 개수 리턴
}

class Dictionary extends PairMap {
    private int count = 0; // 현재 저장된 아이템 개수를 추적하기 위한 변수

    // 생성자: 배열의 크기를 받아 초기화함
    public Dictionary(int capacity) {
        this.keyArray = new String[capacity]; // 키 배열 초기화
        this.valueArray = new String[capacity]; // 값 배열 초기화
    }

    // 키와 값을 저장하는 메소드
    @Override
    public void put(String key, String value) {
        // 이미 key가 존재하는지 확인(있다면 value 수정)
        for (int i = 0; i < count; i++) {
            if (keyArray[i].equals(key)) { // 이미 가지고 있는 키 값인지 확인(만약 있다면?)
                valueArray[i] = value; // 새로운 값으로 수정
                return; // 수정 완료했으니 메서드 종료
            }
        }

        // 새로운 key-value 쌍 추가
        if (count < keyArray.length) { // 배열에 빈 공간이 있는지 확인
            keyArray[count] = key; // 현재 개수 위치에 키 저장
            valueArray[count] = value; // 현재 개수 위치에 값 저장
            count++; // 저장된 개수 1 증가
        }
    }

    @Override
    // 키로 검색하여 값을 리턴하는 메소드
    public String get(String key) {
        // 저장된 개수만큼 반복하며 키를 찾음
        for (int i = 0; i < count; i++) {
            if (keyArray[i].equals(key)) {
                return valueArray[i]; // 찾으면 해당 값 리턴
            }
        }
        return null; // 못 찾았을 경우
    }

    @Override
    public String delete(String key) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i].equals(key)) { // 삭제할 키를 찾았다면
                String deletedValue = valueArray[i]; // 라턴할 값을 미리 복사해둠

                // 삭제된 빈 공간을 메우기 위해 뒤이 요소들을 한 칸씩 앞으로 당김
                for (int j = 0; j < count - 1; j++) {
                    keyArray[j] = keyArray[j + 1];
                    valueArray[j] = valueArray[j + 1];
                }

                count--; // 전체 저장된 개수 1 감소
                return deletedValue; // 삭제된 값 리턴
            }
        }
        return null; // 삭제할 키가 없으면 null 리턴
    }

    @Override
    public int length() {
        return count; // 현재 실제로 저장된 데이터의 개수 리턴
    }

}

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이선");
        dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}
