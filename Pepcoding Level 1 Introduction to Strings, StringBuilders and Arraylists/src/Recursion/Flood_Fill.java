package Recursion;

import java.util.ArrayList;

public class Flood_Fill {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        floodFill(arr,0,0,"",res,visited);
        System.out.println(res);
    }

    static void floodFill(int[][] arr, int row, int col, String psf, ArrayList<String> res, boolean[][] visited) {
        if (row < 0 || col < 0 || row == arr.length || col == arr[0].length - 1 || arr[row][col] == 1 || visited[row][col])
            return;
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            res.add(psf);
            return;
        }
        visited[row][col] = true;
        floodFill(arr, row - 1, col, psf + "t", res, visited);
        floodFill(arr, row, col - 1, psf + "l", res, visited);
        floodFill(arr, row + 1, col, psf + "d", res, visited);
        floodFill(arr, row, col + 1, psf + "r", res, visited);
        visited[row][col] = false;
    }
}
