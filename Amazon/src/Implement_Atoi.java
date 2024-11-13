import org.omg.Messaging.SYNC_WITH_TRANSPORT;
//https://practice.geeksforgeeks.org/problems/implement-atoi/1/?category[]=Strings&category[]=Strings&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=category[]Stringscompany[]Amazondifficulty[]1page1company[]Amazoncategory[]Strings

public class Implement_Atoi {
    static int atoi(String s) {
        boolean negative = false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                negative = true;
                continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                continue;
            else
                return -1;
        }
        int val = 0;
        if (negative) {
            for (int i = 1; i < s.length(); i++) {
                int a = s.charAt(i) - '0';
                val = val * 10 + a;
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                int a = s.charAt(i) - '0';
                val = val * 10 + a;
            }
        }
        if (negative)
            return val * (-1);
        return val;
    }

    public static void main(String[] args) {
        System.out.println(atoi("-566772234"));
    }
}
