import java.util.ArrayList;
import java.util.List;

public class D_Dynamic_Programming_447_Word_Break_II {
    // https://practice.geeksforgeeks.org/problems/word-break-part-23249/1
    //
    static List<String> wordBreak(int n, List<String> dict, String s) {
        List<String> result = new ArrayList<>();
        findWordBreak(s, dict, result, "");
        return result;
    }

    static void findWordBreak(String str, List<String> dict, List<String> result, String ans) {
        if (str.length() == 0) {

            result.add(ans.substring(0,ans.length()-1));
            return;
        }

        for (int i = 0; i <= str.length(); i++) {
            String left = str.substring(0,i);
            String right = str.substring(i);



            if(dict.contains(left)){
                findWordBreak(right,dict,result,ans+""+left+" ");
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        int n = 5;
        String[] dict = {"cats", "cat", "and", "sand", "dog"};
        List<String> list = new ArrayList<>();
        for (String str : dict)
            list.add(str);
        System.out.println(wordBreak(n,list,s));
    }


}
