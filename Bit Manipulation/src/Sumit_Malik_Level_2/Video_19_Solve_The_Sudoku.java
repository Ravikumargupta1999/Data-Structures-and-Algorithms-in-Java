package Sumit_Malik_Level_2;

import java.util.Scanner;

public class Video_19_Solve_The_Sudoku {
    // https://www.youtube.com/watch?v=SXimkBvg50Q&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=19
    static void printGrid(int board[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
//            System.out.println("");
        }
//        System.out.println("\n");
    }

    public static boolean solveSudoku(int[][] arr, int[] rows, int[] cols, int[][] grid, int i, int j) {
        // write your code here. Use display function to display arr
        if (i == arr.length) {
            return true;
        }
        if (arr[i][j] == 0) {
            for (int nums = 1; nums <= 9; nums++) {
                if ((rows[i] & (1 << nums)) == 0 && (cols[j] & (1 << nums)) == 0 && (grid[i / 3][j / 3] & (1 << nums)) == 0) {
                    arr[i][j] = nums;
                    rows[i] ^= (1 << nums);
                    cols[j] ^= (1 << nums);
                    grid[i / 3][j / 3] ^= (1 << nums);
                    if (solveSudoku(arr, rows, cols, grid, j < 8 ? i : i + 1, j < 8 ? j + 1 : 0))
                        return true;
                    else {
                        arr[i][j] = 0;
                        rows[i] ^= (1 << nums);
                        cols[j] ^= (1 << nums);
                        grid[i / 3][j / 3] ^= (1 << nums);
                    }
                }
            }
            return false;
        }
        return solveSudoku(arr, rows, cols, grid, j < 8 ? i : i + 1, j < 8 ? j + 1 : 0);
    }

    static boolean SolveSudoku(int[][] arr) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] grid = new int[3][3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                int digit = arr[i][j];
                rows[i] |= (1 << digit);
                cols[j] |= (1 << digit);
                grid[i / 3][j / 3] |= (1 << digit);
            }
        }
        return solveSudoku(arr, rows, cols, grid, 0, 0);
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 1, 6, 5, 7, 8, 4, 9, 2},
                {5, 2, 9, 1, 3, 4, 7, 6, 8},
                {4, 8, 7, 6, 2, 9, 5, 3, 1},
                {2, 6, 3, 0, 1, 5, 9, 8, 7},
                {9, 7, 4, 8, 6, 0, 1, 2, 5},
                {8, 5, 1, 7, 9, 2, 6, 4, 3},
                {1, 3, 8, 0, 4, 7, 2, 0, 6},
                {6, 9, 2, 3, 5, 1, 8, 7, 4},
                {7, 4, 5, 0, 8, 6, 3, 1, 0}};
        SolveSudoku(arr);
    }



}
