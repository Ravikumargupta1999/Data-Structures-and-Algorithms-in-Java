import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Largest_Area_of_Integer {
    static final int R = 3;
    static final int C = 5;

    // Returns area of the largest rectangle of 1's
    static int maxArea(int mat[][])
    {
        int hist[][] = new int[R + 1][C + 1];

        // Step 1: Fill the auxiliary array hist[][]
        for (int i = 0; i < C; i++)
        {
            // First row in hist[][] is copy of first row in mat[][]
            hist[0][i] = mat[0][i];

            // Fill remaining rows of hist[][]
            for (int j = 1; j < R; j++)
            {
                hist[j][i] = (mat[j][i] == 0) ? 0 : hist[j - 1][i] + 1;
            }
        }
        for(int i= 0;i<hist.length;i++)
        {
            for(int j =0;j<hist[0].length;j++)
            {
                System.out.print(hist[i][j]+"  ");
            }
            System.out.println("");
        }

        // Step 2: Sort rows of hist[][] in non-increasing order
        for (int i = 0; i < R; i++)
        {
            int count[] = new int[R + 1];

            // counting occurrence
            for (int j = 0; j < C; j++)
            {
                count[hist[i][j]]++;
            }

            // Traverse the count array from right side
            int col_no = 0;
            for (int j = R; j >= 0; j--)
            {
                if (count[j] > 0)
                {
                    for (int k = 0; k < count[j]; k++)
                    {
                        hist[i][col_no] = j;
                        col_no++;
                    }
                }
            }
        }

        // Step 3: Traverse the sorted hist[][] to find maximum area
        int curr_area, max_area = 0;
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                // Since values are in decreasing order,
                // The area ending with cell (i, j) can
                // be obtained by multiplying column number
                // with value of hist[i][j]
                curr_area = (j + 1) * hist[i][j];
                if (curr_area > max_area)
                {
                    max_area = curr_area;
                }
            }
        }
        return max_area;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int mat[][] = {{0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0}};
        System.out.println("Area of the largest rectangle is " + maxArea(mat));
    }
}
