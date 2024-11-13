public class A_Trie_15_Largest_Number_With_Given_sum {
    // https://practice.geeksforgeeks.org/problems/largest-number-with-given-sum-1587115620/1?page=1&status[]=unsolved&company[]=Amazon&company[]=Microsoft&company[]=Flipkart&company[]=Adobe&sortBy=submissions

    static String largestNumber(int n, int sum) {
        if (n * 9 < sum)
            return "-1";
        StringBuilder res = new StringBuilder();
        while (n-- > 0 || sum > 0) {
            if (sum > 0) {
                if (sum > 9) {
                    sum = sum - 9;
                    res.append("9");
                } else {
                    res.append(sum);
                    sum = 0;
                }
            } else if (sum < 0) {
                res.append("0");
            }
            return res.toString();
        }
        return "";
    }

    // https://practice.geeksforgeeks.org/problems/closest-number5728/1?page=1&difficulty[]=-1&status[]=unsolved&company[]=Amazon&company[]=Microsoft&company[]=Flipkart&company[]=Adobe&sortBy=submissions
    static int closestNumber(int N,int M) {
        if (N % M == 0)
            return N;

        int rem = N % M;

        if (rem  >= M / 2) {
            return N + (N/M);
        }else {
            return N - (N/M);
        }
    }

    public static void main(String[] args) {
        closestNumber(-15, 4);
    }
}
