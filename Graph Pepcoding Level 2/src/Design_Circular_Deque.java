// https://leetcode.com/problems/design-circular-deque/submissions/
public class Design_Circular_Deque {
    class MyCircularDeque {

        class Node{
            int data;
            Node next,pre;
            Node(int data)
            {
                this.data = data;
            }
            public void delete()
            {
                pre.next = next;
                next.pre = pre;
            }
        }
        Node front;
        Node rear;
        int size = 0;
        int maxSize;
        public MyCircularDeque(int k) {
            front = new Node(-1);
            rear = new Node(-1);
            size = 0;
            front.next = rear;
            rear.pre = front;
            maxSize = k;
        }

        public boolean insertFront(int value) {
            if(size == maxSize)
                return false;
            Node n = new Node(value);
            n.pre = front;
            n.next = front.next;
            front.next = n;
            n.next.pre = n;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if(size == maxSize)
                return false;
            Node n = new Node(value);
            n.next = rear;
            n.pre = rear.pre;
            n.pre.next = n;
            rear.pre = n;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if(size == 0)
                return false;
            Node n = front.next;
            n.delete();
            size--;
            return true;
        }

        public boolean deleteLast() {
            if(size == 0)
                return false;
            Node n = rear.pre;
            n.delete();
            size--;
            return true;
        }

        public int getFront() {
            if(size == 0)
                return -1;
            return front.next.data;
        }

        public int getRear() {
            if(size == 0)
                return -1;
            return rear.pre.data;
        }

        public boolean isEmpty() {
            return size ==0;
        }

        public boolean isFull() {
            if(size == maxSize)
                return true;
            return false;
        }
    }
}
