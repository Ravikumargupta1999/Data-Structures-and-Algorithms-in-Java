public class Numbers_with_same_first_and_last_digit {
    static int numbersInRange(int L, int R) {
        int count = 0;
        while (L <= R) {
            int first = L % 10;
            int x = L;
            int last = 0;
            while (x != 0) {
                last = x % 10;
                x = x / 10;

            }
            if (first == last)
                count++;

            L++;
        }
        return count;
    }
}
