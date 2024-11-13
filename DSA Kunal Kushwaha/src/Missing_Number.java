import java.util.Arrays;

public class Missing_Number {
    public static int missingNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr.length)
                continue;
            while (arr[i] != arr[arr[i]]) {
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
                if (arr[i] == arr.length)
                    break;
            }
        }
        for(int i=0;i<arr.length;i++)
            if(i != arr[i])
                return i;
        return arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 0, 1, 2};
        System.out.println(missingNumber(arr));
        System.out.println(Arrays.toString(arr));

    }
}
