//https://practice.geeksforgeeks.org/problems/partition-a-number-into-two-divisible-parts3605/1/?company[]=Oracle&company[]=Oracle&page=3&query=company[]Oraclepage3company[]Oracle#

public class Partition_a_number_into_two_divisible_parts {
    static String stringPartition(String temp, int a, int b) {
        if (temp.length() == 1)
            return "-1";
        // String temp = s;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        sb1.append(temp.charAt(0));
        sb2.append(temp.substring(1));
        // System.out.println(sb1 + "  " + sb2);
        if (Integer.parseInt(sb1.toString()) % a == 0 && Integer.parseInt(sb2.toString()) % b == 0)
            return sb1.toString() + " " + sb2.toString();

        for (int i = 1; i < temp.length() - 1; i++) {
            sb1.append(temp.charAt(i));
            sb2.deleteCharAt(0);
            if (Integer.parseInt(sb1.toString()) % a == 0 && Integer.parseInt(sb2.toString()) % b == 0)
                return sb1.toString() + " " + sb2.toString();
        }
        return "-1";
    }

    public long shortestUnorderedSubarray(long arr[], long n) {
        long end = -1;
        long max = arr[0];
        for (long i = 1; i < arr.length; i++) {
            if (max > arr[(int) i])
                end = i;
            else
                max = arr[(int) i];
        }
        long st = 0;
        long min = arr[(int) arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > min)
                st = i;
            else
                min = arr[(int) i];
        }
        return end - st + 1;
    }

    public static void main(String[] args) {
        System.out.println(stringPartition("12023452", 12, 5));
    }
}
