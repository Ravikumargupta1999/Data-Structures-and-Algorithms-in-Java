package InterviewQuestion;

public class Video_40_Row_With_Minimum_Number_Of_1s {
    // https://practice.geeksforgeeks.org/problems/row-with-minimum-number-of-1s5430/1
    int minRow(int N, int M, int A[][]) {
        int min = M + 1;
        int row = -1;
        int i = 1;
        for (int[] arr : A) {
            int count = 0;
            for (int val : arr) {
                if (val == 1)
                    count++;
            }
            if (count < min) {
                min = count;
                row = i;
            }
            i++;
        }
        return row;
    }
}
