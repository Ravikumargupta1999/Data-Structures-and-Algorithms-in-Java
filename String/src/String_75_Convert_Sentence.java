public class String_75_Convert_Sentence {
    // https://www.codingninjas.com/codestudio/problems/convert-sentence_1115490?leftPanelTab=1
    public static String convertSentence(String str,int n)
    {
        String[] arr = {"2", "22", "222",
                "3", "33", "333",
                "4", "44", "444",
                "5", "55", "555",
                "6", "66", "666",
                "7", "77", "777", "7777",
                "8", "88", "888",
                "9", "99", "999", "9999"
        };
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - 'a';
            sb.append(arr[value]);
        }
        return sb.toString();
    }
}
