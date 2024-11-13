import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Video_4_Combinations_Part_2 {
    public static void combinations(boolean[] boxes, int ci, int ti, int lb) {
        // write your code here
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i])
                    System.out.print("1 ");
                else
                    System.out.print("_ ");
            }
            System.out.println();
            return;
        }
        for (int b = lb; b < boxes.length; b++) {
            if (!boxes[b]) {
                boxes[b] = true;
                combinations(boxes, ci + 1, ti, b);
                boxes[b] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 4;
        int r = 3;
        combinations(new boolean[n], 1, r, 0);
    }

}
