// https://practice.geeksforgeeks.org/problems/possible-groups2013/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=2&query=category[]Arrayscompany[]Amazondifficulty[]1page2company[]Amazoncategory[]Arrays

public class Possible_Groups {
    long find_groups(int arr[], int n)
    {
//        int c[] = new int[]{0, 0, 0};
//        int i;
//
//        long res = 0; // To store the result
//        for (i = 0; i < n; i++)
//            c[arr[i] % 3]++;
//        res += ((c[0] * (c[0] - 1)) >> 1);
//        res += c[1] * c[2];
//        res += (c[0] * (c[0] - 1) * (c[0] - 2)) / 6;
//        res += (c[1] * (c[1] - 1) * (c[1] - 2)) / 6;
//        res += ((c[2] * (c[2] - 1) * (c[2] - 2)) / 6);
//        res += c[0] * c[1] * c[2];
//        return res;
        int C[] = { 0, 0, 0 };

        // Increment group with specified remainder
        for (int i = 0; i < n; ++i)
            ++C[arr[i] % 3];

        // Return groups using the formula
        return C[1] * C[2] + C[0] * (C[0] - 1) / 2 + C[0] * (C[0] - 1) * (C[0] - 2) / 6 + C[1] * (C[1] - 1) * (C[1] - 2) / 6 + C[2] * (C[2] - 1) * (C[2] - 2) / 6 + C[0] * C[1] * C[2];
    }
}
