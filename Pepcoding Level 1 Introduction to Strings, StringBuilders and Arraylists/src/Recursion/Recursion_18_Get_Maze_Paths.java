package Recursion;
// https://www.youtube.com/watch?v=ox3TswFFKDI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=30

import java.util.ArrayList;

public class Recursion_18_Get_Maze_Paths {
    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();
        String sb = "";
        getMazePaths(1, 1, 8, 9, sb, result);
        System.out.println(result);
        System.out.println(result.size());
    }

    public static void getMazePaths(int a, int b, int n, int m, String sb, ArrayList<String> result) {
        if (a > n || b > m)
            return;
        if (a == n && b == m) {
            result.add(sb);
            return;
        }
        getMazePaths(a + 1, b, n, m, sb + "D", result);
        getMazePaths(a, b + 1, n, m, sb + "R", result);

    }
}
