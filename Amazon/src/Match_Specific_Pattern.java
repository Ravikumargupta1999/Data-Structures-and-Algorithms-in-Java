import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// https://practice.geeksforgeeks.org/problems/match-specific-pattern/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=2&query=company[]Amazondifficulty[]0page2company[]Amazon

public class Match_Specific_Pattern {
    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
    {
        ArrayList<String> al = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int l =1;
        for(int i=0;i<pattern.length();i++)
        {
            if(map.containsKey(pattern.charAt(i)))
                continue;
            else
            {
                map.put(pattern.charAt(i),l++);
            }
        }
        String temp = "";
        for(int i=0;i<pattern.length();i++)
        {
            temp = temp + map.get(pattern.charAt(i));
        }
        System.out.println(temp);

        for(int j=0;j<dict.size();j++)
        {
            String str = dict.get(j);
            HashMap<Character,Integer> map1 = new HashMap<>();
            int l1 =1;
            for(int i=0;i<str.length();i++)
            {
                if(map1.containsKey(str.charAt(i)))
                    continue;
                else
                {
                    map1.put(str.charAt(i),l1++);
                }
            }
            String temp1 = "";
            for(int i=0;i<str.length();i++)
            {
                temp1 = temp1 + map1.get(str.charAt(i));
            }
            System.out.println(temp1);
            if(temp.compareTo(temp1) == 0)
                al.add(str);
        }

        return al;
    }

    public static void main(String[] args) {
        int N = 4;
        ArrayList<String> dict= new ArrayList<>();
        dict.add("abb");
        dict.add("abc");
        dict.add("xyz");
        dict.add("xyy");
        String pattern  = "foo";
        System.out.println(findMatchedWords(dict,pattern));
    }
}
// {abb,abc,xyz,xyy}