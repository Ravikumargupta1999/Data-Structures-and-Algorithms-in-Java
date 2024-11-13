import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Video_24_K_Length_Words_4 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        String ustr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch) == true) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
                ustr += ch;
            }
        }
        fun(ustr,map,1,k,"");
    }
    public static void fun(String str,HashMap<Character,Integer> map,int cs,int ts,String asf)
    {
        if(cs == ts +1)
        {
            System.out.println(asf);
            System.out.println();
            return;
        }
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(map.get(ch) > 0)
            {
                map.put(ch,map.get(ch)-1);
                fun(str,map,cs+1,ts,asf+ch);
                map.put(ch,map.get(ch)+1);
            }
        }
    }

}
