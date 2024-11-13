package Biweekly_Contest_65;

public class Check_Whether_Two_Strings_are_Almost_Equivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] arr1 = new int[26];
        for (char ch : word1.toCharArray())
            arr1[ch - 'a']++;
        int[] arr2 = new int[26];
        for (char ch : word2.toCharArray())
            arr2[ch - 'a']++;
        for (int i = 0; i < arr1.length; i++) {
            if (Math.abs(arr1[i] - arr2[i]) > 3)
                return false;
        }
        return true;
    }
}
