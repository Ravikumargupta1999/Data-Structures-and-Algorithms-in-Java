package Google_Tagged_Leetcode_Question;

import java.util.ArrayList;

public class Leet_Code_318_Maximum_Product_of_Word_Lengths {
    public int maxProduct(String[] words) {
        ArrayList<boolean[]> list = new ArrayList<>();
        for (String word : words) {
            boolean[] arr = new boolean[26];
            for (char ch : word.toCharArray()) {
                arr[ch - 'a'] = true;
            }
            list.add(arr);
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {

            for (int j = i; j < words.length; j++) {
                boolean flag = false;
                for (int k = 0; k < 26; k++) {
                    if (list.get(i)[k] && list.get(j)[k]) {
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    max = Math.max(max,words[i].length() * words[j].length());
            }
        }
        return max;
    }
}
