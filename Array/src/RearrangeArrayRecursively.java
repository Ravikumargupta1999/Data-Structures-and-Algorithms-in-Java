import java.util.ArrayList;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1#
public class RearrangeArrayRecursively {
    public static int[] RearrangeArray(int[] arr, int n) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0)
                al1.add(arr[i]);
            else
                al2.add(arr[i]);
        }
        int i = 0;
        int k = 0;
        int j = 0;
        while (i < al1.size() || j < al2.size()) {
            if (i < al1.size()) {
                arr[k++] = al1.get(i++);
            }
            if (j < al2.size()) {
                arr[k++] = al2.get(j++);
            }
        }
        return arr;
    }
}
// https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1#
// https://www.youtube.com/watch?v=kQrezgskpho