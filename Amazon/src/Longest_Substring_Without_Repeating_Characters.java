import java.util.HashMap;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
//https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1/?category[]=Strings&category[]=Strings&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=category[]Stringscompany[]Amazondifficulty[]1page1company[]Amazoncategory[]Strings
public class Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < s.length()-1)
            {
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch) == 2)
                    break;
                else
                {
                    int len = i-j;
                    if(len > ans)
                        ans = len;
                }
            }
            while (j< i)
            {
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 1)
                    break;
            }
            if(f1 == false && f2 == false)
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
