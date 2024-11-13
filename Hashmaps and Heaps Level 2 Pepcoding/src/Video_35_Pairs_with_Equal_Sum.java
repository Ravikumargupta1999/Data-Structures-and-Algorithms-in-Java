import java.util.HashSet;

public class Video_35_Pairs_with_Equal_Sum {

    public static boolean solution(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(arr[i] + arr[j]))
                    return true;
                else
                    set.add(arr[i] + arr[j]);
            }
        }

        return false;
    }
}
