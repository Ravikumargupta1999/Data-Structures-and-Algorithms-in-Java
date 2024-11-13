import java.util.HashMap;
// Bit manipulation ke notes mein 2nd sumit malik ke video ke pahele notes mein
// https://www.youtube.com/watch?v=SIh3RfFPQwU
// https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1/?category[]=Map&category[]=Map&page=1&query=category[]Mappage1category[]Map#
public class Heap_Longest_K_Unique_Characters_Cubstring {
    public static int longestkSubstr(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int i = -1;
        int j = -1;
        while (true)
        {
            boolean f1 = false;
            boolean f2 = false;
            while (i<s.length()-1)
            {
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size() < k)
                    continue;
                else if(map.size() == k)
                {
                    int len = i-j;
                    if(len >ans)
                        ans = len;
                }
                else
                    break;

            }
            while (j<i)
            {
                f2 = true;
                j++;
                char ch = s.charAt(j);
                if(map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(ch,map.get(ch)-1);
                if(map.size()>k)
                    continue;
                else if(map.size()==k)
                {
                    int len = i-j;
                    if(len > ans)
                        ans = len;
                    break;
                }
            }
            if(f1 == false && f2 == false)
                break;
        }
        if(ans == 0)
            return -1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aabacbebebe",3));
    }
}
