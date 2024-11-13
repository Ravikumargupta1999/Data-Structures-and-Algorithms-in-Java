import java.util.HashMap;
import java.util.HashSet;

public class FiboancciChecker {
    public static void main(String[] args) {
        System.out.println(fibonacciChecker(89));
    }
    public static String fibonacciChecker(int num){
        HashSet<Integer>set = new HashSet<>();
        set.add(0);
        set.add(1);
        set.add(2);
        int first = 1;
        int second = 2;
        while (first + second < Integer.MAX_VALUE && first+second >0)
        {
            set.add(first+second);
            int temp = first + second;
            first = second;
            second = temp;
        }

        if(set.contains(num))
            return "yes";
        else
            return "no";
    }


}
