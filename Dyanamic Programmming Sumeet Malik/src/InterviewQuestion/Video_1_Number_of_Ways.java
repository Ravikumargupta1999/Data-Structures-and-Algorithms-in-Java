package InterviewQuestion;

public class Video_1_Number_of_Ways {
    // https://practice.geeksforgeeks.org/problems/count-of-sum-of-consecutives3741/1
    public Video_1_Number_of_Ways() {
    }

    static int getCount(int n) {
        int count = 0;

        for (int k = 1; k * (k + 1) < 2 * n; ++k) {
            double f = (1.0D * (double) n - (double) (k * (k + 1) / 2)) / (double) (k + 1);
            if (f - (double) ((int) f) == 0.0D) {
                ++count;
            }
        }

        return count;
    }



}
