import java.util.ArrayList;

public class Subarray_with_given_sum {
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum)
    {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int temp = arr[i];
            if( arr[i] == sum) {
                al.add(i+1);
                al.add(i+1);
                return al;
            }
            for(int j = i+1;j<n;j++)
            {
                temp += arr[j];
                if(temp == sum)
                {
                    al.add(i+1);
                    al.add(j+1);
                    return al;
                }
            }
        }
        al.add(-1);
        return al;
    }

    public static void main(String[] args) {
        int n = 5, sum = 12, arr[] = {1,2,3,7,5};
        System.out.println(subarraySum(arr,n,sum));
    }
}
