import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//https://practice.geeksforgeeks.org/problems/sum-of-distinct-elements4801/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-1&page=4&query=category[]Arraysdifficulty[]-1page4category[]Arrays
public class Sum_Of_Distinct_Elements {
    int findSum(int arr[], int n) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
            set.add(arr[i]);
        int sum =0;
        Iterator<Integer> i = set.iterator();
        while (i.hasNext())
            sum = sum + i.next();
        return sum;

    }
    public static void main(String[] args) {

    }
}
