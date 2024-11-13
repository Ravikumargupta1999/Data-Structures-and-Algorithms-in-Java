public class Cycle_Detection {
    // Complete the hasCycle function below.



      static class  SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
      }


    static boolean hasCycle(SinglyLinkedListNode head) {
        if(head == null || head.next == null )
            return false;
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow== fast)
                return true;
        }

        return false;

    }
}
