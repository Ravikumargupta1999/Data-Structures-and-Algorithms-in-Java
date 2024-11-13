// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

import java.util.Arrays;

public class Find_position_of_an_element_in_a_sorted_array_of_infinite_numbers {
    public static int findElement(int[] arr, int target) {
//        for (int i = 1; i < arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println("");
        int start = 0;
        int end = 1;
        while (target > arr[end]) {
//            int temp = end + 1;
//            end = end + (end-start+1)*2;
//            start = temp;
            start = end +1;
            end = 2*end;
            System.out.println(start+"  "+end);
        }

//        System.out.println("hello");
        return search(arr, target, start, end);
    }

    public static int search(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target)
                end = mid - 1;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                return mid;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[(int) Math.pow(10, 6)];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (2 * i + 1);
        }
        Arrays.sort(arr);
        int target = 19999;
        System.out.println("");
        System.out.println("");
        System.out.println(findElement(arr, target));
    }
}
