import java.util.ArrayList;
import java.util.HashSet;
//https://practice.geeksforgeeks.org/problems/in-first-but-second5423/1/?category[]=Hash&category[]=Hash&difficulty[]=1&page=1&query=category[]Hashdifficulty[]1page1category[]Hash

public class Find_missing_in_second_array {
    ArrayList<Long> findMissing(long a[], long b[], int n, int m)
    {
        HashSet<Long> set = new HashSet<>();
        for(int i=0;i<m;i++)
            set.add(b[i]);
        ArrayList<Long> al = new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            if(!set.contains(a[i]))
                al.add(a[i]);
        }
        return al;
    }
}
