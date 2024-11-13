public class Facing_the_Sun {
    int countBuildings(int h[], int n) {
        int max = 1;
        int count = 1;
        for(int i=0;i<n;i++)
        {
            if(h[i] > max)
            {
                max = h[i];
                count++;
            }
        }
        return count;
    }
}
//https://practice.geeksforgeeks.org/problems/facing-the-sun2126/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0company[]Amazonpage5
