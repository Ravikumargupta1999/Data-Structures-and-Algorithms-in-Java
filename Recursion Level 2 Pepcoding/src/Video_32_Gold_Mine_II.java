import java.util.ArrayList;
import java.util.Scanner;

public class Video_32_Gold_Mine_II {
    public static void getMaximumGold_(int[][] grid,int row,int col,boolean[][] visited,ArrayList<Integer> list,int[][] dir) {

        if( row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0)
            return;
        visited[row][col] = true;
        list.add(grid[row][col]);
        for (int[] arr : dir){
            getMaximumGold_(grid,row + arr[0],col + arr[1],visited,list,dir);
        }
    }


    public static int getMaxGold(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

        int maxGold = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0 && !visited[i][j])
                {
                    ArrayList<Integer> list = new ArrayList<>();
                    getMaximumGold_(grid,i,j,visited,list,dir);
                    int sum = 0;
                    for (int val : list)
                        sum+= val;
                    maxGold = Math.max(maxGold,sum);
                }
            }
        }
        return maxGold;
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int max = getMaxGold(arr);
        System.out.println(max);
    }
}
