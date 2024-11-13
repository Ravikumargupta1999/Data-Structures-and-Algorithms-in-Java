// https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1
// All_repeating_except_two
//
public class Bit_Manipulation_473 {
    static public int[] twoOddNum(int arr[], int n)
    {
        int xxroy = 0;
        for(int val : arr)
            xxroy = xxroy ^ val;

        int rsbm = xxroy & -xxroy;
        int x = 0;
        int y = 0;

        for(int val : arr)
            if((val & rsbm) == 0)
                x = x ^ val;
            else
                y = y ^ val;
        int[] arr1 = new int[2];

        arr1[0] = x;
        arr1[1] = y;
        if(x < y)
        {
            arr1[0] = y;
            arr1[1] = x;
        }
        else
        {
            arr1[0] = x;
            arr1[1] = y;
        }
        return arr1;
    }
    public static void main(String[] args) {
        int N = 8;
        int[] arr = {4, 2, 4, 5, 2, 3, 3, 1};
        arr = twoOddNum(arr,N);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
        System.out.println("");

    }
}
