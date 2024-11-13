public class Video_33_First_Bad_Version {
    //https://leetcode.com/problems/first-bad-version/submissions/
    public static int firstBadVersion(int n) {
        int li = 1;
        int hi = n;
        int ans = -1;
        while (li <= hi) {
            int mid = li + (hi - li) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                hi = mid - 1;
            } else
                li = mid + 1;
        }
        return ans;
    }

    static int bad = 0;

    static boolean isBadVersion(int version) {
        if (version >= bad)
            return true;
        else
            return false;
    }
}
