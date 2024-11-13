package Recursion;
// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#

import java.util.ArrayList;

public class Rat_in_a_Maze_Problem {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        ArrayList<String> arrayList = findPath(arr, arr.length);
        System.out.println(arrayList);
        System.out.println(arrayList.size());

    }

    public static ArrayList<String> findPath(int[][] maze, int n) {
        ArrayList<String> str = new ArrayList<>();
        findTotalPaths(maze, "", 0, 0, str, new boolean[maze.length][maze.length]);
        return str;
    }

    public static void findTotalPaths(int[][] maze, String str, int row, int col, ArrayList<String> ans, boolean[][] visited) {
        if (row >= maze.length || row < 0 || col >= maze.length || col < 0 || maze[row][col] == 0 || visited[row][col])
            return;
        if (row == maze.length - 1 && col == maze.length - 1) {
            ans.add(str);
            return;
        }
        visited[row][col] = true;
        findTotalPaths(maze, str + "D", row + 1, col, ans, visited);
        findTotalPaths(maze, str + "L", row, col - 1, ans, visited);
        findTotalPaths(maze, str + "R", row, col + 1, ans, visited);
        findTotalPaths(maze, str + "U", row - 1, col, ans, visited);
        visited[row][col] = false;

    }
}
