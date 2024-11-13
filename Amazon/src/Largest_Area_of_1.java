//https://practice.geeksforgeeks.org/problems/find-the-largest-rectangle-of-1s-with-swapping-of-columns-allowed0243/1/?category[]=Arrays&category[]=Arrays&difficulty[]=2&page=1&query=category[]Arraysdifficulty[]2page1category[]Arrays#
// c plus ka gfg article accept hua
// gfg ke drive code mein hi mistake hai
public class Largest_Area_of_1 {
    static int maxArea(boolean[][] mat, int r, int c) {
      //  for(int)
        int hist[][] = new int[r + 1][c + 1];
        for (int i = 0; i < c; i++)
        {
            hist[0][i] = (mat[0][i] == false) ? 0 :1 ;
            for (int j = 1; j < r; j++)
            {
                hist[j][i] = (mat[j][i] == false) ? 0 : hist[j - 1][i] + 1;
            }
        }
        for (int i = 0; i < r; i++)
        {
            int count[] = new int[r + 1];
            for (int j = 0; j < c; j++)
            {
                count[hist[i][j]]++;
            }
            int col_no = 0;
            for (int j = r; j >= 0; j--)
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
        int curr_area, max_area = 0;
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                curr_area = (j + 1) * hist[i][j];
                if (curr_area > max_area)
                {
                    max_area = curr_area;
                }
            }
        }
        return max_area;

    }
    public static void main(String[] args) {
        boolean[][] mat = {{false, true, false, true, false},
                {false, true, false, true, true},
                {true, true, false, true, false}};
        System.out.println(maxArea(mat,mat.length,mat[0].length));

    }
}
//{{0, 1, 0, 1, 0},
//        {0, 1, 0, 1, 1},
//        {1, 1, 0, 1, 0}};
