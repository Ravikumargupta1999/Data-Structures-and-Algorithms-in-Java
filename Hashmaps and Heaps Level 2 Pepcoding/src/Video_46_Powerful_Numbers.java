import java.util.ArrayList;
import java.util.HashSet;

//  https://www.geeksforgeeks.org/print-all-integers-that-are-sum-of-powers-of-two-given-numbers/
public class Video_46_Powerful_Numbers {
    public static ArrayList<Integer> powerfulIntegers(int x, int y, int bound) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                set.add(i + j);
                if (y == 1)
                    break;
            }
            if (x == 1)
                break;
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2, 1, 10));
    }
}
