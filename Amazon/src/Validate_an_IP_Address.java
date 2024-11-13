public class Validate_an_IP_Address {
//https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1/?category[]=Strings&category[]=Strings&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=category[]Stringscompany[]Amazondifficulty[]1page1company[]Amazoncategory[]Strings#

    public static boolean isValid(String s) {
        if (s.length() < 7)
            return false;
        int dot = 0;
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                continue;
            else if (s.charAt(i) == '.' && s.charAt(i + 1) != '.') {
                dot++;
                continue;
            } else
                return false;
        }
//        System.out.println("Hello");
        if (dot != 3)
            return false;
        if (s.charAt(s.length() - 1) == '.')
            return false;

        int num = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '.') {
                int a = s.charAt(i) - '0';
                num = num * 10 + a;
                len++;
            } else {
                if (num >= 0 && num < 256) {
                    count++;
                    if (num == 0) {
                        if (len != 1)
                            return false;
                    } else {
                        if (len != noOfDigit(num, 10))
                            return false;
                    }
                    num = 0;
                    len = 0;
                } else {
                    return false;
                }
            }
        }
        if (num >= 0 && num < 256) {
            count++;
            if (num == 0) {
                if (len != 1)
                    return false;
            } else {
                if (len != noOfDigit(num, 10))
                    return false;
            }
        }

        if (count == 4)
            return true;
        return false;
    }

    public static int noOfDigit(int n, int b) {
        return (int) (Math.log(n) / Math.log(b)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(isValid("0.0.0.0"));
    }
}
