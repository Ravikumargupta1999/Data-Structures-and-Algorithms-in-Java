import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/find-first-and-last-occurrence-of-x0849/1/?company[]=Amazon&company[]=Amazon&page=1&category[]=Binary%20Search&query=company[]Amazonpage1company[]Amazoncategory[]Binary%20Search

public class Left_most_and_right_most_index {
    class pair {
        long first, second;

        public pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public pair indexes(long arr[], long target) {
        pair p = new pair(-1, -1);
        int[] ans = {-1, -1};
        long start = search(arr, target, true);
        long end = search(arr, target, false);
        p.first = start;
        p.second = end;
        return p;
    }

    public long search(long[] arr, long target, boolean firstIndex) {
        long ans = -1;
        long start = 0;
        long end = arr.length - 1;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (arr[(int) mid] < target)
                start = mid + 1;
            else if (arr[(int)mid] > target)
                end = mid - 1;
            else {
                ans = mid;
                if (firstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Left_most_and_right_most_index a = new Left_most_and_right_most_index();
        pair p = a.indexes(new long[]{1, 3, 5, 5, 5, 5, 67, 123, 125},4);
        System.out.println(p.first+"   "+p.second);
    }
}
