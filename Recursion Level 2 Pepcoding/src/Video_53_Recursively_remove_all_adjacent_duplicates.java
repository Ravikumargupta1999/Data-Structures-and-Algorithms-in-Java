public class Video_53_Recursively_remove_all_adjacent_duplicates {
    //
//    String remove(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (char ch : s.toCharArray()){
//            if(stack.isEmpty())
//                stack.push(ch);
//            else {
//                if(stack.peek() !)
//            }
//        }
//    }
    // https://www.youtube.com/watch?v=dzNOBjv9tDs
    // https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1#
    String rremove(String s) {
        String s1 = "";
        while (s.length() != s1.length()) {
            s1 = s;
            s = solve(s);
        }
        return s;
    }

    String solve(String s) {
        int i = 0;
        StringBuilder res = new StringBuilder();
        int n = s.length();
        while (i < n) {
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                while (i < n - 1 && s.charAt(i) == s.charAt(i + 1))
                    i++;
            } else
                res.append(s.charAt(i));

            i++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Video_53_Recursively_remove_all_adjacent_duplicates a = new Video_53_Recursively_remove_all_adjacent_duplicates();
        System.out.println(a.rremove("abccbccba"));
    }
}
