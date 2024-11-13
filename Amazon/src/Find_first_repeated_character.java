import java.util.HashMap;
import java.util.HashSet;
//https://practice.geeksforgeeks.org/problems/find-first-repeated-character4108/1/?company[]=Amazon&company[]=Amazon&page=3&category[]=Hash&query=company[]Amazonpage3company[]Amazoncategory[]Hash#
public class Find_first_repeated_character {
    String firstRepChar(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            if(map.get(s.charAt(i))>1)
                return s.charAt(i)+"";
        }
        return "-1";
    }
}
