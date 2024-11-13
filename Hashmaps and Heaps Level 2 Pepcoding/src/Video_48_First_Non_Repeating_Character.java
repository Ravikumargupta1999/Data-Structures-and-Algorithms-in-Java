import java.util.HashMap;

public class Video_48_First_Non_Repeating_Character {
    // https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/1/
    static char nonRepeatingCharacter(String arr) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length(); i++)
            map.put(arr.charAt(i), map.getOrDefault(arr.charAt(i), 0) + 1);
        for (int i = 0; i < arr.length(); i++)
            if (map.get(arr.charAt(i)) == 1)
                return arr.charAt(i);
        return '$';
    }
}
