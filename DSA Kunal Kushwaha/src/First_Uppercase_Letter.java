public class First_Uppercase_Letter {
    public static char firstUpper(String str)
    {
        return firstUpperLetter(0,str);
    }
    public static char firstUpperLetter(int index,String str)
    {
        if(index == str.length())
            return '0';
        if(str.charAt(index) >= 'A' && str.charAt(index) < 'Z')
            return str.charAt(index);
        else
            return firstUpperLetter(index+1,str);
    }
    public static void main(String[] args) {
        System.out.println(firstUpper("Geeksforgeeks"));
    }
}
