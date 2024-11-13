import java.util.ArrayList;

public class PPP {
    public static void main(String[] args) {

    }

    public double[] convertTemperature(double celsius) {
        double[] arr = new double[2];
        arr[0] = celsius + 273.15;
        arr[1] = ((double) celsius * (double) 1.80) + 32.00;
        return arr;

    }


    static Long[] lcmAndGcd(Long a, Long b) {
        Long[] arr = new Long[2];
        arr[1] = gcd(a, b);
        arr[0] = (a * b) / arr[1];
        return arr;
    }

    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }


    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int currGcd = nums[i];
            if (currGcd == k) // if element is equal to k, increment answer
                ans++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < k) // if nums[j] < k gcd can never be equal to k for this subarray
                    break;
                currGcd = gcd(nums[j], currGcd);
                if (currGcd == k)
                    ans++;
            }
        }
        return ans;
    }




    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                list.add(nums[i]);
                if (lcm(list) == k)
                    ans++;
            }
        }
        return ans;
    }

    public int lcm(ArrayList<Integer> arr) {
        if (arr.size() == 1)
            return 1;
        int lcm = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            lcm =( (lcm * arr.get(i)) / gcd(lcm, arr.get(i)));
        }
        return lcm;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }


}
