import java.net.Inet4Address;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
// https://practice.geeksforgeeks.org/problems/sum-of-fai-aj-over-all-pairs-in-an-array-of-n-integers4057/1/?category[]=Map&category[]=Map&page=1&query=category[]Mappage1category[]Map
public class Map_Sum_Of_Pairs {
    public static int sum(int arr[], int n) {
        int result = 0;
        if (n == 0 || n == 1)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i]))
                continue;
            set.add(arr[i]);

            Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();

            while (itr.hasNext()) {
                Map.Entry<Integer, Integer> entry = itr.next();

                if(entry.getKey() == arr[i]) {
                    int size = entry.getValue();
                    while (size-- > 1) {
                        if(arr[i]>entry.getKey())
                        {
                            result += (entry.getKey()-arr[i]);
                        }
                        else
                        {
                            result += (arr[i] - entry.getKey());
                        }

                        System.out.println("i : " + i + "  Key = " + entry.getKey() + ", size = " + entry.getValue() + " sum = " + result);
                    }
                } else {
                    int size = entry.getValue();
                    while (size-- > 0) {
                        if(arr[i]>entry.getKey())
                        {
                            result += (entry.getKey()-arr[i]);
                        }
                        else
                        {
                            result += (arr[i] - entry.getKey());
                        }
                        System.out.println("i : " + i + "  Key = " + entry.getKey() + ", size = " + entry.getValue() + " sum = " + result);
                    }

                }
            }


        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2,3,1,3};
        System.out.println(sum(arr, arr.length));


    }
}
