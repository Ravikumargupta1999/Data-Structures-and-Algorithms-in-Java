import java.util.ArrayList;
import java.util.Collections;

public class Circle_of_strings {
    static int isCircle(int n, String a[]) {
        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < n; i++)
            str.add(a[i]);
        Collections.sort(str);
        for (int i = 0; i < str.size(); i++) {
            a[i] = str.get(i);
        }
        for (int i = 1; i < n; i++) {
            if (a[i - 1].charAt(a[i - 1].length() - 1) != a[i].charAt(0))
                return 0;
        }
        if (a[0].charAt(0) == a[n - 1].charAt(a[n - 1].length() - 1))
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        int n = 4;
        String[] arr = {"abca", "bcdb", "cccc", "abca"};
        System.out.println(isCircle(arr.length, arr));
    }
}
