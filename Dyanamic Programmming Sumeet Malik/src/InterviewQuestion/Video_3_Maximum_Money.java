package InterviewQuestion;

public class Video_3_Maximum_Money {
    public Video_3_Maximum_Money() {
    }

    static int maximizeMoney(int n, int k) {
        int inc = k;
        int exc = 0;

        for(int i = 1; i < n; ++i) {
            int ninc = exc + k;
            int nexc = Math.max(inc, exc);
            inc = ninc;
            exc = nexc;
        }

        return Math.max(inc, exc);
    }

    public static void main(String[] args) {
        System.out.println(maximizeMoney(5, 10));
    }
}
