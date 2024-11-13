public class Boolean_Matrix {
 // https://practice.geeksforgeeks.org/problems/boolean-matrix-problem-1587115620/1/?category[]=Arrays&category[]=Arrays&company[]=Microsoft&company[]=Microsoft&difficulty[]=1&page=1&query=category[]Arrayscompany[]Microsoftdifficulty[]1page1company[]Microsoftcategory[]Arrays#
    
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][]) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for (int i = 0; i < row.length; i++)
            for (int j = 0; j < col.length; j++)
                if (matrix[i][j] == 1)
                    row[i] = col[j] = 1;
        for (int i = 0; i < row.length; i++)
            for (int j = 0; j < col.length; j++)
                if (row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 1;
        return;
    }
}
