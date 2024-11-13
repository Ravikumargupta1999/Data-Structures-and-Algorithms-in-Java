import java.util.Stack;
// https://practice.geeksforgeeks.org/problems/unsorted-array4925/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&page=7&query=category[]Arrayscompany[]Amazonpage7company[]Amazoncategory[]Arrays#

public class Smaller_Greater {
    public static int findElement(int arr[], int n){
        boolean[] right = new boolean[n];
        boolean[] left = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n-1]);
        for(int i = n-2;i>=0;i--)
        {
            if(arr[i] <= stack.peek())
            {
                right[i] = true;
                stack.add(arr[i]);
            }
        }
        for(int i=0;i<n;i++)
            System.out.print(right[i]+"  ");
        System.out.println();

        Stack<Integer> sta = new Stack<>();
        sta.add(arr[0]);
        for(int i = 1 ;i<n;i++)
        {
            if(arr[i] >= sta.peek())
            {
                left[i] = true;
                sta.add(arr[i]);
            }
        }
        for(int i=0;i<n;i++)
            System.out.print(left[i]+"  ");
        System.out.println();
        for(int i=0;i<n;i++)
        {
            if(left[i] == true && right[i] == true)
                return arr[i];
        }
        return -1;

    }

    public static void main(String[] args) {
//        int arr[] = {4,2,5,7};
        int[] arr = {10, 6, 3, 1, 5, 16, 6, 1 ,11, 12};
        System.out.println(findElement(arr, arr.length));

    }
}
