public class Even_Digit {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            if (Integer.toString(nums[i]).length() % 2 == 0)
                count++;
        return count;

    }

    public static int findNumber(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (even(arr[i]))
                count++;
        }
        return count;
    }

    static boolean even(int num) {
        int digit = 0;
        while (num > 0) {
            num = num / 10;
            digit++;
        }
        if(digit%2 == 0)
            return true;
        return false;
    }

    // optimized way

    static int count(int[] arr)
    {
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(((int)(Math.log10(arr[i])+1))%2 == 0)
                count++;
        }
        return count;
    }
}
