import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/print-pattern3549/1

public class Print_Pattern_Gfg {
    static List<Integer> al = new ArrayList<>();

    static List<Integer> pattern(int n) {
        solve(n);
        return al;
    }

    public static void solve(int value) {
        if (value == 0 || value < 0) {

            al.add(value);
            return;
        }
        al.add(value);

        solve(value - 5);
        al.add(value);

    }

    public static void main(String[] args) {
        System.out.println(pattern(5));
    }
}
