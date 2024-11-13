public class L_Linked_List_160_Count_Triplets_In_a_sorted_doubly_linked {
    // https://www.codingninjas.com/codestudio/problems/count-triplets-in-a-sorted-doubly-linked-list-whose-sum-is-equal-to-a-given-value-x_985286?leftPanelTab=0

    class DLLNode {
        int data;
        DLLNode next;
        DLLNode prev;
    }
    // this is also write
    // https://www.prodevelopertutorial.com/linked-list-count-triplets-in-a-sorted-dll-whose-sum-is-equal-to-given-value-k/

    public static int countTriplets(DLLNode head, int target) {
        if (head == null || head.next == null || head.next.next == null)
            return 0;
        int count = 0;

        DLLNode third = head;
        while (third.next != null)
            third = third.next;

        DLLNode first = head;

        while (first != null) {

            DLLNode second = first.next;
            DLLNode last = third;
            int x = target - first.data;

            while (second != null && third != null && second.data < third.data) {


                if (second.data + third.data == x) {
                    count++;
                    second = second.next;
                    third = third.prev;
                } else if (second.data + third.data > x)
                    third = third.prev;
                else
                    second = second.next;

            }


            first = first.next;
            third = last;
        }

        return count;
    }
}
//        1 2  9   14
//        0
//        1 3  9   14
//        0
//        1 4  9   14
//        0
//        1 5  9   14
//        1
//        1 6  8   14
//        2


//        2 3  9   12
//        3
//        2 4  8   12
//        4
//        2 5  7   12
//        5


//        3 4  9   9
//        5
//        3 4  8   9
//        5
//        3 4  7   9
//        5
//        3 4  6   9
//        5
//        3 4  5   9
//        6
//        4 5  9   5
//        6
//        4 5  8   5
//        6
//        4 5  7   5
//        6
//        4 5  6   5
//        6
//        5 6  9   0
//        6
//        5 6  8   0
//        6
//        5 6  7   0
//        6
//        6 7  9   -6
//        6
//        6 7  8   -6
//        6
//        7 8  9   -13
//        6
//        6