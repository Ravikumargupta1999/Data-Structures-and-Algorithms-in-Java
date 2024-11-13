package InterviewQuestion;

public class Video_5_Half_N_By_M {
    static int mthHalf(int N, int M) {
        while (M-- > 1) {
            N /= 2;
        }
        return N;
    }


}
