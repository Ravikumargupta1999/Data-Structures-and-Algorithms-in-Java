public class Recursively_Remove_All_Adjacent_Duplicates {
    public static String remove(String str)
    {
        String st = remove1(str,0);
        System.out.println(st);
        return st;
    }
  
    public static void main(String[] args) {
        System.out.println(remove("acaaabbbacdddd"));
    }
}
