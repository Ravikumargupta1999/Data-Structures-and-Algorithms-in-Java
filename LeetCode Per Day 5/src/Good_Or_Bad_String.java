public class Good_Or_Bad_String {
    public static void main(String[] args) {
        String str = "aeioup??";
        System.out.println(isGoodOrBad(str));
    }
    static int isGoodOrBad(String S) {
        int vowel = 0;
        int consonant = 0;
        for (char ch : S.toCharArray()){
            if(isVowel(ch)){
                vowel++;
                consonant = 0;
            }else if(ch != '?' ) {
                consonant++;
                vowel = 0;
            }else {
                consonant++;
                vowel++;
            }
//            System.out.println(ch +"    "+consonant+"      "+vowel);
            if(consonant > 3 || vowel > 5)
                return 0;

        }
        return 1;
    }
    static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' ||ch == 'o' ||ch == 'u' ;
    }
}
