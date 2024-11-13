package Biweekly_Contest_88;

public class P3 {
    public boolean equalFrequency(String word) {
        int[] arr = new int[26];
        for (char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }
        int ev = 0;
        int odd = 0;
        for (int val : arr) {
            if (val == 0)
                continue;
            if (val % 2 == 0)
                ev++;
            else
                odd++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0)
                continue;
            arr[i]--;
            if (fun(arr, i))
                return true;
            arr[i]++;
        }
        return false;
    }

    public boolean fun(int[] arr, int i) {
        int val = -1;
        for (int j = 0; j < 26; j++) {
            if (arr[j] == 0)
                continue;
            if (val == -1) {
                val = arr[j];
                continue;
            }
            if (arr[j] != val)
                return false;
        }
        return true;
    }
}
