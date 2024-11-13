// https://practice.geeksforgeeks.org/problems/sum-of-bit-differences2937/1
// https://www.youtube.com/watch?v=L_fIn5TM3mM&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=25

public class Sum_of_Bit_Differences {
    long sumBitDifferences(int[] arr, int n) {
       long res =0;
       for(int i=0;i<32;i++)
       {
           long counton =0;
           for(int val : arr)
           {
               if((val & (1<<i)) != 0)
               {
                   counton++;
               }
           }
           long countoff = arr.length-counton;
           long diff = countoff*counton*2;
           res += diff;
       }
       return res;
    }

    public static void main(String[] args) {

    }
}
