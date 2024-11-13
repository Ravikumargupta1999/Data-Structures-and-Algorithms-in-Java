import java.util.HashMap;
// https://practice.geeksforgeeks.org/problems/remove-character3815/1/?company[]=Amazon&company[]=Amazon&page=2&query=company[]Amazonpage2company[]Amazon
public class Remove_Character {
    static String removeChars(String string1, String string2){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<string2.length();i++)
        {
            map.put(string2.charAt(i),map.getOrDefault(map.get(string2.charAt(i)),0)+1);
        }
        String str = "";
        for(int i=0;i<string1.length();i++)
            if(map.containsKey(string1.charAt(i)))
                continue;
            else
                str = str + string1.charAt(i);
        return str;
    }
}
