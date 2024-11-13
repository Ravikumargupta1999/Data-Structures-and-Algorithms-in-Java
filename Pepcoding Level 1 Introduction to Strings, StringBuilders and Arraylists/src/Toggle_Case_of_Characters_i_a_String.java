//import javafx.beans.binding.StringBinding;
////
public class Toggle_Case_of_Characters_i_a_String {
    public static void main(String[] args) {
        String str = "aAjfHKkfGgksyiwpHJDjd";
        System.out.println(str);
        System.out.println(toggleCharacter(str));
    }
    static String toggleCharacter(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z')
            {
                sb.setCharAt(i,(char)('A'+ch-'a'));
            }
            else if(ch >= 'A' && ch <= 'Z')
            {
                sb.setCharAt(i,(char)('a'+ch-'A'));
            }
        }
        return sb.toString();
    }
}
