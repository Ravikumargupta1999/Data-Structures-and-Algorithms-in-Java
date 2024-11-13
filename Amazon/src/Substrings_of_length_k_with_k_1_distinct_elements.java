import java.util.HashMap;
import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/substrings-of-length-k-with-k-1-distinct-elements/1/

public class Substrings_of_length_k_with_k_1_distinct_elements {
    //  Time Limit Exceed
    static int countOfSubstrings(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length() - k + 1; i++) {
//            System.out.println(s.substring(i, i + k));
            if (countCharacter(s.substring(i, i + k)) == k - 1)
                count++;
        }
        return count;
    }

    public static int countCharacter(String str) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++)
            set.add(str.charAt(i));
        return set.size();
    }


    // Accepted
    static int countOfSubstrings1(String s, int k) {

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<k-1;i++)
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        int j=0;
        int count = 0;
        for(int i = k-1;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            System.out.println(map);
            if(map.size() == k-1)
                count++;
//            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)-1);
            if(map.get(s.charAt(j)) > 1)
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)-1);
            else
                map.remove(s.charAt(j));

            j++;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings1("aabab", 1));
    }
}
