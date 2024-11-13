public class Count_number_of_words {
    static int countWords(String str)
    {

        int count = 1;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) == ' ' || str.charAt(i) == '\t' || str.charAt(i) == '\n')
                count++;
        }
        return count;
//        if (str == null || str.isEmpty())
//            return 0;
//        String[] words = str.split("\\s+");
//        return words.length;
    }

    public static void main(String[] args) {
        System.out.println(countWords("a\nhjpfo"));
    }
}
