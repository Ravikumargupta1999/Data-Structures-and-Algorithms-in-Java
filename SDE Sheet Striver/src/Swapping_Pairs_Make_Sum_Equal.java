import java.sql.Array;
import java.util.Arrays;

public class Swapping_Pairs_Make_Sum_Equal {
    // https://practice.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal4142/1?page=1&company[]=Amazon&curated[]=1&sortBy=submissions
    // Wrong

    long findSwapValues(long[] A, int n, long[] B, int m) {
        Arrays.sort(A);
        Arrays.sort(B);

        long s1 = 0;
        for (long ele : A)
            s1 += ele;
        long s2 = 0;
        for (long ele : B)
            s2 += ele;
        long diff = 0;
        if (s1 == s2)
            return 1;
        else if (s1 < s2) {
            diff = s2 - s1;
        } else {
            diff = s1 - s2;
        }


        int i = 0;
        int j = 0;
        while (i < n && j < m) {

            if (A[i] < B[j]) {
                if (diff == B[j] + A[i])
                    return 1;
                i++;
            }else {
                if (diff == B[j] + A[i])
                    return 1;
                j++;
            }
        }
        return -1;

    }
}
