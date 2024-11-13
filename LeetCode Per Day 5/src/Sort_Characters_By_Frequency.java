import java.util.Arrays;

public class Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        int[] frequencies = new int[126];
        for (char ch : s.toCharArray())
            frequencies[ch]++;
        int[][] arr = new int[126][2];
        for (int i = 0; i < frequencies.length; i++)
            arr[i] = new int[]{frequencies[i], i};
        Arrays.sort(arr, (a, b) -> {
            return b[0] - a[0];
        });
        StringBuilder sb = new StringBuilder("");
        for (int[] ar : arr) {
            int index = ar[1];
            int freq = ar[0];

            while (freq-- > 0)
                sb.append((char) (index));
        }
        return sb.toString();
    }
}
