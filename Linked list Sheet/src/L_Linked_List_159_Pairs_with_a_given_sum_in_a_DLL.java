import java.util.ArrayList;

public class L_Linked_List_159_Pairs_with_a_given_sum_in_a_DLL {

    static class Node {
        int data;
        Node next, prev;
    }

    // https://practice.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1

    // https://www.codingninjas.com/codestudio/problems/find-pair-with-a-given-sum-in-a-doubly-linked-list_1164172?leftPanelTab=1
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Node last = head;

        while (last.next != null)
            last = last.next;

        Node first = head;

        while (first != null && last != null && first != last && first.data <= last.data) {

            if (first.data + last.data == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(first.data);
                temp.add(last.data);
                result.add(temp);
                first = first.next;
                last = last.prev;
            } else if (first.data + last.data > target)
                last = last.prev;
            else
                first = first.next;
        }
        return result;
    }

    //

}
