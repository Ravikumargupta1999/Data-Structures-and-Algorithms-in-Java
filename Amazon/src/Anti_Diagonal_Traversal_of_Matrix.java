import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/print-diagonally1623/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=12&query=company[]Amazondifficulty[]1page12company[]Amazon

public class Anti_Diagonal_Traversal_of_Matrix {

    public static int[] antiDiagonalPattern(int[][] matrix) {
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

    public static void main(String[] args) {
        int[][] arr = {
            {
                1, 2, 3
            },
            {
                4, 5, 6
            },
            {
                7, 8, 9
            }
        } ;
        System.out.println(Arrays.toString(antiDiagonalPattern(arr)));
    }
}
