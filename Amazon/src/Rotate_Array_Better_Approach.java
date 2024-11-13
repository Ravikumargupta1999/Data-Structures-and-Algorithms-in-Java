
// https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=2&query=company[]Amazondifficulty[]0page2company[]Amazon#
// https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements/0
public class Rotate_Array_Better_Approach {
    static void rotateArr(int arr[], int d, int n)
    {
        d = d % n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
    public static void reverse(int[] arr,int low,int high)
    {
        while (low <= high)
        {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotateArr(arr,4,5);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"  ");
        System.out.println("");
    }
}
