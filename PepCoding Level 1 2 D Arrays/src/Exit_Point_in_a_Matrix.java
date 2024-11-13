public class Exit_Point_in_a_Matrix {
    public static void main(String[] args) {

//        int[][] arr = {{0, 1, 0},
//                {0, 1, 1}, {0, 0, 0}};
        int[][] arr =  {{0, 0}};
        int[] res = FindExitPoint(arr);
        System.out.print(res[0]+"   "+res[1]);
    }
    //https://practice.geeksforgeeks.org/problems/exit-point-in-a-matrix0905/1#
    //https://www.youtube.com/watch?v=FUBlb360kqU&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=9
    public static int[] FindExitPoint(int[][] matrix)
    {
        int dir = 0;
        int i=0;
        int j = 0;
        while (true)
        {
            dir = (dir + matrix[i][j])%4;
            if( matrix[i][j] == 1)
            {
                matrix[i][j] = 0;
            }
            if ( dir == 0)
            {
                j++;
            }
            else if(dir == 1)
            {
                i++;
            }
            else if(dir == 2)
            {
                j--;
            }
            else if(dir == 3)
            {
                i--;
            }
            if( i < 0)
            {
                i++;
                break;
            }
            else if( j < 0)
            {
                j++;
                break;
            }
            else if( j == matrix[0].length)
            {
                j--;
                break;
            }
            else if( i== matrix.length)
            {
                i--;
                break;
            }
        }
        int[] res = {i,j};
        return res;
    }
}
