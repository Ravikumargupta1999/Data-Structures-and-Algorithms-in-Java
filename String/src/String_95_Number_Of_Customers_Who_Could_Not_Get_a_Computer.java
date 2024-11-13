import java.util.ArrayList;

public class String_95_Number_Of_Customers_Who_Could_Not_Get_a_Computer {
    public static void main(String[] args) {
        int n = 1;
        String str = "ABCBCA";
        System.out.println(runCustomerSimulation(n, str));
    }

    public static int runCustomerSimulation(int n, String str) {
        int[] arr = new int[256];
        int count = 0;
        int busy = 0;
        for (char ch : str.toCharArray()) {

            if (arr[ch] == 2) {
                busy--;
                arr[ch] = 0;
            } else if (arr[ch] == 1) {
                arr[ch] = 0;
            } else {
                if (busy < n) {
                    arr[ch] = 2;
                    busy++;
                } else {
                    arr[ch] = 1;
                    count++;
                }
            }
        }
        return count;
    }

    public static int countCustomers(ArrayList<Integer> arr, int k) {
        int max = 0;
        for (int num : arr)
            max = Math.max(max, num);
        boolean[] used = new boolean[max + 1];
        int[] array = new int[max + 1];
        int busy = 0;
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            int curr = arr.get(i);
            if (used[curr]) {
                if (array[curr] == 1)
                    busy--;
            } else {
                used[curr] = true;
                if (busy < k) {
                    array[curr] = 1;
                    busy++;
                } else {
                    count++;
                }
            }
        }
        return count;
    }
}
