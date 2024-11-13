public class Video_64_Rearrange_a_string {
    // https://practice.geeksforgeeks.org/problems/rearrange-a-string4100/1
    public static String arrangeString(String s) {
        int[] arr = new int[26];
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c))
                arr[c - 'A']++;
            else
                sum += Character.getNumericValue(c);
        }
        String str = "";
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i]; j++) {
                str += (char)('A' + i);
            }
        }
        return str + sum;


    }

    public static void main(String[] args) {
        int ch = ('z' - 'a');
        System.out.println(ch);


//        System.out.println(arrangeString("ACCBA10D2EW30"));
    }
}
