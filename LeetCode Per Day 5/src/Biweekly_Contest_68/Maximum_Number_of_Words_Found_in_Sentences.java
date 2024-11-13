package Biweekly_Contest_68;

public class Maximum_Number_of_Words_Found_in_Sentences {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences){
            String[] arr = sentence.split(" ");
            max = Math.max(max,arr.length);
        }
        return max;
    }
}
