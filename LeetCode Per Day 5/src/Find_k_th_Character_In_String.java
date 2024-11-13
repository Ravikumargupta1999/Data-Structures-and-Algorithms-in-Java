public class Find_k_th_Character_In_String {
    char kthCharacter(int m, int n, int k) {
        String str = Integer.toBinaryString(m);

        while (n-- > 0) {
            String temp = "";
            for (char ch : str.toCharArray()) {
                if(ch == '0')
                    temp += "01";
                else
                    temp += "10";
            }
            str = temp;
        }
        return str.charAt(k-1);
    }
}
