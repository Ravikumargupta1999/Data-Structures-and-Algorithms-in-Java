import java.util.*;
// https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621/1/?category[]=Sorting&category[]=Sorting&page=2&query=category[]Sortingpage2category[]Sorting
public class Map_Sort_By_Frequency {

    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(arr[i]);

        HashMap<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
        {
            if (mapCount.containsKey(arr[i]))
            {
                mapCount.put(arr[i],mapCount.get(arr[i]) + 1);
            }
            else
            {
                mapCount.put(arr[i],1);
                mapIndex.put(arr[i],i);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2)
            {
                int freq1 = mapCount.get(n1);
                int freq2 = mapCount.get(n2);
                if (freq1 != freq2)
                {
                    return freq2 - freq1;
                }
                else
                {
                    return mapIndex.get(n1) - mapIndex.get(n2);
                }
            }
        });
        return list;
    }
}
