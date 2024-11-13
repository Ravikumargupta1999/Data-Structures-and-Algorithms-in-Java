import java.util.List;

public class Array_Manipulation {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[]  arr = new long[n];
        for(int i=0;i<queries.size();i++)
        {
            int a = queries.get(i).get(0);
            int b = queries.get(i).get(1);
            int c = queries.get(i).get(2);
            for(int j=a-1;j<=b-1;j++)
                arr[j] += c;
        }
        long max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            if(arr[i] > max)
                max = arr[i];
        return max;

    }
}
//5 3
//       1 2 100
//        2 5 100
//        3 4 100