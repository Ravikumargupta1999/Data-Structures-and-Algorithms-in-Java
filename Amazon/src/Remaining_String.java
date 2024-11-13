public class Remaining_String {
    //https://practice.geeksforgeeks.org/problems/remaining-string3515/1/?company[]=Oracle&company[]=Oracle&page=2&query=company[]Oraclepage2company[]Oracle

    static String printString(String s, char ch, int temp) {
        if (temp == 0)
            return s;
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ch)
                count++;
            if (count >= temp)
                return s.substring(i + 1);
        }
        return "Empty string";
    }

    public static void main(String[] args) {
        System.out.println(printString("Thisisdemostring", 'i', 3));
    }
}
