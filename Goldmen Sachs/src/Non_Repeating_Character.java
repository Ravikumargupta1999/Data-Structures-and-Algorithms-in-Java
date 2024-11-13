import java.util.HashMap;
// https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/1/?company[]=Goldman%20Sachs&company[]=Goldman%20Sachs&page=1&query=company[]Goldman%20Sachspage1company[]Goldman%20Sachs#

public class Non_Repeating_Character {
    static char non_repeating_Character(String arr)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length();i++)
            map.put(arr.charAt(i),map.getOrDefault(arr.charAt(i),0)+1);
        for(int i=0;i<arr.length();i++)
            if(map.get(arr.charAt(i)) == 1)
                return arr.charAt(i);
        return '$';
    }
}
