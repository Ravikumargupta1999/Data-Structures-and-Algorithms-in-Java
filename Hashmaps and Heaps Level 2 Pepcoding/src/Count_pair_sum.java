import java.util.HashSet;
// https://practice.geeksforgeeks.org/problems/count-pair-sum5956/1
public class Count_pair_sum {
    static int countPairs(int arr1[],int arr2[], int M, int N, int x)
    {
        HashSet<Integer> set = new HashSet<>();
        for(int val : arr2)
            set.add(val);
        int count = 0;
        for(int val : arr1)
            if(set.contains(x - val))
                count++;
        return count;
    }

    public static void main(String[] args) {

    }
}
