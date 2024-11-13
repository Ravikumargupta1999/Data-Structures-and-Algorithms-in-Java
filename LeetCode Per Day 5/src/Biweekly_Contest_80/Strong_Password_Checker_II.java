package Biweekly_Contest_80;

public class Strong_Password_Checker_II {

//    It has at least 8 characters.
//    It contains at least one lowercase letter.
//    It contains at least one uppercase letter.
//    It contains at least one digit.
//    It contains at least one special character. The special characters are the characters in the following string: "!@#$%^&*()-+".
//    It does not contain 2 of the same character in adjacent positions (i.e., "aab" violates this condition, but "aba" does not).

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8)
            return false;
        int lower = 0;
        int upper = 0;
        int digit = 0;
        int special = 0;
        for (int i = 0; i < password.length(); i++) {
            if(i != password.length()-1 && password.charAt(i) == password.charAt(i+1))
                return false;
            char ch = password.charAt(i);
            if(Character.isDigit(ch))
                digit++;
            else if(Character.isUpperCase(ch))
                upper++;
            else if(Character.isLowerCase(ch))
                lower++;
            else
                special++;
        }
        if(lower > 0 && upper > 0  && digit > 0 && special > 0)
            return true;
        return false;

    }
}
