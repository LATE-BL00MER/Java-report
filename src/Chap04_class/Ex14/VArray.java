package Chap04_class.Ex14;

class VArray {
    private int[] arr;
    private int count; // 실제 저장된 개수를 추적할 변수

    public VArray(int num) {
        this.arr = new int[num];
        this.count = 0; // 처음엔 0개
    }

    // 용량(배열의 길이)
    public int capacity() {
        return arr.length; // 전체 상자 크기
    }

    // 저장된 개수
    public int size() {
        return count; // 실제 들어있는 개수
    }

    // 배열이 꽉 찼는지 확인하고 늘리는 함수가 필요함
    public void add(int value) {
        // 새로운 2배 크기 배열 만들기
        // 기존 데이터 복사하기 -> for문?
        // 교체하기

        if (count == arr.length) {
            int[] newArr = new int[arr.length * 2];

            // 기존 데이터를 새 배열에다가 복사하기
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }

            // arr가 2배 더 커진 새 배열을 가리킨다.(교체)
            this.arr = newArr;
        }

        // 이제 자리가 생겼으니까 값을 넣기
        // 현재 저장된 개수(count)에 넣고, 개수를 하나 늘린다.
        arr[count] = value;
        count++;
    }

    // count 개수만큼 돌면서 출력
    public void printAll() {
        for (int i = 0; i < count; i++) { // 전체 칸(length)이 아니라 '저장된 개수' 만큼만!
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 인덱스 뒤쪽 데이터들을 한 칸씩 밀고 빈자리에 삽입
    public void insert(int index, int addNum) {
        // 인덱스가 0보다 작거나, 현재 저장된 개수(count)보다 큰지 확인
        // 만약 현재 배열이 꽉 찼다면, add()에서 만든 2배 늘리기를 여기서도 실행
        // 데이터 밀기 -> 맨 뒤(count - 1)부터 시작해서 index까지 거꾸로 내려오면서 반복
        // 현재 칸의 값을 오른쪽 칸(i + 1)으로 복사
        // 반드시 뒤에서부터 밀어야 데이터가 덮어씌워지지 않음

        // 삽입 -> 비어있는 index 자리에 addNum을 저장
        // 카운트 -> 실제 저장된 개수(count)를 1 증가

        if (index < 0 || index > count) {
            System.out.println("인덱스 범위를 벗어났습니다!");
            return;
        }

        if (count == arr.length) {
            int[] newArr = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            this.arr = newArr;
        }

        // 맨 뒤에서 부터 index까지
        // count가 5고 index가 2라면, 4->5, 3->4, 2->3 순으로 복사
        for (int i = count - 1; i >= index; i--) {
            arr[i + 1] = arr[i]; // 현재 칸의 값을 오른쪽 칸으로 이동
        }

        // 삽입 및 카운트 증가
        arr[index] = addNum;
        count++;
    }


    // 인덱스 뒤쪽 데이터들을 한 칸씩 앞으로 당겨서 메꾸기
    public void remove(int indexNum) {
        // 1. [방어 코드] 삭제하려는 인덱스가 유효한 범위인지 확인 (0 <= index < count)
        //    (범위를 벗어나면 "삭제 불가" 메시지 출력 후 리턴)

        // 2. [데이터 당기기] 핵심!
        //    - 삭제할 위치(index)의 다음 칸(index + 1)부터 맨 마지막(count - 1)까지 반복
        //    - 다음 칸(i)의 값을 현재 칸(i - 1)으로 복사해서 빈칸을 메꿈
        //    - 삭제는 '앞에서부터' 당겨오는 방식

        // 3. [카운트] 실제 저장된 개수(count)를 1 감소

        // 4. [선택 사항] 삭제된 자리를 명확히 하고 싶다면
        //    맨 마지막 칸(count)을 0이나 초기값으로 비워줄 수도 있음

        // 잘못된 인덱스 걸러내기
        if (indexNum < 0 || indexNum >= count) {
            System.out.print("삭제불가");
            return;
        }

        // 데이터 당기기(앞에서부터 차례대로)
        for (int i = indexNum + 1; i <= count - 1; i++) {
            arr[i - 1] = arr[i];
        }

        // 데이터가 하나 줄었으니까 카운트 감소
        count--;

        // 마지막에 남은 잔상 지우기
        arr[count] = 0;
    }

}