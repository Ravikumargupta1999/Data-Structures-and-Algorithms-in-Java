import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1
//https://www.youtube.com/watch?v=BvKv-118twg
public class Array_Pair_Sum_Divisibility_Problem {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            int count = map.getOrDefault(rem, 0);
            map.put(rem, count + 1);
        }
        for (int val : arr) {
            int rem = val % k;
            if (rem == 0) {
                int fq = map.get(rem);
                if (fq % 2 == 1){
//                    System.out.println(false);
                    return false;
                }
            } else if (2 * rem == k) {
                int fq = map.get(rem);
                if (fq % 2 == 1){
//                    System.out.println(false);
                    return false;
                }
            } else {
                int x1 = map.get(rem);
                int x2 = map.getOrDefault(k - rem, 0);
                if (x1 != x2){
//                    System.out.println(false);
                    return false;
                }
            }
        }
//        System.out.println(true);
        return true;
    }
}
