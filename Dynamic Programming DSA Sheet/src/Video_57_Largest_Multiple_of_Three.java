import java.util.Arrays;

public class Video_57_Largest_Multiple_of_Three {
    // https://leetcode.com/problems/largest-multiple-of-three/submissions/
    public String largestMultipleOfThree(int[] digits) {
        int n = digits.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += digits[i];
        }
        Arrays.sort(digits);
        if (sum % 3 == 0) {
            if (digits[n - 1] == 0)
                return "0";
            String s = "";
            for (int i = n - 1; i >= 0; i--) {
                s += ("" + digits[i]);
            }
            return s;
        } else if (sum % 3 == 1) {
            if (sum == 1) {
                return digits.length > 1 ? "0" : "";
            }
            boolean idealFound = false;
            for (int i = 0; i < n; i++) {
                if (digits[i] % 3 == 1) {
                    idealFound = true;
                    digits[i] = -1;
                    break;
                }
            }
            if (!idealFound) {
                int[] idex = new int[2];
                idex[0] = -1;
                idex[1] = -1;
                for (int i = 0; i < n; i++) {
                    if (digits[i] % 3 == 2) {
                        if (idex[0] == -1) {
                            idex[0] = i;
                        } else {
                            idex[1] = i;
                            break;
                        }
                    }
                }
                if (idex[1] != -1) {
                    digits[idex[0]] = -1;
                    digits[idex[1]] = -1;
                } else {
                    return "";
                }
            }
        } else {
            if (sum == 2) {
                boolean found = false;
                for (int i = 0; i < n; i++) {
                    if (digits[i] == 2) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    return digits.length > 1 ? ")" : "";
                }
            }
            boolean idealFound = false;
            for (int i = 0; i < n; i++) {
                if (digits[i] % 3 == 2) {
                    idealFound = true;
                    digits[i] = -1;
                    break;
                }
            }
            if (!idealFound) {
                int[] idex = new int[2];
                idex[0] = -1;
                idex[1] = -1;
                for (int i = 0; i < n; i++) {
                    if (digits[i] % 3 == 1) {
                        if (idex[0] == -1) {
                            idex[0] = i;
                        } else {
                            idex[1] = i;
                            break;
                        }
                    }
                }
                if (idex[1] != -1) {
                    digits[idex[0]] = -1;
                    digits[idex[1]] = -1;
                } else {
                    return "";
                }
            }
        }
        String ans = "";
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != -1)
                ans += ("" + digits[i]);
        }

        return ans;

    }

}
