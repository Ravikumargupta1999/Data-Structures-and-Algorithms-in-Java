public class Find_the_Duplicate_Number {
    public static int findDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == arr.length+1)
                continue;
            while (arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                if(arr[i] == arr.length+1 || arr[arr[i]-1] ==arr[i])
                    break;
            }
        }
        for(int i=0;i<arr.length;i++)
            if(arr[i] != i+1)
                return arr[i];
        return arr.length;

    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,1,2}));
    }
}
