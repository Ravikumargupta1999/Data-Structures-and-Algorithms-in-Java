import java.util.ArrayList;
import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/ishaan-and-sticks0542/1#
public class Video_42_Ishaan_and_Sticks {
    public static ArrayList<Integer> square(int arr[], int n) {
        if (n == 0) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(-1);
            return al;
        }
        if (n < 3) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(-1);
            return al;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        int max = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for (int ele : map.keySet()) {
            int count = map.get(ele);
            map.remove(ele);
            if (count >= 4 && ele * ele > max) {
                if (al.size() != 0) {
                    al.set(0, ele * ele);
                    al.set(1, count / 4);
                    max = ele * ele;
                } else {
                    al.add(ele * ele);
                    al.add(count / 4);
                    max = ele * ele;
                }
            }

        }
        if (al.size() < 2) {
            ArrayList<Integer> al1 = new ArrayList<>();
            al1.add(-1);
            return al1;
        }
        return al;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 9, 2, 2, 2, 2, 2};
        System.out.println(square(arr, arr.length));
    }
}
