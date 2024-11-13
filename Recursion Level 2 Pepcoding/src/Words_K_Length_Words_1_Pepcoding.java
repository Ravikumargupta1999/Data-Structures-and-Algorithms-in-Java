import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Words_K_Length_Words_1_Pepcoding {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }
//        System.out.println(ustr);
        genetare(0,ustr,0,k,new Character[k]);
    }
    public static void genetare(int cc,String str,int ssf,int ts,Character[] spots)
    {
//        System.out.println(Arrays.toString(spots)+" "+cc);
        if(cc == str.length())
        {
            if(ssf == ts)
            {
                for(int i=0;i<spots.length;i++)
                    System.out.print(spots[i]);
                System.out.println();
            }
            return;
        }
        char ch = str.charAt(cc);
        for(int i=0;i<spots.length;i++)
        {
            if(spots[i] == null)
            {
                spots[i] = ch;
                genetare(cc+1,str,ssf+1,ts,spots);
                spots[i] = null;
            }
        }
        genetare(cc+1,str,ssf,ts,spots);
    }

}
