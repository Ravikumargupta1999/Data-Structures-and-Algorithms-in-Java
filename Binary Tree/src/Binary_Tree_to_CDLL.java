import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Tree&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Tree#
public class Binary_Tree_to_CDLL {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    {
        if(root == null)
            return null;
        ArrayList<Integer> al= new ArrayList<>();
        Inorder(root,al);
        Node start = new Node(al.get(0));
        Node temp = start;
        for(int i=1;i<al.size();i++)
        {
            Node newNode = new Node(al.get(i));
            temp.right = newNode;
            newNode.left = temp;
            temp = newNode;
        }
        temp.right = start;
        start.left = temp;
        return start;
    }
    void Inorder(Node root,ArrayList<Integer> arrayList)
    {
        if(root == null)
            return;
        Inorder(root.left,arrayList);
        arrayList.add(root.data);
        Inorder(root.right,arrayList);
    }
}
