package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_19_Get_Maze_Path_With_Jumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> res = getMazePaths(1, 1, n, m);
        System.out.println(res);

    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        ArrayList<String> result = new ArrayList<>();
        String sb = "";
        getMazePaths(1, 1, 8, 9, sb, result);
        return result;
    }

    public static void getMazePaths(int a, int b, int n, int m, String sb, ArrayList<String> result) {
        if (a > n || b > m)
            return;
        if (a == n && b == m) {
            result.add(sb);
            return;
        }
        // vertically
        getMazePaths(a + 1, b, n, m, sb + "v1", result);
        getMazePaths(a + 2, b, n, m, sb + "v2", result);
        getMazePaths(a + 3, b, n, m, sb + "v3", result);

        //// horizentally
        getMazePaths(a, b + 1, n, m, sb + "h1", result);
        getMazePaths(a, b + 2, n, m, sb + "h2", result);
        getMazePaths(a, b + 3, n, m, sb + "h3", result);

        // diagonally
        getMazePaths(a + 1, b + 1, n, m, sb + "d1", result);
        getMazePaths(a + 2, b + 2, n, m, sb + "d2", result);
        getMazePaths(a + 3, b + 3, n, m, sb + "d3", result);


    }
}
