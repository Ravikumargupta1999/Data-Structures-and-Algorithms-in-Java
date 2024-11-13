public class Add_two_numbers_represented_by_two_arrays {

    static String calc_Sum(int[] a, int n, int[] b, int m) {
        StringBuilder ans = new StringBuilder("");
        int i = n - 1;
        int j = m - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = i >= 0 ? a[i--] : 0;
            sum += j >= 0 ? b[j--] : 0;
            sum += carry;
            int d = sum % 10;
            carry = sum / 10;
            ans.insert(0,d);
        }
        for(int k=0;k<ans.length();k++)
        {
            if(ans.charAt(k) != '0')
                return ans.substring(k).toString();
        }
        return "0";
    }

    public static void main(String[] args) {
        int A[] = {9, 5, 4, 9};
        int B[] = {2, 1, 4};
        System.out.println(calc_Sum(A,A.length,B,B.length));
    }
}
