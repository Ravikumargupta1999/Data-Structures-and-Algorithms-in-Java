import java.util.ArrayList;

public class Decode_String {
    static char decodeIt(String str,int k){
        ArrayList<String> al = new ArrayList<>();
        int start = 0;
        for(int i=0;i<str.length()-1;i++)
        {
            if(Character.isDigit(str.charAt(i+1)))
            {
                al.add(str.substring(start,i+1));
                al.add(""+str.charAt(i+1));
                start = i+2;
            }
        }
        System.out.println(al);
        String result = "";
        for(int i=0;i<al.size();i+=2)
        {
            String temp = "" + al.get(i+1);
            System.out.println(temp);
            int val = Integer.parseInt(temp);
            while (val -- > 0)
                result = result + al.get(i);
        }
        System.out.println(result);
        if(k > result.length())
            return ' ';
        return result.charAt(k-1);
    }

    public static void main(String[] args) {
        System.out.println(decodeIt("ps3mkkrmuo8uuy7eo5bzi8",17));
    }
}
