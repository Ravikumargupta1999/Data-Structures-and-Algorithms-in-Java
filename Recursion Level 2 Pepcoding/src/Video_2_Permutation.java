import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Video_2_Permutation {
    public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
        if (cb > tb) {
            if (ssf == ts)
                System.out.println(asf);
            return;
        }
        for (int i = 0; i < ts; i++) {
            if (items[i] == 0) {
                items[i] = 1;
                permutations(cb + 1, tb, items, ssf + 1, ts, asf + " " + (i + 1));
                items[i] = 0;
            }
        }
        permutations(cb + 1, tb, items, ssf, ts, asf + " " + 0);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nBoxes = 4;
        int rItems = 2;
        permutations(1, nBoxes, new int[rItems], 0, rItems, "");
    }
}
