import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
//https://practice.geeksforgeeks.org/problems/count-pairs-whose-sum-is-equal-to-x/1/?company[]=Amazon&company[]=Amazon&page=2&query=company[]Amazonpage2company[]Amazon#

public class Count_Pairs {
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

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<head2.size();i++)
        {
            set.add(head2.get(i));
        }
        int pairs = 0;
        for(int i=0;i<head1.size();i++)
        {
            if(set.contains(x- head1.get(i)))
                pairs++;
        }
        return pairs;
    }
    public static void main(String[] args) {

    }
}
