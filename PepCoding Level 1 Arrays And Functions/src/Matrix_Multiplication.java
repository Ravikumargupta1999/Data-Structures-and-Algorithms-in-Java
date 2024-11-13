public class Matrix_Multiplication {
    // https://practice.geeksforgeeks.org/problems/multiply-matrices/1
    // https://www.youtube.com/watch?v=eLIT5fnKmMI&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=2
    public static void multiply(int A[][], int B[][], int C[][], int n) {
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<A.length;j++)
            {
                int temp = 0;
                for (int k=0;k<A[0].length;k++)
                {
                    temp += (A[i][k]+B[k][j]);
                }
                C[i][j] = temp;
            }
        }

    }

    public static void main(String[] args) {

    }
}
