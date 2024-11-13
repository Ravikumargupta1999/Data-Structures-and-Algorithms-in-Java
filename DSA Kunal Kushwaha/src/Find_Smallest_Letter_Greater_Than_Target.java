public class Find_Smallest_Letter_Greater_Than_Target {
    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return letters[start % n];
    }

    public static void main(String[] args) {
        char[] arr = {'e', 'e', 'e', 'i', 'j'};
        System.out.println(nextGreatestLetter(arr, 'e'));
    }
}
