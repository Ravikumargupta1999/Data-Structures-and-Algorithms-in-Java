import java.util.ArrayList;
import java.util.Arrays;

public class L_Linked_List_160_Count_Triplets {
    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/87f12e5c728d69a5322634776b54c75897d14daa/1
    static int countTriplets(Node head, int x) {
        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.data);
            head = head.next;
        }

        int[] arr = new int[list.size()];
        int i = 0;
        for (int num : list)
            arr[i++] = num;
        return countTriplet(arr, x);
    }

    static int countTriplet(int[] arr, int x) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {

            int target = x - arr[i];

            int start = i + 1;
            int end = arr.length-1;
            while (start < end){
                if(arr[start] + arr[end] == target){
                    count++;
                    start++;
                    end--;
                }else if(arr[start] + arr[end] > target)
                    end--;
                else
                    start++;
            }
        }
        return count;
    }
}
