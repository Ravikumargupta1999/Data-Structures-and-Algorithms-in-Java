

//https://practice.geeksforgeeks.org/problems/occurence-of-an-integer-in-a-linked-list/1/?category[]=Linked%20List&category[]=Linked%20List&page=1&query=category[]Linked%20Listpage1category[]Linked%20List

public class L_Linked_List_177_Occurance_of_an_integer {
    static class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    public static int count(Node head, int search_for)
    {
        Node temp = head;
        if(temp == null)
            return 0;
        int count =0;
        while (temp.next != null)
        {
            if(temp.data == search_for)
                count++;
            temp = temp.next;
        }
        if(temp.data == search_for)
            count++;
        return count;
    }


}
