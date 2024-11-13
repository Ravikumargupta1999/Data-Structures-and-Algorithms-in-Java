public class Searching_Sorting_105_Middle_of_Three {
    // https://practice.geeksforgeeks.org/problems/middle-of-three2926/1
    // 4 Comparisons
    int middle(int A, int B, int C) {
        int sum = A + B + C;
        return sum - Math.max(A, Math.max(B, C)) - Math.min(A, Math.min(B, C));
    }
}
