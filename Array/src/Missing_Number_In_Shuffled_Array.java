public class Missing_Number_In_Shuffled_Array {
    public long findMissing(long a[], long b[], int n) {
        long value = 0;
        for(int i=0;i<n-1;i++)
        {
            value = value^a[i]^b[i];
        }
        value = value^a[n-1];
        return value;
    }
    public static void main(String[] args) {

    }
}
// https://practice.geeksforgeeks.org/problems/missing-number-in-shuffled-array0938/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-1&page=4&query=category[]Arraysdifficulty[]-1page4category[]Arrays#