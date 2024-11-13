import java.util.ArrayList;
import java.util.List;

public class Diagonal_Difference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int i = 0;
        int j = 0;
        int left = 0;

        while (i < arr.size()) {
            left += arr.get(i).get(j);
            i++;
            j++;
        }
        System.out.println(left);
        int right = 0;
        i = 0;
        j = arr.size() - 1;
        while (j >= 0) {
            right += arr.get(i).get(j);
            i++;
            j--;
        }
        System.out.println(right);
        return Math.abs(left - right);
    }

    public static void main(String[] args) {
        int[][] arr = {{11, 2, 4},
                {4, 5, 6},
                {10, 8, -12}
        };
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            list.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            for (int val : arr[i]) {
                list.get(i).add(val);
            }
        }
        System.out.println(diagonalDifference(list));

    }
}
