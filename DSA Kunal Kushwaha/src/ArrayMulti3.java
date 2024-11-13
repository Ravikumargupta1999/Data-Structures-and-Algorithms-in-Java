import java.util.Arrays;

public class ArrayMulti3 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5}, {3, 5, 6, 7}};
        for (int i = 0; i < arr.length;i++)
        {
            for(int j=0;j< arr[i].length;j++)
            {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");

        for (int i = 0; i < arr.length;i++)
        {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
