import java.util.ArrayList;
import java.util.Arrays;

public class Video_28_Counting_elements_in_two_arrays {
    public static ArrayList<Integer> countEleLessThanOrEqual(int[] arr1, int[] arr2, int m, int n) {
        Arrays.sort(arr2);
//        System.out.println(Arrays.toString(arr2));
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < m; i++) {
//            System.out.println(arr1[i]);
            int low = 0;
            int high = n - 1;
            while (low <= high) {

                int mid = (low + high) / 2;

                if (arr2[mid] <= arr1[i]) {
                    low = mid + 1;
                }

                else {
//                    System.out.println(arr2[mid]+"   "+mid);
                    high = mid - 1;
                }
            }
            al.add(high + 1);
//            System.out.println("\n");
        }
        return al;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,7,9};
        int[] arr2 = {0,1,2,1,1,4};
        System.out.println(countEleLessThanOrEqual(arr1,arr2,arr1.length,arr2.length));
    }
}
