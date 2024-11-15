import java.util.Arrays;

public class Sum_triangle_from_array {
    public static void sumTriangle(int[] arr)
    {
        if( arr.length <= 1 ) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        int[] temp = new int[arr.length-1];
        for(int i=0;i<arr.length-1;i++)
            temp[i] = arr[i]+arr[i+1];
        sumTriangle(temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        sumTriangle(new int[]{1, 2, 3, 4, 5});
    }
}
