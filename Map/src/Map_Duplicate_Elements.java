import java.net.Inet4Address;
import java.util.*;
// https://practice.geeksforgeeks.org/problems/duplicate-elements/1/?category[]=Map&category[]=Map&page=1&query=category[]Mappage1category[]Map#
public class Map_Duplicate_Elements {
    public static void SortedDuplicates(int arr[], int n) {
        int count =0;
        ArrayList<Integer> al = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        for(int i=0;i<arr.length;i++)
        {
            if(set.contains(arr[i]))
                continue;
            else
            {
                if(map.get(arr[i])>1)
                {
                    al.add(arr[i]);
                    set.add(arr[i]);
                    count++;
                }
            }
        }
        if(count == 0)
            System.out.println(-1);
        else
        {
            Collections.sort(al);
            for(int x : al)
                System.out.print(x+" ");
            System.out.println("");
        }

    }

    public static void main(String[] args) {

    }
}
