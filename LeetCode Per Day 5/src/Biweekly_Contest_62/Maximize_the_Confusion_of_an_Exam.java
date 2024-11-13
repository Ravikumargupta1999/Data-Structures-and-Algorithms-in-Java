package Biweekly_Contest_62;

// https://www.youtube.com/watch?v=QPfalDbqa4A

public class Maximize_the_Confusion_of_an_Exam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int j = -1;
        int ans = 0;
        int count = 0;

        for (int i = 0; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) == 'F')
                count++;
            while (count > k) {
                j++;
                if (answerKey.charAt(j) == 'F')
                    count--;
            }

            int temp = i - j;
            ans = Math.max(ans, temp);
        }

        int res = 0;
        j = -1;
        count = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) == 'T')
                count++;
            while (count > k) {
                j++;
                if (answerKey.charAt(j) == 'T')
                    count--;
            }

            int temp = i - j;
            res = Math.max(res, temp);
        }
        return Math.max(res, ans);
    }


    // https://www.youtube.com/watch?v=DSiU73hPbZg
    public int maxConsecutiveAnswer(String answerKey, int k) {
        int low = 1;
        int high = answerKey.length();
        int res = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(answerKey, mid, k)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public boolean isPossible(String str, int len, int k) {
        int t = 0;
        int f = 0;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'T')
                t++;
            if (str.charAt(i) == 'F')
                f++;
        }

        if (t <= k || f <= k)
            return true;
        int left = 0;
        int right = len - 1;

        while (right != str.length() - 1) {

            if (str.charAt(left) == 'T')
                t--;
            if (str.charAt(left) == 'F')
                f--;
            left++;
            right++;
            if (str.charAt( right) == 'T')
                t++;
            if (str.charAt( right) == 'F')
                f++;
            if (t <= k || f <= k)
                return true;
        }
        return false;
    }
}
