import java.util.HashMap;

public class Most_frequent_word_in_an_array_of_strings {
    public static String mostFrequentWord(String arr[], int n) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String st : arr) {
            map.put(st, map.getOrDefault(st, 0) + 1);
            max = Math.max(max, map.get(st));
        }
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == max) {
                res = arr[i];
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "xejdcj xejdcj lvjpb tmyuiu lvjpb tmyuiu ovoba lvjpb lvjpb fqhyu fqhyu tmyuiu xejdcj tmyuiu fqhyu ovoba xejdcj";
        String[] arr = s.split(" ");
        System.out.println(mostFrequentWord(arr, arr.length));
    }
}
