import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class Practice_2_Generate_binary_string {
    // https://practice.geeksforgeeks.org/problems/generate-binary-string3642/1
    public List<String> generate_binary_string(String s)
    {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        generate(sb, 0, res);
        Collections.sort(res);
        return res;
    }

    static void generate(StringBuilder str, int i, List<String> res) {
        if (i == str.length()) {
            res.add(str.toString());
            return;
        }
        if (str.charAt(i) == '1' || str.charAt(i) == '0') {
            generate(str, i + 1, res);
        } else if (str.charAt(i) == '?') {
            str.setCharAt(i, '0');
            generate(str, i + 1, res);
            str.setCharAt(i, '1');
            generate(str, i + 1, res);
            str.setCharAt(i, '?');
        }
    }
}
