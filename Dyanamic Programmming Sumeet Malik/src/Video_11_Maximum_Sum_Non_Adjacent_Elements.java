// https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
// https://www.youtube.com/watch?v=VT4bZV24QNo&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=22
// https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=0&page=1&query=category[]Dynamic%20Programmingdifficulty[]0page1category[]Dynamic%20Programming

public class Video_11_Maximum_Sum_Non_Adjacent_Elements {
    // https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        int inc = arr[0];
        int exc = 0;
        for(int i= 1;i<arr.length;i++)
        {
            int ninc = exc + arr[i];
            int nexc = Math.max(inc,exc);
            inc = ninc;
            exc = nexc;
        }
        return Math.max(inc,exc);
    }

    public static void main(String[] args) {

    }
}
