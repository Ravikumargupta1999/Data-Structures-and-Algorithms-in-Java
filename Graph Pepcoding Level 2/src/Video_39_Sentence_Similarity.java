import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Video_39_Sentence_Similarity {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] sentence1 = br.readLine().split(" ");
        String[] sentence2 = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());

        String[][] pairs = new String[m][2];
        for (int i = 0; i < m; i++) {
            pairs[i] = br.readLine().split(" ");
        }

        System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

    }

    static HashMap<String, String> parent;
    static HashMap<String, Integer> rank;

    public static boolean areSentencesSimilarTwo(String[] sen1, String[] sen2, String[][] pairs) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        if (sen1.length != sen2.length)
            return false;
        for (String[] p : pairs) {
            union(p[0], p[1]);
        }
        for (int i = 0; i < sen1.length; i++) {
            String w1 = sen1[i];
            String w2 = sen2[i];
            if (!w1.equals(w2) && !find(w1).equals(find(w2)))
                return false;
        }
        return true;
    }

    public static void union(String x, String y) {
        String lx = find(x);
        String ly = find(y);
        if (!lx.equals(ly)) {
            if (rank.get(lx) > rank.get(ly)) {
                parent.put(ly, lx);
            } else if (rank.get(lx) < rank.get(ly)) {
                parent.put(lx, ly);
            } else {
                parent.put(lx, ly);
                rank.put(ly, rank.get(ly) + 1);
            }
        }
    }

    public static String find(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            rank.put(x, 1);
        }
        if (x.equals(parent.get(x)))
            return x;
        String temp = find(parent.get(x));
        parent.put(x, temp);
        return temp;
    }

}
