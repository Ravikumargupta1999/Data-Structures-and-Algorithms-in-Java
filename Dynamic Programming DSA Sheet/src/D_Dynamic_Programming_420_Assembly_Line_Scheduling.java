public class D_Dynamic_Programming_420_Assembly_Line_Scheduling {

    // https://practice.geeksforgeeks.org/problems/assembly-line-scheduling/1
    // https://www.youtube.com/watch?v=EqGpcClPkkw

    public static int carAssembly(int n, int[][] a, int[][] t, int[] e, int[] x) {
        int path1 = e[0] + a[0][0];
        int path2 = e[1] + a[1][0];

        for (int i = 1; i < n; i++) {
            // for path1

            int st1 = path1 + a[0][i];
            int st2 = path2 + a[0][i] + t[1][i];

            // for path2

            int st3 = path2 + a[1][i];
            int st4 = path1 + a[1][i] + t[0][i];

            path1 = Math.min(st1, st2);
            path2 = Math.min(st3, st4);
        }
        return Math.min(path1 + x[0], path2 + x[1]);
    }

    public static void main(String[] args) {
//        int N = 4;
//        int[][] a = {{4, 5, 3, 2}, {2, 10, 1, 4}};
//        int[][] t = {{0, 7, 4, 5}, {0, 9, 2, 8}};
//        int[] e = {10, 12};
//        int[] x = {18, 7};
//
//        System.out.println(carAssembly(N,a,t,e,x));

        System.out.println("10" + 5);
    }
}
