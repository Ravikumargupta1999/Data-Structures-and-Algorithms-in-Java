import java.util.Arrays;

public class Set_Mismatch {
    public static int[] findErrorNums(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
//                System.out.println(i + " hello");
                if(arr[arr[i]-1] ==arr[i])
                    break;

            }
        }
//        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] != i+1)
            {

                return new int[]{arr[i],i+1};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,1})));
    }
}
