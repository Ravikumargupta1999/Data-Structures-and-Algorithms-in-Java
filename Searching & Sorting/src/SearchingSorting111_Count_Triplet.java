// https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
// https://www.youtube.com/watch?v=YnEHFYwQwyU
// easy
public class SearchingSorting111_Count_Triplet {
    public static int triplet(int[] arr)
    {
        int count =0;

        int i ,j,k;
        for(k = arr.length-1;k>=2;k--)
        {
            i = 0;
            j = k-1;
            while (i<j)
            {
                if(arr[i]+arr[j] == arr[k])
                {
                    count++;
                    i++;
                    j--;
                }
                else if(arr[i]+arr[j] < arr[k])
                {
                    i++;
                }
                else
                {
                    j--;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
