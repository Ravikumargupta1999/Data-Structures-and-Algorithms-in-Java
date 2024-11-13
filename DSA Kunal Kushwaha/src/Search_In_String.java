public class Search_In_String {
    static boolean search(String str,char ch)
    {
        if(str.length() == 0)
            return false;
        for(int i=0;i<str.length();i++)
            if(str.charAt(i) == ch)
                return true;
        return false;
    }
    public static void main(String[] args) {
        String str = "Rishika";
        System.out.println(search(str,'R'));
    }
}
