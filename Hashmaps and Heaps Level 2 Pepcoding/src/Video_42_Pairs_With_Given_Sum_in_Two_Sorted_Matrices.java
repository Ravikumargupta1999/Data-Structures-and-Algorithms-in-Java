import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/count-pairs-sum-in-matrices4332/1/#
public class Video_42_Pairs_With_Given_Sum_in_Two_Sorted_Matrices {
    // TC : O(n^2)
    // SC : O(n^2)
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        HashSet<Integer> set = new HashSet<>();
        for (int[] ele : mat2) {
            for (int e : ele) {
                set.add(e);
            }
        }

        int count = 0;
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (set.contains(x - mat1[i][j]))
                    count++;
            }
        }
        return count;
    }

    // TC : O(n^2)
    // SC : O(1)

    static int countPairs1(int mat1[][], int mat2[][], int n, int x) {
        int row1 = 0;
        int col1 = 0;
        int col2 = n - 1;
        int row2 = n - 1;
        int ans = 0;

        while (row1 < n && col1 < n && row2 >= 0 && col2 >= 0) {
            int val = mat1[row1][col1] + mat2[row2][col2];
//            System.out.println(val + "   " + mat1[row1][col1] + "  " + mat2[row2][col2]);
//            System.out.println(row1 + "  " + col1 + "  " + row2 + "   " + col2);
            if (val == x)
                ans++;
            if (val == x) {
                int[] temp1 = increaseMat1(row1,col1,n);
                row1 = temp1[0];
                col1 = temp1[1];

                int[] temp2 = decreaseMat2(row2,col2,n);
                row2 = temp2[0];
                col2 = temp2[1];

            } else if (val < x) {
//                if(mat1[row1][col1] < mat2[row2][col2]){
                int[] temp1 = increaseMat1(row1,col1,n);
                row1 = temp1[0];
                col1 = temp1[1];
//                }
            } else if(val > x) {
                int[] temp2 = decreaseMat2(row2,col2,n);
                row2 = temp2[0];
                col2 = temp2[1];

            }
//            System.out.println(row1 + "  " + col1 + "  " + row2 + "   " + col2);
//            System.out.println(ans + "\n");
        }

        return ans;

    }

    static int[] increaseMat1(int row1, int col1, int n) {
        if (col1 == n - 1) {
            col1 = 0;
            row1++;
        } else {
            col1++;
        }
        return new int[]{row1, col1};
    }

    static int[] decreaseMat2(int row2, int col2, int n) {
        if ( col2 == 0) {
            row2--;
            col2 = n - 1;
        } else {
            col2--;
        }
        return new int[]{row2, col2};

    }
    public static void main(String[] args) {
        int[][] mat1 = {{3, 5, 7},
                {8, 11, 12},
                {13, 14, 17}};
        int[][] mat2 = {{3, 4, 5},
                {6, 7, 9},
                {11, 12, 12}};
        System.out.println(countPairs1(mat1, mat2, mat1.length, 15));
    }

}
//3 15
//        3 5 7
//        8 11 12
//        13 14 17
//        3 4 5
//        6 7 9
//        11 12 12