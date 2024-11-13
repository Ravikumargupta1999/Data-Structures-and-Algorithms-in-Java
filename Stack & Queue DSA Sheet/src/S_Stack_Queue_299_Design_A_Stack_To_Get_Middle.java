public class S_Stack_Queue_299_Design_A_Stack_To_Get_Middle {
    // https://www.youtube.com/watch?v=GWericrOYw0
    static class DLLNode {
        DLLNode prev;
        int data;
        DLLNode next;

        DLLNode(int d) {
            data = d;
        }
    }

    static class MyStack {
        DLLNode head;
        DLLNode mid;
        int count;

        public MyStack() {
            this.count = 0;
        }
    }

    static MyStack ms;

    static void push(int new_data) {
        DLLNode node = new DLLNode(new_data);
        node.prev = null;
        node.next = null;
        ms.count += 1;
        if (ms.count == 1) {
            ms.head = ms.mid = node;
        } else {
            ms.head.prev = node;
            node.next = ms.head;
            ms.head = node;
            if (ms.count % 2 == 0) {
                ms.mid = ms.mid.prev;
            }
        }
    }

    static int pop() {
        int item = -1;
        if (ms.count == 0) {
            System.out.println("Stack is empty");
            return -1;
        } else if (ms.count == 1) {
            item = ms.head.data;
            ms.count--;
            ms.head = ms.mid = null;
        } else {
            DLLNode head = ms.head;
            item = head.data;
            ms.head = head.next;
            ms.head.prev = null;
            ms.count -= 1;
            if (ms.count % 2 != 0)
                ms.mid = ms.mid.next;
        }

        return item;
    }

    static int findMiddle() {
        if (ms.count == 0) {
            System.out.println("Stack is empty now");
            return -1;
        }
        return ms.mid.data;
    }

    static int deleteMiddle() {
        if (ms.count == 0) {
            return -1;
        } else if (ms.count == 1) {
            ms.head = ms.mid = null;
            return -1;
        }

        DLLNode midNode = ms.mid;
        int item = midNode.data;
        ms.count--;

        if (ms.count == 1) {
            ms.head = ms.head.next;
            ms.mid = ms.head;
        } else {
            ms.mid.prev.next = midNode.next;
            ms.mid.next.prev = midNode.prev;

            if( ms.count % 2 != 0)
                ms.mid = ms.mid.next;
            else
                ms.mid = ms.mid.prev;
        }
        return item;
    }

    static void traverseStack() {
        System.out.print("Stack : ");
        if (ms.count == 0) {
            System.out.print("Empty");
        } else {
            DLLNode temp = ms.head;
            while (temp != null) {
                System.out.print(temp.data + "\t");
                temp = temp.next;
            }
        }
        System.out.println();
        if (ms.count == 0) {
            System.out.println("Middle Element : " + (-1));
        } else {
            System.out.println("Middle Element is :  " + findMiddle());
        }
        System.out.println("Total Element in stack :  " + ms.count + "\n");

    }

    public static void main(String args[]) {

        ms = new MyStack();
        traverseStack();


        push(1);
        traverseStack();

        push(2);
        traverseStack();

        deleteMiddle();
        traverseStack();

        push(2);
        traverseStack();

        push(3);
        traverseStack();


        deleteMiddle();
        traverseStack();

        deleteMiddle();
        traverseStack();

        push(2);
        push(3);
        push(4);
        push(5);
        push(6);
        push(7);
        traverseStack();

        deleteMiddle();
        traverseStack();

        deleteMiddle();
        traverseStack();

    }
}
