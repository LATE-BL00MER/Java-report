package Chap03;

public class Ex01 {
    public static void main(String[] args) {
        int sum = 0, i = 1;

        do {
            sum += i;
            i += 3;
        } while (i <= 50);
        System.out.println(sum);
    }
}

/*
while(true) {
            if(i > 50)
                break;
            sum += i;
            i += 3;
       }
*/

/*
for (i = 1; i < 51; i+=3) {
            sum += i;
        }
*/