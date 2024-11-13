import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://leetcode.com/problems/flipping-an-image/submissions/
public class Flipping_an_Image {
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int[] a : image) {
            for (int i = 0; i < (a.length + 1) / 2; i++) {
                System.out.println(a.length - 1 - i + "  " + i);
                int temp = a[a.length - 1 - i] ^ 1;
                a[a.length - 1 - i] = a[i] ^ 1;
                a[i] = temp;
            }
            System.out.println(Arrays.toString(a));
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println(Arrays.toString(flipAndInvertImage(arr)));
    }
}
