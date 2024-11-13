import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Counting_elements_in_two_arrays {
    static class Pair {
        int val;
        int count;

        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n) {
        Arrays.sort(arr2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++)
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);

        ArrayList<Pair> al = new ArrayList<>();
        al.add(new Pair(arr2[0], map.get(arr2[0])));

        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] != arr2[i - 1]) {
                al.add(new Pair(arr2[i], al.get(al.size() - 1).count + map.get(arr2[i])));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            int j = 0;
            while (j < al.size() && al.get(j).val <= arr1[i]) {
                j++;
            }
            if( j != 0)
                result.add(al.get(j - 1).count);
            if (j == 0)
                result.add(0);
        }
        return result;

    }

    public static void main(String[] args) {

        int arr1[] = {4, 8, 7, 5, 1};
        int arr2[] = {4, 48, 3, 0, 1, 1, 5};
        System.out.println(countEleLessThanOrEqual(arr1, arr2, arr1.length, arr2.length));
    }
}
