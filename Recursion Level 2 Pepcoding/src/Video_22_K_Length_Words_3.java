import java.util.HashMap;

public class Video_22_K_Length_Words_3 {
    public static void main(String[] args) throws Exception {

        String str = "geeksforgeeks";
        int k = 3;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), -1);
        }
        fun(str,map,0,new Character[k],0,k);
        System.out.println(count+"  ");
    }
    static int count =0;
    public static void fun(String str,HashMap<Character,Integer> map,int idx,Character[] spots,int ssf,int ts)
    {
        if(idx == str.length())
        {
            if(ssf == ts)
            {
                count++;
                for(int i=0;i<spots.length;i++)
                    System.out.print(spots[i]+" ");
                System.out.println();
            }
            return;
        }
        char ch = str.charAt(idx);
        int lo = map.get(ch);
        for(int i=lo + 1;i<spots.length;i++)
        {
            if(spots[i] == null)
            {
                spots[i] = ch;
                map.put(ch,i);
                fun(str,map,idx+1,spots,ssf+1,ts);
                spots[i] = null;
                map.put(ch,lo);

            }
        }
        if(lo == -1)
            fun(str,map,idx+1,spots,ssf,ts);
    }
}
