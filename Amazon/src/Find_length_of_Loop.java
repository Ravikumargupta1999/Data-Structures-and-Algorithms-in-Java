public class Find_length_of_Loop {
    static class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    static int countNodesinLoop(Node head)
    {
        if(head == null || head.next == null )
            return 0;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow== fast)
                return nodesTotal(slow);
        }

        return 0;

    }
    static int nodesTotal(Node n)
    {
        int res = 1;
        Node temp = n;
        while (temp.next != n)
        {
            res++;
            temp = temp.next;
        }
        return res;
    }
}
