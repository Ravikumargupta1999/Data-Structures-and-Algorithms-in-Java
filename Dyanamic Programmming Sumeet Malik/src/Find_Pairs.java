import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&page=7&query=category[]Arrayscompany[]Amazonpage7company[]Amazoncategory[]Arrays#

public class Find_Pairs {
    class pair {
        long first, second;

        public pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public pair[] allPairs1(long arr1[], long arr2[], long n, long m, long x) {
        HashMap<Long, Integer> s = new HashMap<Long, Integer>();

        for (long i = 0; i < n; i++)
            s.put(arr1[(int)i], 0);
        ArrayList<pair> al = new ArrayList<>();
        for (int j = 0; j < m; j++)
            if (s.containsKey(x - arr2[j]))
                al.add(new pair(x - arr2[j], + arr2[j]));
        pair[] arr = new pair[al.size()];
        for (int l = 0; l < al.size(); l++)
            arr[l] = al.get(l);
        Arrays.sort(arr, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                if(o1.first < o2.first)
                    return 1;
                else
                    return -1;
            }
        });
        return arr;

    }

    public pair[] allPairs(long a[], long b[], long n, long m, long x) {

        HashSet<Long> set = new HashSet<>();
        for (long l = 0; l < m; l++) {
            set.add(b[(int) l]);
        }
        ArrayList<pair> al = new ArrayList<>();
        for (long l = 0; l < n; l++) {
            if (set.contains(x - a[(int) l])) {
                pair p = new pair(a[(int) l], x - a[(int) l]);
                al.add(p);
            }
        }
        pair[] arr = new pair[al.size()];
        for (int l = 0; l < al.size(); l++)
            arr[l] = al.get(l);
        return arr;

    }

    public static void main(String[] args) {

    }
}
