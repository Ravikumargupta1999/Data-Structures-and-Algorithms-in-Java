public class Repetitive_Addition_Of_Digits {
    static int singleDigit(long N) {


        while (N / 10 > 0) {
            int temp = 0;
            while (N != 0) {
                temp += (N % 10);
                N = N /10;
            }
            N = temp;
        }
        return (int) N;
    }

}
