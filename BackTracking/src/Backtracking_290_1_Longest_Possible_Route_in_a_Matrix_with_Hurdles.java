import java.util.ArrayList;

// https://www.geeksforgeeks.org/longest-possible-route-in-a-matrix-with-hurdles/
// https://practice.geeksforgeeks.org/problems/longest-possible-route-in-a-matrix-with-hurdles/1#
public class Backtracking_290_1_Longest_Possible_Route_in_a_Matrix_with_Hurdles {
    public static int longestPath(int[][] matrix, int n, int m, int sx, int sy, int dx, int dy) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        if(matrix[sx][sy] == 0){
            return -1;
        }
        longestPathInMatrix(matrix, sx, sy, dx, dy, 0, new boolean[matrix.length][matrix[0].length],arrayList);
        return arrayList.get(0);
    }
    public static void longestPathInMatrix(int[][] matrix, int row, int col, int dx, int dy, int len, boolean[][] visited,ArrayList<Integer> arrayList) {
        if (row == dx && col == dy) {
            arrayList.set(0, Math.max(arrayList.get(0), len));
            return;
        }
        visited[row][col] = true;
        if (isValid(row - 1, col, visited, matrix))
            longestPathInMatrix(matrix, row - 1, col, dx, dy, len + 1, visited,arrayList);
        if (isValid(row + 1, col, visited, matrix))
            longestPathInMatrix(matrix, row + 1, col, dx, dy, len + 1, visited,arrayList);
        if (isValid(row, col - 1, visited, matrix))
            longestPathInMatrix(matrix, row, col - 1, dx, dy, len + 1, visited,arrayList);
        if (isValid(row, col + 1, visited, matrix))
            longestPathInMatrix(matrix, row, col + 1, dx, dy, len + 1, visited,arrayList);
        visited[row][col] = false;
    }
    public static boolean isValid(int row, int col, boolean[][] visited, int[][] matrix) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == 0 || visited[row][col]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // https://www.geeksforgeeks.org/longest-possible-route-in-a-matrix-with-hurdles/
//        int mat[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        // https://www.techiedelight.com/find-longest-possible-route-matrix/
        // https://www.youtube.com/watch?v=X1cWKI83tZo
//        int[][] mat = {
//                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
//        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
//        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
//        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
//        { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
//        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
//        { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
//        { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
//        { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
//        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }};

//        System.out.println("Length of longest possible route is  " + findLongestPath(mat, 0, 0, 5, 7));
//        2 6
//        0 0 1 3
//        1 1 0 1 1 0
//        1 1 1 1 1 1

        int[][] matrix = {{1,1,0,1,1,0},{1,1,1,1,1,1}};
        System.out.println(longestPath(matrix,2,6,0,0,1,3));
    }
}
