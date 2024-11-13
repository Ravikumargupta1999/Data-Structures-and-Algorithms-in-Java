import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1/
// https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1/
// https://leetcode.com/problems/restore-ip-addresses/submissions/
public class String_87_Generate_IP_Addresses {
    public static ArrayList<String> genIp(String s) {
        ArrayList<String> list = new ArrayList<>();
        solve(s, 0, 0, "", list);
        return list;
    }

    public static void solve(String str, int i, int part, String asf, ArrayList<String> list) {
        if (i == str.length() || part == 4) {
            if (i == str.length() && part == 4) {
                list.add(asf.substring(0, asf.length() - 1));
            }
            return;
        }
        solve(str, i + 1, part + 1, asf + str.charAt(i) + ".", list);
        if (i + 2 <= str.length() && isValid(str.substring(i, i + 2))) {
            solve(str, i + 2, part + 1, asf + str.substring(i, i + 2) + ".", list);
        }
        if (i + 3 <= str.length() && isValid(str.substring(i, i + 3))) {
            solve(str, i + 3, part + 1, asf + str.substring(i, i + 3) + ".", list);
        }
    }

    public static boolean isValid(String str) {
        if (str.charAt(0) == '0')
            return false;
        return Integer.parseInt(str) <= 255;

    }

    public static void main(String[] args) {
        String str = "11211";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(i + "   " + str.substring(i));
        }

    }

}
