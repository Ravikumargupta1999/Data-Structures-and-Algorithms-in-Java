public class Next_Greater_Element_III {
    // https://leetcode.com/problems/next-greater-element-iii/submissions/
    public static int nextGreaterElement(int n) {
        String str = Integer.toString(n);
        if (str.length() == 1)
            return -1;
        StringBuilder sb = new StringBuilder(str);
        int i = sb.length() - 1;
        int j = sb.length() - 2;
        boolean found = false;
        while (j >= 0) {
            if (sb.charAt(j) < sb.charAt(j + 1)) {
                break;
            }
            j--;
        }
        if (j < 0)
            return -1;
        int val = j;
        System.out.println(sb.charAt(j));
        while (i > j) {
            if (sb.charAt(i) > sb.charAt(j)) {
                char temp1 = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp1);
                break;
            }
            i--;
        }

        j = val + 1;
        i = sb.length() - 1;
        while (i > j) {
            char temp1 = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp1);
            i--;
            j++;
        }
        long l = Long.parseLong(sb.toString());
        if( l > Integer.MAX_VALUE)
            return -1;
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(nextGreaterElement(230241));
    }
}
