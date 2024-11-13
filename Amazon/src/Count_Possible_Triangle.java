import java.util.Arrays;

public class Count_Possible_Triangle {
    static int findNumberOfTriangles(int arr[], int n)
    {
        if(n < 3)
            return 0;
        Arrays.sort(arr);
        int count =0;
        for(int largest = n-1;largest>=2;largest--)
        {
            int left = 0;
            int right = largest-1;
            while (left < right)
            {
                if (arr[left] + arr[right] > arr[largest])
                {
                    count += (right - left);
                    right--;
                }
                else left++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,9};
        System.out.println(findNumberOfTriangles(arr,arr.length));
    }
}
