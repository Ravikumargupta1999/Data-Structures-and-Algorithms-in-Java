import java.util.PriorityQueue;

public class L_Linked_List_161_Sort_K_Sorted_Doubly_linked_list {
    // https://www.codingninjas.com/codestudio/problems/sort-a-k-sorted-doubly-linked-list_1118118?leftPanelTab=1

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    public static Node<Integer> sortedDll(Node<Integer> head, int k) {
        if (head == null || head.next.next == null) return head;
        PriorityQueue<Node<Integer>> queue = new PriorityQueue<>((a, b) -> {
            return a.data - b.data;
        });

        Node<Integer> list = new Node<>(-1);

        Node<Integer> temp = list;

        Node<Integer> last = null;

        Node<Integer> node = head;

        for (int i = 0; i < k; i++) {
            queue.add(node);
            node = node.next;
        }

        while (!queue.isEmpty()) {

            if (node != null) {
                queue.add(node);
                node = node.next;
            }
            Node<Integer> rem = queue.poll();
            last = rem;
            Node<Integer> next = rem;
            temp.next = rem;
            rem.prev = temp;
            temp = rem;
        }
        last.next = null;

        Node<Integer> ans = list.next;
        list.next.prev = null;
        return ans;
    }

}
