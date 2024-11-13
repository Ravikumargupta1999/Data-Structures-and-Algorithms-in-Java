// https://practice.geeksforgeeks.org/problems/minimum-steps-to-make-product-equal-to-one/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=13&query=company[]Amazondifficulty[]0page13company[]Amazon

public class Minimum_Steps_To_Make_Product_1 {
    static int MinStep(int a[], int n)
    {
        int steps = 0;
        int zeros = 0;
        int negative = 0;
        for(int i=0;i<n;i++)
        {
            if(a[i] > 0)
            {
                steps += (a[i]-1);
            }
            else if(a[i] == 0)
            {
                zeros++;
            }
            else if(a[i] < 0)
            {
                negative++;
                steps +=(-a[i] - 1);
            }
        }
        if(negative % 2 == 0)
            steps +=(zeros);
        else
        {
            if(zeros > 0)
                steps += zeros;
            else
                steps += 2;
        }
        return steps;

    }
}
