package Biweekly_Contest_93;

public class Problem_4_ {
    public static void main(String[] args) {
        String[] strs = {"1","01","001","0001"};
        System.out.println(maximumValue(strs));
    }
    public static int maximumValue(String[] strs) {
        int max = 0;
        for (String st : strs){
            if(!isCOn(st)){
                max = Math.max(max,st.length());
            }else {
                max = Math.max(max,Integer.valueOf(st));
            }
        }
        return max;

    }
    static boolean isCOn(String s){
        for (char ch : s.toCharArray()){
            if(!Character.isDigit(ch))
                return false;
        }
        return true;
    }
}
