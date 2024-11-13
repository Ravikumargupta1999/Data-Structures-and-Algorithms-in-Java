import java.util.ArrayList;

public class Anti_Diagonal_Traversal_of_Matrix {
    //https://practice.geeksforgeeks.org/problems/print-diagonally1623/0/
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        int n = matrix.length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= 2 * n - 2; i++)
            al.add(new ArrayList<>());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                al.get(i + j).add(matrix[i][j]);
            }
        }
        int k= 0;
        int[] res = new int[n*n];
        for(int i=0;i<al.size();i++)
        {
            for(int j=0;j<al.get(i).size();j++)
                res[k++] = al.get(i).get(j);
        }
        return res;
    }
}
