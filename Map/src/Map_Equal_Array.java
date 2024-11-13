import java.util.HashMap;
// https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1/?category[]=Sorting&category[]=Sorting&page=1&query=category[]Sortingpage1category[]Sorting#
public class Map_Equal_Array {
    public static boolean check(long arr1[],long arr2[],int n)
    {
        if(n == 0)
            return true;
        HashMap<Long,Integer> map1 = new HashMap<>();
        HashMap<Long,Integer> map2 = new HashMap<>();
        for(int i=0;i<n;i++)
            map1.put(arr1[(int)i],map1.getOrDefault(arr1[(int)i],0)+1);
        for(int i=0;i<n;i++)
            map2.put(arr2[(int)i],map2.getOrDefault(arr2[(int)i],0)+1);
        for(int i=0;i<n;i++)
        {
            if(map1.get(arr1[i]) == map2.get(arr1[i]))
                continue;
            else
                return false;
        }
        return true;
    }
}
