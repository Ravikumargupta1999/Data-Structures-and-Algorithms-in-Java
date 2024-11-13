// https://practice.geeksforgeeks.org/problems/decode-the-pattern1138/1#
public class Look_And_Say {
    static String lookAndSay(int n) {
        if( n == 1)
            return "1";
        else if( n == 2)
            return "11";
        String[] result = new String[n + 1];
        result[1] = "1";
        result[2] = "11";
        for (int i = 3; i <= n; i++) {
            String last = result[i - 1];
            String temp = "";
            for (int j = 0; j < last.length(); j++) {
                int count = 1;
                while (j < last.length() - 1 && last.charAt(j) == last.charAt(j + 1)) {
                   // System.out.println("Inside while : "+count + "  " + j + "  " + last.charAt(j));
                    count++;
                    j++;
                }
                //System.out.println(count + "  " + j + "  " + last.charAt(j));
                temp += count + "" + last.charAt(j);

            }
            System.out.println(temp);
            result[i] = temp;
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(lookAndSay(3));
        String str1 = "13211311123113112211";
        String str2 = "13211311123113112211";
        System.out.println(str1.compareTo(str2));
    }
}
