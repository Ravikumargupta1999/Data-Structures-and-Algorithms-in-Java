// https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1/?company[]=Goldman%20Sachs&company[]=Goldman%20Sachs&page=3&query=company[]Goldman%20Sachspage3company[]Goldman%20Sachs#

public class Sum_Divisibility_Problem {
    public static boolean canPair(int[] arr, int k) {
        if(arr.length % 2 != 0)
            return false;
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if ((arr[i] + arr[j]) % k == 0)
                {
                    System.out.println(arr[i] + " " + arr[j] + "  " + k);
                    count++;
                }
            }
        }
        System.out.println(count);
        if(count != (arr.length/2))
            return false;
        return true;
    }
    public static void main(String[] args) {
        int n = 8, k = 5;
        int[] arr = {12, 11, 12, 4, 2, 3, 10, 9};
        System.out.println(canPair(arr,k));

    }
}
