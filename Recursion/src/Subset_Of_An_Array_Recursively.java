import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Array;
import java.util.*;
// https://www.youtube.com/watch?v=u0e29JIdxZU&t=48s
// https://leetcode.com/problems/subsets/
public class Subset_Of_An_Array_Recursively {

    void generatesSubset(int ind,int[] arr,List<Integer> al,List<List<Integer>> al1)
    {
       al1.add(new ArrayList<>(al));
       for(int i=ind;i<arr.length;i++) {
           if(i != ind && arr[i] == arr[i-1])
               continue;
          // generatesSubset(i + 1, arr, al, al1);
           al.add(arr[i]);
           generatesSubset(i + 1, arr, al, al1);
           al.remove(al.size() - 1);
       }

    }
    List<List<Integer>> subsets(int[] arr)
    {
        Arrays.sort(arr);
        List<List<Integer>> al1 = new ArrayList<>();
        generatesSubset(0,arr,new ArrayList<>(),al1);
       /* Collections.sort(al1, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size()-o2.size();
            }
        }); */
        return al1;
    }
    public static void main(String[] args) {
        Subset_Of_An_Array_Recursively a = new Subset_Of_An_Array_Recursively();
        int[] arr = {1,2,5};
        List<List<Integer>> al1=  a.subsets(arr);
        System.out.println(al1);


    }
}
