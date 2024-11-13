import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Words_K_Length_Words_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (!unique.contains(ch)) {
                unique.add(ch);
                ustr += ch;
            }
        }
        unique.removeAll(unique);
        fun(ustr, unique, 0, k, "", 0);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

    }

    static List<String> list = new ArrayList<>();

    public static void fun(String str, HashSet<Character> set, int cs, int ts, String asf, int index) {
        if (cs > ts)
            return;
        if (cs == ts) {
            list.add(asf);
            return;
        }
        if (index == str.length()) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                fun(str, set, cs + 1, ts, asf + str.charAt(i), i);
                set.remove(str.charAt(i));
            }
        }
    }

}
//aabbbccdde
//        3

//    abc
//            abd
//    abe
//            acb
//    adb
//            aeb
//    acd
//            ace
//    adc
//            aec
//    ade
//            aed
//    bac
//            bad
//    bae
//            cab
//    dab
//            eab
//    cad
//            cae
//    dac
//            eac
//    dae
//            ead
//    bca
//            bda
//    bea
//            cba
//    dba
//            eba
//    cda
//            cea
//    dca
//            eca
//    dea
//            eda
//    bcd
//            bce
//    bdc
//            bec
//    bde
//            bed
//    cbd
//            cbe
//    dbc
//            ebc
//    dbe
//            ebd
//    cdb
//            ceb
//    dcb
//            ecb
//    deb
//            edb
//    cde
//            ced
//    dce
//            ecd
//    dec
//            edc