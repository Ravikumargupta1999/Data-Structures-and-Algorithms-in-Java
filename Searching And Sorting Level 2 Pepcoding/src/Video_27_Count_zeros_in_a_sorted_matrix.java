public class Video_27_Count_zeros_in_a_sorted_matrix {
    /*you are required to complete this method*/
    // https://practice.geeksforgeeks.org/problems/count-zeros-in-a-sorted-matrix/1
    static int countZeros(int arr[][], int n)
    {
        int i=0;
        int j= n-1;
        int count =0;
        while (i < n && j>=0)
        {
            if(arr[i][j] == 1)
            {
                j--;
            }
            else
            {
                count += (j+1);
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1},
                {0, 1, 1},
                {1, 1, 1}};
        System.out.println(countZeros(arr,arr.length));
    }
}
