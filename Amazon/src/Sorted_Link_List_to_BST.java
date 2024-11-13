public class Sorted_Link_List_to_BST {
//https://practice.geeksforgeeks.org/problems/sorted-list-to-bst/1/?company[]=Amazon&company[]=Amazon&difficulty[]=2&page=2&query=company[]Amazondifficulty[]2page2company[]Amazon

    static class LNode
    {
        int data;
        LNode next;
        LNode(int d) {
            data = d;
            next = null;
        }
    }

    //Tree Node
    static class TNode
    {
        int data;
        TNode left, right;
        TNode(int x)
        {
            data=x;
            left=right=null;
        }

    }
    static TNode temp_root = null;
    public static TNode sortedListToBST(LNode head)
    {
        if( head == null)
            return null;
        if( head.next == null)
            return new TNode(head.data);
        int[] arr = new int[totalLNode(head)];
        int n = totalLNode(head);

        int val = 0;

        LNode temp = head;
        while (val < n)
        {
            arr[val++] =  temp.data;
            temp = temp.next;

        }

        temp_root = Array_To_B_BST(arr,0,n-1);
        return temp_root;
    }
    public static TNode Array_To_B_BST(int[] al,int start,int end)
    {
        if(start>end)
            return null;
        else if(end >= al.length || start < 0)
            return null;

        int mid = 0;
        if (start == end)
            mid = start;
        else if(end - start == 1)
            mid = end;
        else if((start + end) % 2 != 0)
        {
            mid = (start + end)/2;
            mid = mid + 1;
        }
        else
        {
            mid = (start + end)/2;
        }
        System.out.println(start+"   "+end+"  "+mid);
        TNode node = new TNode(al[mid]);
        node.left = Array_To_B_BST(al, start, mid - 1);
        node.right = Array_To_B_BST(al, mid + 1, end);

        return node;
    }
    static int totalLNode(LNode node)
    {
        int count =0;
        LNode temp = node;
        while ( temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static void printBST(TNode root)
    {
        if(root == null)
            return;
        System.out.print(root.data+"  ");
        printBST(root.left);
        printBST(root.right);
    }

    public static void main(String[] args) {
        LNode node = new LNode(1);
        node.next = new LNode(2);
//        node.next.next = new LNode(3);
//        node.next.next.next = new LNode(4);
//        node.next.next.next.next = new LNode(5);
        TNode root = sortedListToBST(node);
        printBST(root);
        System.out.println("");
    }

}
