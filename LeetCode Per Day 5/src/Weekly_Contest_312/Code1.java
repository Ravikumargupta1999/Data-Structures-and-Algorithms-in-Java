package Weekly_Contest_312;

import java.util.Arrays;

public class Code1 {
    class pair {
        String str;
        int i;

        pair(String s, int i) {
            this.str = s;
            this.i = i;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        pair[] arr = new pair[names.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new pair(names[i], heights[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            return b.i - a.i;
        });
        for (int i = 0; i < names.length; i++) {
            names[i] = arr[i].str;
        }
        return names;
    }
}
