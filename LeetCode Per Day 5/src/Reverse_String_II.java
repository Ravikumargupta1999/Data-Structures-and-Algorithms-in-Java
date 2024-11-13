public class Reverse_String_II {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        reverse(sb,0,Math.min(k-1,s.length()-1));
        return sb.toString();
    }
    public void reverse(StringBuilder sb,int start,int end){
        while (start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
}
