import java.util.ArrayList;

public class Practice_14_Maximum_Sub_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(findSubArray(arr, arr.length));
    }

    // Right hai JAVA Ka test 337/340 wrong hai
    static ArrayList<Integer> findSubArray(int[] arr, int n) {
        int start = 0;
        int end = 0;
        int res = 0;


        int currSum = 0;
        int s = -1;
        int e = -1;

        int prev = -8;


        for (int i = 0; i < n; i++) {

            int val = arr[i];
            if (val < 0) {
                if ((currSum > res) || (currSum == res && e - s + 1 < end - start + 1)) {
                    s = start;
                    e = end;
                    res = currSum;
                }
                currSum = 0;

            } else {
                if (prev < 0) {
                    start = i;
                    end = i;
                } else
                    end++;
                currSum += val;
            }
            prev = val;
//            System.out.println(start + "   " + end + "    " + s + "     " + e + "     " + currSum + "    " + res);
        }
        if (currSum > res) {
            s = start;
            e = end;
            res = currSum;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (s >= 0) {
            for (int i = s; i <= e; i++)
                list.add(arr[i]);
        } else {

            list.add(-1);
        }
        return list;

    }

    // C++converted into java which is also giving wrong
    ArrayList<Integer> findSubarray(int[] arr, int n) {
        int j = 0, l = 0, r = -1, mx = 0, s = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                s += arr[i];
            } else {
                if (s > mx || (s == mx && i - j > r - l + 1)) {
                    mx = s;
                    l = j;
                    r = i - 1;
                }
                s = 0;
                j = i + 1;
            }
        }
        if (s > mx) {
            l = j;
            r = n - 1;
        }
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = l; i <= r; i++)
            v.add(arr[i]);
        if (v.size() == 0)
            v.add(-1);
        return v;
    }
}
