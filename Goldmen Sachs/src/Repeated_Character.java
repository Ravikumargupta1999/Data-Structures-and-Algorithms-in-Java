import java.util.HashMap;
import java.util.HashSet;
//https://practice.geeksforgeeks.org/problems/repeated-character2058/1/?company[]=Goldman%20Sachs&company[]=Goldman%20Sachs&page=3&query=company[]Goldman%20Sachspage3company[]Goldman%20Sachs

public class Repeated_Character {

    char firstRep(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        for(int i=0;i<s.length();i++)
            if(map.get(s.charAt(i))>1)
                return s.charAt(i);
        return '#';
    }
}
