import java.util.ArrayList;
import java.util.List;

public class Video_45_Sequential_Digits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            if (isSequential(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isSequential(int val) {
        int pre = val % 10;
        val = val / 10;
        while (val > 0) {
            int next = val % 10;
            val = val / 10;
            if (pre != next + 1)
                return false;
            pre = next;

        }
        return true;
    }

    // https://leetcode.com/problems/sequential-digits/submissions/
    public List<Integer> sequentialDigits1(int low, int high) {
        int[] arr = {12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789

        };
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : arr) {
            if (val >= low && val <= high)
                list.add(val);
        }
        return list;

    }

    public static void main(String[] args) {
        Video_45_Sequential_Digits a = new Video_45_Sequential_Digits();
        System.out.println(a.sequentialDigits(1000, 13000));
    }
}
