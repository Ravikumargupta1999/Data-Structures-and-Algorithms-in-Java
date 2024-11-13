package InterviewQuestion;

public class Video_6_Check_Bits {

    static int isBitSet(int n) {
        if (n == 0) {
            return 0;
        } else {
            for(int i = 0; i < n; ++i) {
                if ((1 << i) - 1 == n) {
                    return 1;
                }
            }

            return 0;
        }
    }


}
