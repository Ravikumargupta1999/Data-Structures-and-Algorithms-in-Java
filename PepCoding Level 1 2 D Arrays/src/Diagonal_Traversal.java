public class Diagonal_Traversal {
//https://www.youtube.com/watch?v=lvRdFCMD_Ew&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=15
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}

        };
        diagonalTraversal(arr);
    }
    public static void diagonalTraversal(int[][] arr)
    {
        for(int g=0;g<arr.length;g++)
        {
            for(int i=0,j=g;j<arr.length;j++,i++)
            {
                System.out.print(arr[i][j]+"  ");
            }
        }
        System.out.print("\n");
    }
}
