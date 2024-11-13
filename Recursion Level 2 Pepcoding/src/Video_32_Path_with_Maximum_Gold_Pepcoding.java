import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=lNwXq3Ki32I&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=31
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/gold-mine-2-official/ojquestion
public class Video_32_Path_with_Maximum_Gold_Pepcoding {
    static int max = 0;

    public static void getMaxGold(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    ArrayList<Integer> bag = new ArrayList<>();
                    findMaxGoldPath(arr,i,j,bag,visited);
                    int sum= 0;
                    for (int val : bag)
                        sum += val;
                    max = Math.max(max,sum);
                }
            }
        }
    }

    public static void findMaxGoldPath(int[][] grid, int i, int j, ArrayList<Integer> bag, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return ;
        }
        visited[i][j] = true;
        bag.add(grid[i][j]);
        findMaxGoldPath(grid, i, j - 1, bag, visited);
        findMaxGoldPath(grid, i, j + 1, bag, visited);
        findMaxGoldPath(grid, i - 1, j, bag, visited);
        findMaxGoldPath(grid, i + 1, j, bag, visited);


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
        getMaxGold(arr);
        System.out.println(max);
    }
}
