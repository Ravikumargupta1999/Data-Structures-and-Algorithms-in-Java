package Day_12_Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
// https://www.codingninjas.com/codestudio/problems/k-max-sum-combinations_975322?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
// https://www.interviewbit.com/problems/maximum-sum-combinations/
// https://www.youtube.com/watch?v=55TeHh37Ly8
public class K_Max_Sum_Combinations {
    public static void main(String[] args) {
        int[] arr1 = {59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};
        int[] arr2 = {59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        for (int num : arr1)
            l1.add(num);
        for (int num : arr2)
            l2.add(num);
        System.out.println(kMaxSumCombination(l1, l2, l1.size(), 10));
    }

    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {
        Collections.sort(a);
        Collections.sort(b);
        Collections.reverse(a);
        Collections.reverse(b);
//        System.out.println(a+"   "+b);
        ArrayList<Integer> list = new ArrayList<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((c, d) -> {
            return (a.get(d[0]) + b.get(d[1])) - (a.get(c[0]) + b.get(c[1]));
        });
        HashSet<String> set = new HashSet<>();
        queue.add(new int[]{0, 0});
        set.add(0 + "  " + 0);

        while (!queue.isEmpty()) {
//            System.out.println("");
            int[] temp = queue.poll();
            String s = (temp[0])+" "+(temp[1]);
            if(set.contains(s))
                continue;
            set.add(s);
            list.add(a.get(temp[0]) + b.get(temp[1]));

            if (list.size() == k)
                return list;

            if (temp[0] + 1 >= a.size() || temp[1] + 1 >= b.size())
                continue;
            String s1 = (temp[0] + 1) + " " + (temp[1]);
            String s2 = (temp[0]) + " " + (temp[1] + 1);
            if (!set.contains(s1))
                queue.add(new int[]{temp[0] + 1, temp[1]});
            if (!set.contains(s2))
                queue.add(new int[]{temp[0], temp[1] + 1});
        }
        return list;
    }
}
