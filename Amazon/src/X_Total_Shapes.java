// https://practice.geeksforgeeks.org/problems/x-total-shapes3617/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=company[]Amazondifficulty[]1page1company[]Amazon#

public class X_Total_Shapes {

    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] arr) {
        int n = arr.length;
        int k = arr[0].length;
        boolean visited[][] = new boolean[n][k];
        int count = 0;
        boolean flag;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (arr[i][j] == 'X' && !visited[i][j]) {
                    DFS(visited, arr, i, j, n, k);
                    count++;
                }
            }
        }
        return count;

    }

    public void DFS(boolean visited[][], char arr[][], int i, int j, int n, int k) {
        if (arr[i][j] == 'X' && !visited[i][j]) {
            visited[i][j] = true;
            if (i + 1 < n) DFS(visited, arr, i + 1, j, n, k);
            if (i - 1 >= 0) DFS(visited, arr, i - 1, j, n, k);
            if (j + 1 < k) DFS(visited, arr, i, j + 1, n, k);
            if (j - 1 >= 0) DFS(visited, arr, i, j - 1, n, k);
        } else
            return;
    }

    public static void main(String[] args) {
        X_Total_Shapes a = new X_Total_Shapes();
        System.out.println(a.xShape(new char[][]{{'X', '0', '0'}, {'0', 'X', '0'}, {'X', 'X', 'X'}}));
    }
}
//    XOOXXO
//            OOOXXX
//    OXXXXX
//            OOXOOX
//OOXXOO

//new char[][]{{'X', '0', '0', 'X', 'X', '0'}, {'0', '0', '0', 'X', 'X', 'X'},
//        {'0', 'X', 'X', 'X', 'X', 'X'}, {'0', '0', 'X', '0', '0', 'X'},
//        {'0', '0', 'X', 'X', '0', '0'}}