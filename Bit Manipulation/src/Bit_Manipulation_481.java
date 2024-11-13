import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bit_Manipulation_481 {
    // https://practice.geeksforgeeks.org/problems/power-set4302/1
    public static List<String> AllPossibleStrings(String s) {

// 000
// 001
// 010
// 011
// 100
// 101
// 110
// 111
// }
        List<String> list = new ArrayList<>();
        for (int i = 1; i < (1 << s.length()); i++) {
            String temp = "";
            for (int j = 0; j < s.length(); j++) {
                if ((i &(1 << j)) >0){
                    temp += (s.charAt(j));
                }
            }
            list.add(temp);
        }
        Collections.sort(list,(a, b)->{
            for (int i=0;i<Math.min(a.length(),b.length());i++){
                if(a.charAt(i) != b.charAt(i))
                    return a.charAt(i) - b.charAt(i);
            }
            return a.length() - b.length();
        });
        return list;
    }

    public static void main(String[] args) {
        System.out.println(AllPossibleStrings("abc"));
    }

}
