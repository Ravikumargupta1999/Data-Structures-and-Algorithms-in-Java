import java.util.*;

public class SubSet_Of_An_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2,2, 3};
        System.out.println(subsets(arr));
    }

    static void generatesSubset(int ind, int[] arr, List<Integer> al, List<List<Integer>> al1) {
        System.out.println(al);
        al1.add(new ArrayList<>(al));
        for (int i = ind; i < arr.length; i++) {
            if (i != ind && arr[i] == arr[i - 1])
                continue;
            // generatesSubset(i + 1, arr, al, al1);
            al.add(arr[i]);
            generatesSubset(i + 1, arr, al, al1);
            al.remove(al.size() - 1);
        }

    }

    static List<List<Integer>> subsets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> al1 = new ArrayList<>();
        generatesSubset(0, arr, new ArrayList<>(), al1);
        Collections.sort(al1, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        return al1;
    }
}