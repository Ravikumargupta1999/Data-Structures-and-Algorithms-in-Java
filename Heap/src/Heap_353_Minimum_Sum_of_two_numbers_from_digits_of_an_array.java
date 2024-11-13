import java.util.PriorityQueue;

public class Heap_353_Minimum_Sum_of_two_numbers_from_digits_of_an_array {
    // https://practice.geeksforgeeks.org/problems/minimum-sum4058/1
    String solve(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : arr) {
            pq.add(val);
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (pq.size() > 1) {
            sb1.append(pq.poll());
            sb2.append(pq.poll());
        }
        if (pq.size() != 0)
            sb1.append(pq.poll());
        // System.out.println(sb1 + "   " + sb2);
        return addString(sb1, sb2);
    }

    public String addString(StringBuilder sb1, StringBuilder sb2) {
        int i = sb1.length() - 1;
        int j = sb2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        while (i >= 0 || j >= 0 || rem != 0) {
            int val = rem;
            val += (i >= 0 ? Character.getNumericValue(sb1.charAt(i)) : 0);
            val += (j >= 0 ? Character.getNumericValue(sb2.charAt(j)) : 0);
            rem = val / 10;
            sb.insert(0, val % 10);
            i--;
            j--;
        }
        for (int k = 0; k < sb.length(); k++)
            if (sb.charAt(k) != '0')
                return sb.substring(k);
        return "";
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 0, 9, 4, 8, 8, 2, 4, 5, 5, 1};
        System.out.println(24578 + 144589);
        System.out.println(new Heap_353_Minimum_Sum_of_two_numbers_from_digits_of_an_array().solve(arr));
    }
}
