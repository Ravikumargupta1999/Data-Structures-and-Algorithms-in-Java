public class Doubly_linked_list_Insertion_at_given_position {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }
    static Node head = null;
    static Node tail = null;
    static int size = 0;
    static void addFirst(int data) {

        if(head == null)
        {
            Node temp = new Node(data);
            head = tail = temp;
        }
        else
        {
            Node temp = new Node(data);
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
        size++;

    }
    public static void addLast(int data)
    {
        if(head == null)
        {
            Node temp = new Node(data);
            head = tail = temp;
        }
        else
        {
            Node temp = new Node(data);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }
    public static void addAt(int index,int data)
    {
        if( index == 0)
        {
            addFirst(data);
            return;
        }
        else if( index == size+1)
        {
            addLast(data);
            return;
        }
        int i=0;
        Node temp = head;
        for(i =0;i<index-1;i++)
        {
            temp = temp.next;
        }
        Node next = temp.next;
        Node newNode= new Node(data);
        next.prev = newNode;
        newNode.next = next;
        temp.next = newNode;
        size++;

    }
    public static int getFirst()
    {
        if(head == null)
            return -1;
        return head.data;
    }
    public static int getLast()
    {
        if(tail == null)
            return -1;
        return tail.data;
    }
    public static int getAt(int index)
    {
        if(head == null)
            return -1;
        if(index > size)
            return -1;
        int i = 0;
        Node temp = head;
        while (temp != null)
        {
            if(i == index)
                return temp.data;
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public static void removeFirst()
    {

        if(head == null)
        {
            System.out.println("List is Empty");
            return;
        }
        else if(size == 1)
        {
            head = tail =null;
            size--;
        }
        else {
            Node forw = head.next;
            forw.prev = null;
            head = forw;
            size--;
        }
    }
    public static void removeLast()
    {

        if(head == null)
        {
            System.out.println("List is Empty");
            return;
        }
        else if(size == 1)
        {
            head = tail =null;
            size--;
        }
        else {
            Node back = tail.prev;
            tail.prev.next = null;
            tail = back;
            size--;
        }
    }
    public static void removeAt(int index)
    {
        if(index >= size)
        {
            System.out.println("Maximum Possible Index is : "+(size-1));
            return;
        }
        System.out.println(index+"  "+size);
        if( index == 0)
            removeFirst();
        else if( index == size-1)
            removeLast();
        else
        {
            int i=0;
            Node temp = head;
            for(i =0;i<index-1;i++)
                temp = temp.next;
            System.out.println(temp.data);
            Node next = temp.next.next;
            if(temp.next.next !=null)
            {
                temp.next.next.prev = temp;
            }
            temp.next = temp.next.next;
        }
    }
    static void forwardTraversal() {
        if(head == null)
        {
            System.out.println("List is Empty \n");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
        System.out.print("\n");

    }
    static void backwardTraversal() {
        if(tail == null)
        {
            System.out.println("List is Empty \n");
            return;
        }
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.prev;
        }
        System.out.print("\n");

    }

    public static void main(String[] args) {
        forwardTraversal();
        backwardTraversal();
        addFirst(89);
        addFirst(17);
        addFirst(32);
        addFirst(65);
        forwardTraversal();
        backwardTraversal();
        System.out.println("\n\n");

        System.out.println(getAt(0));

        addLast(100);
        forwardTraversal();
        addAt(4,56);
        forwardTraversal();
        removeAt(6);
        forwardTraversal();
    }
}
