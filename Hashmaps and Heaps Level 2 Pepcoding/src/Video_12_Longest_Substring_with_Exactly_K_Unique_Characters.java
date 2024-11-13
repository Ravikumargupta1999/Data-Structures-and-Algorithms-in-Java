import java.util.HashMap;

public class Video_12_Longest_Substring_with_Exactly_K_Unique_Characters {
    public int longestkSubstr(String s, int k) {
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
}
