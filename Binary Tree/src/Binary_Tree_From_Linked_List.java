import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/make-binary-tree/1/?category[]=Queue&category[]=Queue&page=1&query=category[]Queuepage1category[]Queue

public class Binary_Tree_From_Linked_List {
    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int d){
            data=d;
            left=null;
            right=null;
        }
    }

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static Tree convert(Node head, Tree node) {
        Node temp =  head;
        if(head == null)
            return null;
        ArrayList<Node> arrayList = new ArrayList<>();
        while (temp.next != null)
        {
            arrayList.add(temp);
        }
        return node;
    }

}
