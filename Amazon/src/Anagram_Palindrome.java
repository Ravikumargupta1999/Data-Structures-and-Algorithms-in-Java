import java.util.Arrays;
import java.util.HashMap;
//https://practice.geeksforgeeks.org/problems/anagram-palindrome4720/1/?company[]=Amazon&company[]=Amazon&page=3&category[]=Hash&query=company[]Amazonpage3company[]Amazoncategory[]Hash
public class Anagram_Palindrome {
    static int isPossible(String str) {
        int NO_OF_CHARS = 256;
        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (int i = 0; i < str.length(); i++)
            count[(int)(str.charAt(i))]++;

        // Count odd occurring characters
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if ((count[i] & 1) == 1)
                odd++;

            if (odd > 1)
                return 0;
        }

        // Return true if odd count is 0 or 1,
        return 1;

        // HashMap<Character, Integer> map = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        // }
        // int count = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     if ((map.get(s.charAt(i)) & 1) == 1) {
        //         count++;
        //     }
        //     if (count > 1)
        //         return 0;
        // }

        // return 1;
    }

    public static void main(String[] args) {
        if (isPossible("epzshkljugggekjdqzjenpevqgxiepjsrdzjazujllchhbfqmkimwzobiwybxduunfsksrsrtekmqdcyzjeeuhmsrqcozijipfioneeddpszrnavymmtatbdzqsoemuvnpppsuacbazuxmhecthlegrpunkdmbppweqtgjopazepzshkljugggekjdqzjenpevqgxiepjsrdzjazujllchhbfqmkimwzobiwybxduunfsksrsrtekmqdcyzjeeuhmsrqcozijipfioneeddpszrnavymmtatbdzqsoemuvnpppsuacbazuxmhecthlegrpunkdmbppweqtgjopa") == 1)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
