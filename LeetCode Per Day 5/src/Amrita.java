import java.util.HashMap;
import java.util.HashSet;

public class Amrita {

    public static int fun(int n, String[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(i);
        String s = "";
        boolean[] visited = new boolean[arr.length];
        return recursion(s, arr, 0, n, visited) ? 1 : 0;
    }

    public static boolean recursion(String s, String[] arr, int i, int n, boolean[] visited) {
        System.out.println(i+"   "+s);
        if (i == n) {
            System.out.println(s);
            return checkValid(s);
        }
        for (int j = 0; j < n; j++) {
            if (!visited[j]) {

                visited[j] = true;
                if (recursion( s + arr[j], arr, i + 1, n, visited))
                    return true;

                visited[j] = false;
            }
        }
        return false;
    }

    public static boolean checkValid(String s) {
        HashSet<Character> set = new HashSet<>();
        char prev = s.charAt(0);
        set.add(prev);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (set.contains(s.charAt(i)))
                    return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr = {"ABB", "AD"};
        System.out.println(fun(arr.length,arr));
    }
}
