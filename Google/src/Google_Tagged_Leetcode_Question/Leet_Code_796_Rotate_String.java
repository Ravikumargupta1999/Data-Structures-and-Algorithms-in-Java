package Google_Tagged_Leetcode_Question;

public class Leet_Code_796_Rotate_String {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        int n = s.length();
        char[] arr = s.toCharArray();
        while (n-- > 0) {
            rotate(arr, 1);
            if (isSame(arr, goal))
                return true;
        }
        return false;
    }

    public boolean isSame(char[] arr, String goal) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != goal.charAt(i))
                return false;
        }
        return true;
    }

    public void rotate(char[] arr, int d) {
        int n = arr.length;
        d = d % n;
        reverse(arr, 0, n - d - 1);
        reverse(arr, n - d, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
