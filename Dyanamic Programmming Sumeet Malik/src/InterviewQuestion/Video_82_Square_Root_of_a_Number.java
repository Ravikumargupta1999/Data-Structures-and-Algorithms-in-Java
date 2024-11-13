package InterviewQuestion;

public class Video_82_Square_Root_of_a_Number {
    static long floorSqrt(long x) {
        long start = 0;
        long end = x;
        long ans = 0;
        while (start <= end) {

            long mid = (start + end) / 2;
            // System.out.println(mid + "  " + x);
            if (mid * mid > x) {
                end = mid - 1;
            } else if (mid * mid < x) {
                ans = mid;
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(5));
    }
}
