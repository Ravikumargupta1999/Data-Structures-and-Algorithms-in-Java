import java.util.Arrays;

public class Four_Elements {
    static  boolean find4Numbers(int A[], int n, int X)
    {
        Arrays.sort(A);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int start = j+1;
                int end = n-1;
                int num = (X-(A[i] + A[j]));
                while (start < end){
                    if(A[start] + A[end] == num)
                        return true;
                    if(A[start] + A[end] < num)
                        start++;
                    else
                        end--;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(find4Numbers(arr,arr.length,10));
    }
}
