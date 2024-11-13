import org.omg.Messaging.SYNC_WITH_TRANSPORT;

// https://practice.geeksforgeeks.org/problems/2s-complement3124/1/?company[]=Adobe&company[]=Adobe&page=5&query=company[]Adobepage5company[]Adobe

import java.util.HashMap;

public class Twos_Complement {
    static String complement(String bi){
        java.util.HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : bi.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);

        }
        if(map.containsKey('0') == true)
        {
            if(map.get('0') == bi.length())
                return "0";
        }
        int j = bi.length()-1;
        String res = "";
        String bi1 = "";
        while (j>=0)
        {
            if(bi.charAt(j) == '0')
                bi1 = '1' + bi1;
            else
                bi1 = '0' + bi1;
            j--;
        }
        System.out.println(bi1);
        char rem = '1';
        String result = "";
        j = bi1.length()-1;
        while (j >= 0)
        {
            if(bi1.charAt(j) == '1' && rem == '1')
            {
                result = '0' + result;
                rem = '1';
            }
            else if(bi1.charAt(j) == '0' && rem == '0')
            {
                result = '0' +result;
                rem = '0';
            }
            else if(bi1.charAt(j) == '1' && rem == '0')
            {
                result = '1' + result;
                rem = '0';
            }
            else if(bi1.charAt(j) == '0' && rem == '1')
            {
                result = '1' +result;
                rem = '0';
            }
            j--;
        }
        if(rem == '1')
            result = '1' + result;
        System.out.println(result);
        return res;

    }

    public static void main(String[] args) {
        System.out.println(complement("0000"));
    }
}
