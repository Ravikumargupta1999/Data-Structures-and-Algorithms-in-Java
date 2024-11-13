import java.util.ArrayList;

public class Prime_Numbers_In_Range {
    // https://www.geeksforgeeks.org/sieve-of-eratosthenes/
    // https://www.geeksforgeeks.org/sieve-of-eratosthenes/
    static ArrayList<Integer> primeRange(int M, int N) {
        boolean[] temp = new boolean[N + 1];

        for (int i = 2; i < temp.length; i++) {
            if (!temp[i]) {

                // check if i*i > tem.length no meaning to repeat loop
                if (i * i > temp.length)
                    break;
                for (int j = i * i; j < temp.length; j++) {
                    if (j % i == 0) {
                        // System.out.println(i + "  " + j);
                        temp[j] = true;
                    }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < temp.length; i++) {
            if (!temp[i] && (i >= M && i <= N)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(primeRange(1, 100000));
    }
}
