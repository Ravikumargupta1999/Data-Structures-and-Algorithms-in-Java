import java.util.HashMap;

public class Video_11_Count_Substrings_without_Repeating_Characters {
    public static int countSubString(String s)
    {
        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        while (true)
        {
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
                    ans += (i-j);
            }
            while (j < i)
            {
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch) == 1)
                {
                    ans += (i-j);
                    break;
                }
            }
            if(!f1 && !f2)
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubString("gffg"));
    }
}
