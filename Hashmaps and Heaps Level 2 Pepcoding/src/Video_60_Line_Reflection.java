import java.util.HashMap;
import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/line-reflection-official/ojquestion
// https://www.youtube.com/watch?v=ArsRc6Wqy1o&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=60
public class Video_60_Line_Reflection {
    public static boolean isReflected(int[][] points) {
        HashMap<Long, Long> map = new HashMap<>();
        long xmin = Integer.MAX_VALUE;
        long xmax = Integer.MIN_VALUE;
        for (int[] point : points) {
            long x = point[0];
            long y = point[1];
            xmin = Math.min(xmin, x);
            xmax = Math.max(xmax, x);
            long hash = x * 100000000 + y;
            map.put(hash, 1L);
        }
        long mirr = xmin + xmax;
        for (int[] point : points) {
            long x = point[0];
            long y = point[1];
            long ximage = mirr - x;
            long yimage = y;
            long imgaeHash = ximage * 100000000 + yimage;
            if (!map.containsKey(imgaeHash))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] points = new int[n][2];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                points[i][j] = scn.nextInt();
            }
        }

        System.out.println(isReflected(points));
    }

}
