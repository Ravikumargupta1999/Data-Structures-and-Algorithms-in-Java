import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/pairs-of-non-coinciding-points4141/1#
public class Video_59_Pairs_of_Non_Coinciding_Points {
    static int numOfPairs(int[] X, int[] Y, int n) {
        // code here
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        HashMap<String, Integer> xyMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < X.length; i++) {
            int x = X[i];
            int y = Y[i];
            String xy = "" + x + "*" + y;
            int xFreq = xMap.getOrDefault(x, 0);
            int yFreq = yMap.getOrDefault(y, 0);
            int xyFreq = xyMap.getOrDefault(xy, 0);
            sum += xFreq + yFreq - 2 * xyFreq;
            xMap.put(x, xFreq + 1);
            yMap.put(y, yFreq + 1);
            xyMap.put(xy, xyFreq + 1);
        }
        return sum;
    }
}
