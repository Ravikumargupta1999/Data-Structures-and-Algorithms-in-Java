//https://leetcode.com/problems/max-consecutive-ones-iii/submissions/
// https://practice.geeksforgeeks.org/problems/maximize-number-of-1s0905/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=2&query=category[]Arrayscompany[]Amazondifficulty[]1page2company[]Amazoncategory[]Arrays
public class Maximize_Number_of_1s {
    static int findZeroes(int arr[], int n, int m) {
         int ans = 0;
//         int len = 0;
         int count = 0;
         int j = -1;
         for (int i=0;i<n;i++)
         {
             if(arr[i] == 0)
                 count++;
             while (count > m)
             {
                 j++;
                 if(arr[j] == 0)
                     count--;
             }
             int len = i-j;
             if(ans < len)
                 ans = len;

         }
         return ans;
    }

    public static void main(String[] args) {
        System.out.print(findZeroes(new int[]{1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1},11,2));
    }
}
