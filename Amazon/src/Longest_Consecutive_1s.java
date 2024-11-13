public class Longest_Consecutive_1s {
    // https://practice.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1/?category[]=Bit%20Magic&category[]=Bit%20Magic&page=1&query=category[]Bit%20Magicpage1category[]Bit%20Magic

    public static int maxConsecutiveOnes(int n) {
        String str = Integer.toBinaryString(n);
        int ans = 0;
        int count = 0;
        if (str.charAt(0) == '1')
            count++;
//        System.out.println(str);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '1' && str.charAt(i - 1) == '1') {
                count++;
                if (count > ans)
                    ans = count;
            } else if (str.charAt(i) == '1') {
                count++;
                if (count > ans)
                    ans = count;
            } else
                count = 0;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(56552));
    }
}
