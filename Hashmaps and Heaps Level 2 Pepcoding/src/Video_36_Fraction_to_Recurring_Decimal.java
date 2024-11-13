import java.util.HashMap;

public class Video_36_Fraction_to_Recurring_Decimal {
    // https://practice.geeksforgeeks.org/problems/a-simple-fraction0921/1
    public String fractionToDecimal(int numerator, int denominator) {
        int q = numerator / denominator;
        int r = numerator % denominator;
        if (r == 0)
            return q + "";
        StringBuilder sb = new StringBuilder();
        sb.append(q);
        if (r == 0)
            return sb.toString();
        else {
            sb.append(".");
            HashMap<Integer, Integer> map = new HashMap<>();
            while (r != 0) {
                if (map.containsKey(r)) {
                    int len = map.get(r);
                    sb.insert(len, "(");
                    sb.append(")");
                    break;
                } else {
                    map.put(r, sb.length());
                    r *= 10;
                    q = r / denominator;
                    r = r % denominator;
                    sb.append(q);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {


    }
}
