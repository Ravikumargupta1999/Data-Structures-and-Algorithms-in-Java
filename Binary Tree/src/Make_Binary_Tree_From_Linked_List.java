import java.util.HashMap;
import java.util.HashSet;
// https://practice.geeksforgeeks.org/problems/make-binary-tree/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Tree&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Tree#
public class Make_Binary_Tree_From_Linked_List {
    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
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
    //Function to make binary tree from linked list.
    public static Tree convert(Node head, Tree node) {
        if (head == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        Node temp = head;
        int i = 0;
        while (temp != null) {
            map.put(i, temp.data);
            i++;
            temp = temp.next;
        }
        Tree tree = makeTree(0,map);
        return tree;
    }
    public static Tree makeTree(int index,HashMap<Integer,Integer> map)
    {
        if(!map.containsKey(index))
            return null;
        Tree newNode = new Tree(map.get(index));
        if(newNode != null) {
            newNode.left = makeTree( 2 * index + 1, map);
            newNode.right = makeTree( 2 * index + 2, map);
        }
        return newNode;
    }

}
