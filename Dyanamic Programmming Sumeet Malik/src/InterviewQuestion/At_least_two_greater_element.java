package InterviewQuestion;

import java.util.Arrays;

public class At_least_two_greater_element {
    public At_least_two_greater_element() {
    }

    public long[] findElements(long[] a, long n) {
        if (n <= 2L) {
            return new long[0];
        } else {
            long[] result = new long[(int)n - 2];
            Arrays.sort(a);

            for(long i = 0L; i < (long)result.length; ++i) {
                result[(int)i] = a[(int)i];
            }

            return result;
        }
    }
}
