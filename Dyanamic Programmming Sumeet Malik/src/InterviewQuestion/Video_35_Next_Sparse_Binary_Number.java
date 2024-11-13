package InterviewQuestion;

// https://practice.geeksforgeeks.org/problems/next-sparse-binary-number0029/1
public class Video_35_Next_Sparse_Binary_Number {
    static int nextSparse(int n){
        while (true) {
            if (isSparse(n))
                return n;
            n++;
        }
    }

    static boolean isSparse(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));

        for (int i = 1; i < sb.length(); i++) {
            if(sb.charAt(i) == '1' && sb.charAt(i-1) == '1')
                return false;

        }
        return true;
    }
}
