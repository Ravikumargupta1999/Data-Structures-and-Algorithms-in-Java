import javax.xml.transform.Result;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//https://www.hackerrank.com/challenges/sparse-arrays/problem

public class Sparse_Arrays {
    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.size(); i++)
        {
            if(map.containsKey(strings.get(i)))
                map.put(strings.get(i),map.get(strings.get(i))+1);
            else
                map.put(strings.get(i),1);
        }
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            if (map.containsKey(queries.get(i)))
                al.add(map.get(queries.get(i)));
            else
                al.add(0);
        }
        return al;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = bufferedReader.readLine();
            strings.add(stringsItem);
        }

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = new ArrayList<>();

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = bufferedReader.readLine();
            queries.add(queriesItem);
        }

        List<Integer> res = matchingStrings(strings, queries);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
